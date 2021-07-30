package br.com.digitalinovation.on.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoDocumento {
	
	CERT_CASAMENTO(1,"Certidão de casamento"), CERT_NASCIMENTO(2,"Certidão de nascimento");
	
	private int indice;
	private String descricao;
	
}
