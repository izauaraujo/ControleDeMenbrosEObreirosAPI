package br.com.digitalinovation.on.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.digitalinovation.on.domain.enums.Ativo;
import br.com.digitalinovation.on.domain.model.Obreiro;

@Repository
public interface ObreiroReposistory extends JpaRepository<Obreiro, Long> {
	
	@Query("select o from Obreiro o where o.menbro.pessoa.nome like :nome")
	Optional<Obreiro> findByNome(String nome);
	
	@Query("select o from Obreiro o where o.flagAtivacao = :flag")
	List<Obreiro> findByAllAtivos(Ativo flag);
	
	@Query("select o from Obreiro o where o.dataReconhecimentoGargo between :dataInicial and :dataFinal")
	List<Obreiro> findByDataRangePesquisa(String dataInicial, String dataFinal);
}
