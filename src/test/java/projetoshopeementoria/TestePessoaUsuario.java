package projetoshopeementoria;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import junit.framework.TestCase;
import projetoshopeementoria.controller.PessoaController;
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
		pessoaJuridica.setNome("eduardo");
		pessoaJuridica.setEmail("edaurdo@gmail.com");
		pessoaJuridica.setTelefone("664664546");
		pessoaJuridica.setEmpresa(pessoaJuridica);
		pessoaJuridica.setInscEstadual("9554456464");
		pessoaJuridica.setInscMunicipal("6644665655");
		pessoaJuridica.setNomeFantasia("5654565466");
		pessoaJuridica.setRazaoSocial("5555554554");
		
		pessoaController.salvarPj(pessoaJuridica);
		
	}

}
