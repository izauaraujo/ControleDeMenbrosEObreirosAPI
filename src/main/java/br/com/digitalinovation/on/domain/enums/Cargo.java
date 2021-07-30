package br.com.digitalinovation.on.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Cargo {

	DIACONCO(1, "diacono"), PRESBITERO(2, "presbitero"), EVANGELISTA(3, "evangelista"), PASTOR(4, "pastor"),
	MISSIONARIO(5, "missionario");
	
	private int indice;
	private String descricao;



}
