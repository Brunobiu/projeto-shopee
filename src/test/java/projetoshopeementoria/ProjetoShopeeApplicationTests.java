package projetoshopeementoria;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import projetoshopeementoria.controller.AcessoController;
import projetoshopeementoria.model.Acesso;
import projetoshopeementoria.service.AcessoService;

@SpringBootTest(classes = ProjetoShopeeApplication.class)
public class ProjetoShopeeApplicationTests {

	
	
	@Autowired
	private AcessoController acessoController;
	
	
	
	@Test
	public void testCadastraAcesso() {
		
		Acesso acesso = new Acesso();
		
		acesso.setDescricao("ROLE_ADMIN");
		
		
		acessoController.salvarAcesso(acesso);	
		
	}

}
