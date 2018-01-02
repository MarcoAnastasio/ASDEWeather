package it.unical.asde.weather.model.bean.comunication.response;

public class GenericResponseConstant {

	public static final int UNKNOW_ERROR_CODE=0;
	public static final String UNKNOW_ERROR_MSG="Unknow error was occurred try again or contact the system administrator";

	public static final int WRONG_INPUT_CODE=1;
	public static final String WRONG_INPUT_MSG="Input provided isn't correct";
	
	
	public static final int USERNAME_USED_CODE=2;
	public static final String USERNAME_USED_MSG="Username is already used";
	
	public static final int EMAIL_USED_CODE=3;
	public static final String EMAIL_USED_MSG="Email is already used";
	
	public static final int USERNAME_AND_EMAIL_USED_CODE=4;
	public static final String USERNAME_AND_EMAIL_USED_MSG="Username and email are already used";

	public static final int NOT_LOGGED_USER_CODE = 5;
	public static final String NOT_LOGGED_USER_MSG = "Login for submit this request";
	
	public static final int CITY_NOT_EXISTS_CODE = 6;
	public static final String CITY_NOT_EXISTS_MSG = "City not found";
	
}
