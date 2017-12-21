package it.unical.asde.weather.model.exception;

import it.unical.asde.weather.model.bean.comunication.response.GenericResponse.ErrorCode;

//TODO this class can be done as abstract and extended by different concrete exception
public class ASDECustomException extends Exception{
	
	/**
	 */
	private static final long serialVersionUID = 6137288528680862251L;

	private ErrorCode errorCode;
	
	private String message;
	
	public ASDECustomException(Throwable cause,ErrorCode errorCode,String message) {
		super(cause);
		this.errorCode=errorCode;
		this.message=message;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
