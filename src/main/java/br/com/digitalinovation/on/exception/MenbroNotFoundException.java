package br.com.digitalinovation.on.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MenbroNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public MenbroNotFoundException(Long id) {
        super(String.format("Menbro com ID %s não foi encontrado", id));
    }
	
	public MenbroNotFoundException(String nome) {
        super(String.format("Menbro com Nome %s não foi encontrado", nome));
    }
	
}
