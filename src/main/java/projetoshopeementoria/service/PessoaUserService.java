package projetoshopeementoria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetoshopeementoria.repository.UsuarioRepository;

@Service
public class PessoaUserService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

}
