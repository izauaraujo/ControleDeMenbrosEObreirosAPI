package br.com.digitalinovation.on.domain.repository;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.digitalinovation.on.domain.model.Pessoa;

@Repository
public interface PessoaReposiroty extends JpaRepository<Pessoa, Long> {
	
	public List<Pessoa> findByNome(String nome) throws NoSuchElementException;
	
}
