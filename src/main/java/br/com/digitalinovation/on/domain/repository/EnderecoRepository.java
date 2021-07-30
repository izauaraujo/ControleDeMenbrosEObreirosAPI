package br.com.digitalinovation.on.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.digitalinovation.on.domain.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {}
