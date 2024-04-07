package projetoshopeementoria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetoshopeementoria.model.Acesso;
import projetoshopeementoria.repository.AcessoRepository;

@Service
public class AcessoService  {
	
	@Autowired
	private AcessoRepository acessoRepository;
	
	public Acesso save(Acesso acesso) {
		/*Qualquer tipod e validaçao antes de salvar*/
		return acessoRepository.save(acesso);
		
	}
	
}
