package br.com.digitalinovation.on.domain.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author francisco
 * @date 10/01/2019
 */
@Getter
@Setter
@ToString
@ConstructorBinding
@EqualsAndHashCode
@Entity
@Table(name = "pessoas")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@Column(nullable = true, length = 9)
	private String rg;

	@Column(nullable = true, length = 11)
	private String cpf;

	@Column(nullable = true, length = 13)
	private String tituloEleitor;

	@Column(nullable = true, length = 255)
	private String tipoDocumento;
	
	private String numeroDocumento;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataNascimento;

	@Column(nullable = true)
	private String nacionalidade;

	@Column(nullable = true)
	private String naturalDe;

	@Column(nullable = true)
	private String estado;

	@Column(nullable = true)
	private String profissao;

	@Column(nullable = true)
	private String escolaridade;

	@Column(nullable = true)
	private String estadoCivil;

	@Column(nullable = true)
	private String nomePai;
	
	@Column(nullable = true)
	private String nomeMae;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id_fk")
	private Endereco endereco;
	
	private String email;
	
	private String celular;
	
}
