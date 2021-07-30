package br.com.digitalinovation.on.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EnderecoNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	
	public EnderecoNotFoundException(Long id) {
		 super(String.format("Endereco com ID %s não foi encontrado", id));
	}
	
	
}
