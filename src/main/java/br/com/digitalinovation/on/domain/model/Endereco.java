package br.com.digitalinovation.on.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConstructorBinding;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/***
 * 
 * @author arauj Alterado em 08/09/2020
 */
@Data
@Getter
@Setter
@EqualsAndHashCode
@ConstructorBinding
@Entity
@Table(name = "enderecos")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private Integer numero;
	private String complemento;
	
}
