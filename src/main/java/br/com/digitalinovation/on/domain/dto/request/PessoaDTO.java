package br.com.digitalinovation.on.domain.dto.request;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Getter
@Setter
@NoArgsConstructor
public class PessoaDTO {
	
	private long id;
	
	@NotEmpty(message = "{NotEmpty.pessoa.nome}")
	private String nome;
	
	@NotEmpty(message = "{NotEmpty.pessoa.rg}")
	private String rg;
	
	@NotEmpty(message = "{NotEmpty.pessoa.cp}")
	@CPF
	private String cpf;
	
	@NotEmpty(message = "{NotEmpty.pessoa.tituloEleito}")
	private String tituloEleitor;
	
	@NotEmpty(message = "{NotEmpty.pessoa.tipoDocumento}")
	private String tipoDocumento;
	
	@NotEmpty(message = "{NotEmpty.pessoa.numeroDocumento}")
	private String numeroDocumento;
	
	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataNascimento;
	
	@NotEmpty(message = "{NotEmpty.pessoa.nacionalidade}")
	private String nacionalidade;
	
	@NotEmpty(message = "{NotEmpty.pessoa.naturalDe}")
	private String naturalDe;
	
	@NotEmpty(message = "{NotEmpty.pessoa.estado}")
	private String estado;
	
	@NotEmpty(message = "{NotEmpty.pessoa.profissao}")
	private String profissao;
	
	@NotEmpty(message = "{NotEmpty.pessoa.escolaridade}")
	private String escolaridade;
	
	@NotEmpty(message = "{NotEmpty.pessoa.estadoCivil}")
	private String estadoCivil;
	
	@NotEmpty(message = "{NotEmpty.pessoa.nomePai}")
	private String nomePai;
	
	@NotEmpty(message = "{NotEmpty.pessoa.nomeMae}")
	private String nomeMae;
	
	@Valid
	private EnderecoDTO endereco;
	
	@NotEmpty(message = "{NotEmpty.pessoa.email}")
	private String email;
	
	@NotEmpty(message = "{NotEmpty.pessoa.celular}")
	private String celular;
	
	private PessoaDTO pessoa;
}
