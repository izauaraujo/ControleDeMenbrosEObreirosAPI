package br.com.digitalinovation.on.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Ativo {

	ATIVO("SIM"), NAO_ATIVO("NAO");

	private final String description;
}
