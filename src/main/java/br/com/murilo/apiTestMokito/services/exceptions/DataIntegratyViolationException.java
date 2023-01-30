package br.com.murilo.apiTestMokito.services.exceptions;

public class DataIntegratyViolationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataIntegratyViolationException(String message) {
		super(message);
	}

}
