package com.deborah.Gerenciador.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedOperationException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public UnsupportedOperationException(String ex) {
		super(ex);
	}
}
