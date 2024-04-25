package projetoshopeementoria.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import projetoshopeementoria.model.PessoaJuridica;
import projetoshopeementoria.model.Usuario;
import projetoshopeementoria.repository.PessoaRepository;
import projetoshopeementoria.repository.UsuarioRepository;

@Service
public class PessoaUserService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ServiceSendEmail serviceSendEmail;
	
	
	public PessoaJuridica salvarPessoaJuridica(PessoaJuridica juridica) {
		
		juridica = pessoaRepository.save(juridica);
		
		for(int i = 0; i< juridica.getEnderecos().size(); i++) {
			juridica.getEnderecos().get(i).setPessoa(juridica);
			juridica.getEnderecos().get(i).setEmpresa(juridica);
		}
		
		juridica = pessoaRepository.save(juridica);
		
		Usuario usuarioPj = usuarioRepository.findIserByPessoa(juridica.getId(), juridica.getEmail());
		
		if(usuarioPj == null) {
			
			String contraint = usuarioRepository.consultaConstraintAcesso();
			if(contraint != null) {
				jdbcTemplate.execute("begin; alter table usuarios_acesso drop constraint " + contraint + "; commit;");
			}
			
			usuarioPj = new Usuario();
			usuarioPj.setDataAtualSenha(Calendar.getInstance().getTime());
			usuarioPj.setEmpresa(juridica);
			usuarioPj.setPessoa(juridica);
			usuarioPj.setLogin(juridica.getEmail());
			
			String senha = "" + Calendar.getInstance().getTimeInMillis();
			String senhaCript = new BCryptPasswordEncoder().encode(senha);
			
			usuarioPj.setSenha(senhaCript);
			
			usuarioPj = usuarioRepository.save(usuarioPj);
			
			usuarioRepository.insereAcessoUserPj(usuarioPj.getId());
			
			StringBuilder mensagemHtml = new StringBuilder();
			
			mensagemHtml.append("<b>Sgue a baixo seus dados de acesso da loja virtual</b><br/>");
			mensagemHtml.append("<b>Login: </b> "+juridica.getEmail()+" </b> <br/>");
			mensagemHtml.append("<b>Senha: </b>").append(senha).append("<br/><br/>");
			mensagemHtml.append("Obrigado");
			
			
			try {
				serviceSendEmail.enviarEmailHtml("Envio de email de Bruno da loja Virtual", mensagemHtml.toString(), juridica.getEmail());
			}catch (Exception e) {
				e.printStackTrace();
			}                                      			
		}
		
		return juridica;
	}

}
