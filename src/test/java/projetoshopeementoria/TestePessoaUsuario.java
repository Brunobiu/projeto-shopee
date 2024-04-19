package projetoshopeementoria;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import junit.framework.TestCase;
import projetoshopeementoria.model.PessoaFisica;
import projetoshopeementoria.model.PessoaJuridica;
import projetoshopeementoria.repository.PessoaRepository;
import projetoshopeementoria.service.PessoaUserService;

@Profile("test")
@SpringBootTest(classes = ProjetoShopeeApplication.class)
public class TestePessoaUsuario extends  TestCase{
	
	@Autowired
	private PessoaUserService pessoaUserService; 
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Test
	public void testCadPessoaFisica() {
		
		PessoaJuridica pessoaJuridica =new PessoaJuridica();
		pessoaJuridica.setCnpj("656565654464");
		pessoaJuridica.setNome("eduardo");
		pessoaJuridica.setEmail("edaurdo@gmail.com");
		pessoaJuridica.setTelefone("664664546");
		pessoaJuridica.setEmpresa(pessoaJuridica);
		pessoaJuridica.setInscEstadual("9554456464");
		pessoaJuridica.setInscMunicipal("6644665655");
		pessoaJuridica.setNomeFantasia("5654565466");
		pessoaJuridica.setRazaoSocial("5555554554");
		
		pessoaRepository.save(pessoaJuridica);
		
		
		/*
		PessoaFisica pessoaFisica = new PessoaFisica();
		
		pessoaFisica.setCpf("65656565464");
		pessoaFisica.setNome("eduardo");
		pessoaFisica.setEmail("edaurdo@gmail.com");
		pessoaFisica.setTelefone("664664546");
		pessoaFisica.setEmpresa(pessoaFisica);*/
		
		
	}

}
