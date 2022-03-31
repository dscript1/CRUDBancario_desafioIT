package com.ApiBancario.projetoBancario.controller.handle;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ApiBancario.projetoBancario.model.exception.ErroPadrao;
import com.ApiBancario.projetoBancario.service.exception.PessoaException;
import com.ApiBancario.projetoBancario.service.exception.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandle {

	@ExceptionHandler(ResourceNotFoundException.class)
	
	public ResponseEntity<ErroPadrao> EntityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		ErroPadrao erro = new ErroPadrao();
		erro.setTimeStamp(Instant.now());
		erro.setStatus(status.value());
		erro.setError("Informação não encontrada.");
		erro.setMessage(e.getMessage());
		erro.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(erro);
		
	}
	
	@ExceptionHandler(PessoaException.class)
		public ResponseEntity<ErroPadrao> pessoaConflito(PessoaException e, HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.CONFLICT;
		ErroPadrao erro = new ErroPadrao();
		erro.setTimeStamp(Instant.now());
		erro.setStatus(status.value());
		erro.setError("Cliente ou ID já cadastrado.");
		erro.setMessage(e.getMessage());
		erro.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(erro);
	}
}
