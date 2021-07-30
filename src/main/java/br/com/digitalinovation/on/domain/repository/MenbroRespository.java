package br.com.digitalinovation.on.domain.repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.digitalinovation.on.domain.model.Menbro;

@Repository
public interface MenbroRespository extends JpaRepository<Menbro,Long> {
	
	@Query("select m from Menbro m where m.pessoa.nome = :nome")
	Optional<Menbro> findByName(String nome) throws NoSuchElementException;
	
	@Query("select m from Menbro m where m.dataAdmissao between :dataInicial and :dataFinal")
	List<Menbro> findByDataRangePesquisa(String dataInicial, String dataFinal) throws NoSuchElementException;
	
}
