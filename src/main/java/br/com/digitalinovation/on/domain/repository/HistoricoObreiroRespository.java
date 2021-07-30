package br.com.digitalinovation.on.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.digitalinovation.on.domain.model.HistoricoObreiro;

@Repository
public interface HistoricoObreiroRespository extends JpaRepository<HistoricoObreiro, Long> {
	
}
