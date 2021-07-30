package br.com.digitalinovation.on.domain.dto.request;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import br.com.digitalinovation.on.domain.enums.Procedencia;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class HistoricoObreiroDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty(message = "{NotEmpty.historioObreiro.dataSeperadoCoop}")
	private LocalDate dataSeperadoCoop;
	@NotEmpty(message = "{NotEmpty.historioObreiro.localSeparadoCoop}")
	private String localSeparadoCoop;
	@NotEmpty(message = "{NotEmpty.historioObreiro.dataConsagracaoDiagono}")
	private String dataConsagracaoDiagono;
	@NotEmpty(message = "{NotEmpty.historioObreiro.localConsagracaoDiacono}")
	private String localConsagracaoDiacono;
	@NotEmpty(message = "{NotEmpty.historioObreiro.dataConsagracaoPresbitero}")
	private LocalDate dataConsagracaoPresbitero;
	@NotEmpty(message = "{NotEmpty.historioObreiro.localConsagracaoPresbitero}")
	private String localConsagracaoPresbitero;
	@NotEmpty(message = "{NotEmpty.historioObreiro.dataConsagracaoEvangelista}")
	private String dataConsagracaoEvangelista;
	@NotEmpty(message = "{NotEmpty.historioObreiro.localConsagracaoEvangelista}")
	private String localConsagracaoEvangelista;
	@NotEmpty(message = "{NotEmpty.historioObreiro.dataConsagracaoMissionario}")
	private String dataConsagracaoMissionario;
	@NotEmpty(message = "{NotEmpty.historioObreiro.localConsagracaoMissionario}")
	private String localConsagracaoMissionario;
	@NotEmpty(message = "{NotEmpty.historioObreiro.dataConsagracaoPastor}")
	private LocalDate dataConsagracaoPastor;
	@NotEmpty(message = "{NotEmpty.historioObreiro.localConsagracaoPastor}")
	private String localConsagracaoPastor;
	@NotEmpty(message = "{NotEmpty.historioObreiro.procedencia}")
	private Procedencia procedencia;// Convencao, Ministerio, Campos
	private String observacao;
	
}
