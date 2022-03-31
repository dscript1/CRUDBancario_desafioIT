package com.ApiBancario.projetoBancario.service.exception;

public class PessoaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public PessoaException (String mensagem) {
		
		super(mensagem);
	}
}
