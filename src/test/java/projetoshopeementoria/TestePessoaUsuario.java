package projetoshopeementoria;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import junit.framework.TestCase;
import projetoshopeementoria.controller.PessoaController;
import projetoshopeementoria.enums.TipoEndereco;
import projetoshopeementoria.model.Endereco;
import projetoshopeementoria.model.PessoaJuridica;

@Profile("test")
@SpringBootTest(classes = ProjetoShopeeApplication.class)
public class TestePessoaUsuario extends  TestCase{
	
	
	@Autowired
	private PessoaController pessoaController;
	
	@Test
	public void testCadPessoaFisica() throws ExceptionMentoriaJava {
		
		PessoaJuridica pessoaJuridica =new PessoaJuridica();
		pessoaJuridica.setCnpj("" + Calendar.getInstance().getTimeInMillis());
		pessoaJuridica.setNome("Senhor antonio");
		pessoaJuridica.setEmail("brunobiuu@proton.me");
		pessoaJuridica.setTelefone("64646464546");
		pessoaJuridica.setEmpresa(pessoaJuridica);
		pessoaJuridica.setInscEstadual("955441456464");
		pessoaJuridica.setInscMunicipal("6644114665655");
		pessoaJuridica.setNomeFantasia("5654565466");
		pessoaJuridica.setRazaoSocial("555514554554");
		
		Endereco endereco1 = new Endereco();
		endereco1.setBairro("bairro");
		endereco1.setCep("95656");
		endereco1.setComplemento("casa cinza");
		endereco1.setEmpresa(pessoaJuridica);
		endereco1.setNumero("6565699898");
		endereco1.setPessoa(pessoaJuridica);
		endereco1.setRuaLogra("avenida");
		endereco1.setTipoendereco(TipoEndereco.COBRANCA);
		endereco1.setUf("go");
		endereco1.setCidade("cezarina");
		
		Endereco endereco2 = new Endereco();
		endereco2.setBairro("bairroX");
		endereco2.setCep("95656000");
		endereco2.setComplemento("casa cinzaX");
		endereco2.setEmpresa(pessoaJuridica);
		endereco2.setNumero("6565699898000");
		endereco2.setPessoa(pessoaJuridica);
		endereco2.setRuaLogra("avenida X");
		endereco2.setTipoendereco(TipoEndereco.COBRANCA);
		endereco2.setUf("SP");
		endereco2.setCidade("sao joao");
		
		pessoaJuridica.getEnderecos().add(endereco1);
		pessoaJuridica.getEnderecos().add(endereco2);
		
		pessoaJuridica = pessoaController.salvarPj(pessoaJuridica).getBody();
		
		assertEquals(true, pessoaJuridica.getId() > 0 );
		
		for (Endereco endereco : pessoaJuridica.getEnderecos()) {
			assertEquals(true, endereco.getId() > 0);
		}
		
		assertEquals(2, pessoaJuridica.getEnderecos().size());
		
	}

}
