package com.diogorolins.battleShip.resources.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.diogorolins.battleShip.exception.EmailAlreadyExistsException;
import com.diogorolins.battleShip.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ResponseEntity<StandardError> emailAlreadyExists(EmailAlreadyExistsException e, HttpServletRequest request) {
		StandardError err = new StandardError("Email já cadastrado");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		StandardError err = new StandardError("Recurso não encontrado");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<StandardError> authentionError(AuthenticationException e, HttpServletRequest request) {
		StandardError err = new StandardError("Dados inválidos");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> authentionError(MethodArgumentNotValidException e,
			HttpServletRequest request) {

		StandardError err = new StandardError(e.getBindingResult().getFieldErrors().get(0).getDefaultMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

}
