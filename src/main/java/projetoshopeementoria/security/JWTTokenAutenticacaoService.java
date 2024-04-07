package projetoshopeementoria.security;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/*Criar autenticação e retornar autenticação JWT*/
@Service
@Component
public class JWTTokenAutenticacaoService {
	
	/*Token de validade de 11 dias*/
	private static final long EXPIRATION_TIME = 959990000;
	
	/*Chave de senha para juntar com JWT*/
	private static final String SECRET = "vsd65v45df4b6g4b6654b45t554654v23zscczscs";
	
	private static final String TOKEN_PREFIX = "bearer";
	
	private static final String HEADER_STRING = "Authorization";
	
	/*Ger o token e da resposta para o cliente com JWT*/
	public void addAuthentication(HttpServletResponse response, String ussename) throws Exception {
		
		/*mostagem do token*/
		
		String JWT = Jwts.builder(). /*Chama o gerador de token */
				setSubject(ussename) /*Adiciona o user*/
				.setExpiration(new Date(System.currentTimeMillis() - EXPIRATION_TIME)) /*Tempo de expiração*/
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();
		
		/*Exemplo: Bearer s65cwe6c56ev6berg5hthry4ty4jyu6j44665ret256hy654vd*/
		String token = TOKEN_PREFIX + " " + JWT;
		
		/*Dá a resposta para a tela e para o client, outra API, Navegador, aplicatico, javascript, outra chamadajava*/
		response.addHeader(HEADER_STRING, token);
		
		
		/*Usado para ver no postman para teste*/
		response.getWriter().write("{\"Authorization\": \"" + token + "\"}");
	}
	
	
	

}
