package br.com.digitalinovation.on.domain.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import br.com.digitalinovation.on.domain.enums.Procedencia;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
@ConstructorBinding
@Entity
@Table(name = "historicos_obreiros")
public class HistoricoObreiro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataSeperadoCoop;

	private String localSeparadoCoop;

	@DateTimeFormat(iso = ISO.DATE)
	private String dataConsagracaoDiagono;

	private String localConsagracaoDiacono;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataConsagracaoPresbitero;

	private String localConsagracaoPresbitero;

	@DateTimeFormat(iso = ISO.DATE)
	private String dataConsagracaoEvangelista;

	private String localConsagracaoEvangelista;

	@DateTimeFormat(iso = ISO.DATE)
	private String dataConsagracaoMissionario;

	private String localConsagracaoMissionario;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataConsagracaoPastor;

	private String localConsagracaoPastor;

	@Enumerated(EnumType.STRING)
	private Procedencia procedencia;// Convencao, Ministerio, Campos
	
	private String observacao;

}
