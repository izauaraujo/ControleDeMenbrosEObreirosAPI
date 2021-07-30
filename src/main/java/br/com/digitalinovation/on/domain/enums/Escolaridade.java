package br.com.digitalinovation.on.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Escolaridade {

	PRIMEIRO_GRAU_COMPLETO(1,"Primeiro Grau Completo"), 
	
	PRIMEIRO_GRAU_IMCOPLETO(2,"Primeiro Grau Incompleto"),
	
	SEGUNDO_GRAU_COMPLETO(3, "Segundo Grau Completo"),
	
	SEGUNDO_GRAU_IMCOMPLETO(4, "Segundo Grau Incomleto"),
	
	ENSINO_SUPERIOR(5,"Ensino Superior"),
	
	ENSINO_SUPERIOR_INCOMPLETO(6,"Ensino Superior Incompleto");
	
	private int indice;
	private String descricao;
	
	
}
