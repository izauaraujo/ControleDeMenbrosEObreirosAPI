package br.com.digitalinovation.on.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EstadoCivil {
	CASADO(1, "Casado"), SOLTEIRO(2, "Solteiro");
	
	private int indice;
	private String descricao;
	
	
}
