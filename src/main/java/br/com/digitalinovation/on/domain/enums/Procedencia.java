package br.com.digitalinovation.on.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Procedencia {

	CONVENCAO(1, "Convenção"), MINISTERIO(2, "Ministério"), CAMPO(3, "Campo");

	private int indice;
	private String descricao;

}
