package com.diogorolins.battleShip.resources.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.diogorolins.battleShip.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		StandardError err = new StandardError(System.currentTimeMillis(), 
				HttpStatus.NOT_FOUND.value(), 
				"Recurso não encontrado", 
				e.getMessage(), 
				request.getRequestURI());		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	

	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<StandardError> authentionError(AuthenticationException e, HttpServletRequest request) {
		StandardError err = new StandardError(System.currentTimeMillis(), 
				HttpStatus.BAD_REQUEST.value(),
				"Dados inválidos", 
				e.getMessage(), 
				request.getRequestURI());		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> authentionError(MethodArgumentNotValidException e, HttpServletRequest request) {
		ValidationError err = new ValidationError(System.currentTimeMillis(), 
				HttpStatus.UNPROCESSABLE_ENTITY.value(),
				"Dados inválidos", 
				e.getMessage(), 
				request.getRequestURI());		
		for(FieldError fe : e.getBindingResult().getFieldErrors()) {
			err.addErrors(fe.getField(), fe.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
	}
	
	
}
