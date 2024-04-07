package projetoshopeementoria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projetoshopeementoria.model.Acesso;

@Repository
@org.springframework.transaction.annotation.Transactional
public interface AcessoRepository extends JpaRepository<Acesso, Long>{
	
}
