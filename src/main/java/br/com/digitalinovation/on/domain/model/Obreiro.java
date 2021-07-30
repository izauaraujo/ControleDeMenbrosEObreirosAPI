/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.digitalinovation.on.domain.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonRootName;

import br.com.digitalinovation.on.domain.enums.Ativo;
import br.com.digitalinovation.on.domain.enums.Cargo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author francisco
 * @date 10/01/2019 Alterado em 08/09/2020
 */

@Getter
@Setter
@ToString
@ConstructorBinding
@Entity
@Table(name = "obreiros")
@JsonRootName(value = "obreiro")
public class Obreiro  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="id_menbro_fk")
	private Menbro menbro;
	
	private boolean conjugeEvangelico;

	private boolean batizadoEspiritoSanto;

	@Enumerated(EnumType.STRING)
	private Cargo cargo;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataReconhecimento;

	@OneToOne
	@JoinColumn(name="id_historico_fk")
	private HistoricoObreiro historicoObreiro;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataReconhecimentoGargo;

	@Enumerated(EnumType.STRING)
	private Ativo flagAtivacao;
	
}
