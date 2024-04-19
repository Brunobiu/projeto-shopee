package projetoshopeementoria.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projetoshopeementoria.model.PessoaJuridica;

@Repository
public interface PessoaRepository extends CrudRepository<PessoaJuridica, Long> {

}
