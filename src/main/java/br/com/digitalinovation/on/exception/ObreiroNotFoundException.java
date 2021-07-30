package br.com.digitalinovation.on.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ObreiroNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ObreiroNotFoundException(Long id) {
		super(String.format("Obreiro com ID %s não foi encontrado", id));
	}
	
	public ObreiroNotFoundException(String nomeObreiro) {
		super(String.format("Obreiro com Nome %s não foi encontrado", nomeObreiro));
	}
	
	
}
