package projetoshopeementoria;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import junit.framework.TestCase;
import projetoshopeementoria.controller.AcessoController;
import projetoshopeementoria.model.Acesso;
import projetoshopeementoria.repository.AcessoRepository;
import projetoshopeementoria.service.AcessoService;

@SpringBootTest(classes = ProjetoShopeeApplication.class)
public class ProjetoShopeeApplicationTests extends  TestCase {

	
	
	@Autowired
	private AcessoController acessoController;
	
	@Autowired
	private AcessoRepository acessoRepository;
	
	
	@Test
	public void testCadastraAcesso() {
		
		Acesso acesso = new Acesso();
		
		acesso.setDescricao("ROLE_ADMIN");
		
		assertEquals(true, acesso.getId() == null);
		
		/*Gravou no banco de dados*/
		acesso = acessoController.salvarAcesso(acesso).getBody();	
		
		assertEquals(true, acesso.getId() > 0);
		
		/*Validar dados da forma correta*/
		assertEquals("ROLE_ADMIN", acesso.getDescricao());
		
		
		/*Teste de carregamento*/
		
		Acesso acesso2 = acessoRepository.findById(acesso.getId()).get();
		
		assertEquals(acesso.getId(), acesso2.getId());
		
		
		
		/*Teste de delete*/
		acessoRepository.deleteById(acesso2.getId());
		
		acessoRepository.flush(); /*Rodar esse SQL dedelete no banco de dados*/
		
		Acesso acesso3 = acessoRepository.findById(acesso2.getId()).orElse(null);
		
		assertEquals(true, acesso3 == null);
		
		
		/*Teste de query*/
		
		acesso = new Acesso();
		
		acesso.setDescricao("ROLE_ALUNO");
		
		acesso = acessoController.salvarAcesso(acesso).getBody();
		
		List<Acesso> acessos = acessoRepository.buscarAcessoDesc("ALUNO".trim().toUpperCase());
		
		assertEquals(1, acessos.size());
		
		acessoRepository.deleteById(acesso.getId());
		
		
		
		
	}

}
