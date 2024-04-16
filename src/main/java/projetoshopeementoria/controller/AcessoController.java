package projetoshopeementoria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import projetoshopeementoria.model.Acesso;
import projetoshopeementoria.repository.AcessoRepository;
import projetoshopeementoria.service.AcessoService;

@Controller
@RestController
public class AcessoController {

	@Autowired
	private AcessoService acessoService;
	
	@Autowired
	private AcessoRepository acessoRepository;
	
	@ResponseBody  /*Retorno da API*/
	@PostMapping(value = "**/salvarAcesso") /*Mapeando a URL pra receber um JSON*/
	public ResponseEntity<Acesso> salvarAcesso(@RequestBody Acesso acesso) {  /*Recebe um JSON e conver pra objeto*/
		
		Acesso acessoSalvo = acessoService.save(acesso);
		
		return new ResponseEntity<Acesso>(acessoSalvo, HttpStatus.OK);
	}
	
	
	@ResponseBody  /*Retorno da API*/
	@PostMapping(value = "**/deleteAcesso") /*Mapeando a URL pra receber um JSON*/
	public ResponseEntity<?> deleteAcesso(@RequestBody Acesso acesso) {  /*Recebe um JSON e conver pra objeto*/
		
		acessoRepository.deleteById(acesso.getId());
		
		return new ResponseEntity("Acesso Removido",HttpStatus.OK);
	}
	

}
