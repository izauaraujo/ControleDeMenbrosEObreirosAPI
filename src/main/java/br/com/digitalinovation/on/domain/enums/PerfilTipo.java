package br.com.digitalinovation.on.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PerfilTipo {
	ADMIN(1, "ADMIN");
	
	private long indice;
	private String desc;
	
}
