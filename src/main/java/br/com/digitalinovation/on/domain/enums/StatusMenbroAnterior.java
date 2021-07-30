package br.com.digitalinovation.on.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusMenbroAnterior {
	SIM(1, "Sim"), NAO(2, "Não");
	
	private int indice;
	private String descricao;
}
