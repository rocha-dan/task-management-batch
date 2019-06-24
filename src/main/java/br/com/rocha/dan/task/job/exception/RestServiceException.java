package br.com.rocha.dan.task.job.exception;

public class RestServiceException extends Exception {

	
	private static final long serialVersionUID = -9159176960395333558L;

	public RestServiceException() {
		super();
	}

	public RestServiceException(String message) {
		super(message);
	}
	
	public RestServiceException(Throwable cause) {
		super(cause);
	}

	public RestServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
