package it.unical.asde.weather.model.bean.comunication.response;

public class GenericResponse {

	public enum Status {
	    OK(1), KO(0);

	    private final int value;
	    private Status(int value) {
	        this.value = value;
	    }
	    public int getValue() {
	        return value;
	    }
	}
	
	public enum ErrorCode {
	    WRONG_INPUT(GenericResponseConstant.WRONG_INPUT_CODE,GenericResponseConstant.WRONG_INPUT_MSG),
	    UNKNOW_ERROR(GenericResponseConstant.UNKNOW_ERROR_CODE,GenericResponseConstant.UNKNOW_ERROR_MSG);

	    private final int value;
	    private final String defaultErrorMessage;
	    
	    private ErrorCode(int value,String defaultErrorMessage) {
	        this.value = value;
	        this.defaultErrorMessage=defaultErrorMessage;
	    }
	    public int getValue() {
	        return value;
	    }
	    public String getMessage(){
	    	return defaultErrorMessage;
	    }
	}
	
	private Status status;
	
	private Integer errorCode;
	
	private String messageForUser;
	
	private Object originalRequest;
	
	private Object response;

	
	public GenericResponse() {
		super();
	}


	public GenericResponse(Status status, Integer errorCode, String messageForUser, Object originalRequest,
			Object response) {
		super();
		this.status = status;
		this.errorCode = errorCode;
		this.messageForUser = messageForUser;
		this.originalRequest = originalRequest;
		this.response = response;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public Integer getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}


	public String getMessageForUser() {
		return messageForUser;
	}


	public void setMessageForUser(String messageForUser) {
		this.messageForUser = messageForUser;
	}


	public Object getOriginalRequest() {
		return originalRequest;
	}


	public void setOriginalRequest(Object originalRequest) {
		this.originalRequest = originalRequest;
	}


	public Object getResponse() {
		return response;
	}


	public void setResponse(Object response) {
		this.response = response;
	}

	
}
