package it.unical.asde.weather.controller.controllers.imp;

import org.springframework.security.core.context.SecurityContextHolder;

import it.unical.asde.weather.model.bean.comunication.response.GenericResponse;
import it.unical.asde.weather.model.bean.comunication.response.GenericResponse.ErrorCode;
import it.unical.asde.weather.model.bean.comunication.response.GenericResponse.Status;
import it.unical.asde.weather.model.bean.comunication.response.GenericResponseConstant;
import it.unical.asde.weather.model.bean.user.User;
import it.unical.asde.weather.model.bean.user.UserDetailsImp;
import it.unical.asde.weather.model.exception.ASDECustomException;

public abstract class AbstractGenericController {

	protected GenericResponse fillCorrectGenericResponse(Object originalRequest,Object response){
		return new GenericResponse(Status.OK, null, null, originalRequest, response);
	}
	
	protected GenericResponse fillWrongGenericResponse(Exception e,Object originalRequest){
		
		e.printStackTrace();
		
		if(e instanceof ASDECustomException){
			ASDECustomException customException=(ASDECustomException) e;

			String message=null;
			if(e.getMessage()==null || e.getMessage().isEmpty()){
				message=customException.getErrorCode().getMessage();				
			}else{
				message=e.getMessage();
			}
			return new GenericResponse(Status.KO, customException.getErrorCode().getValue(),
					message, originalRequest, null);
		}else{
			return new GenericResponse(Status.KO, ErrorCode.UNKNOW_ERROR.getValue(),
					ErrorCode.UNKNOW_ERROR.getMessage(), originalRequest, null);
		}
		
	}
	
	
	//TODO test what appen if not user is logged , and maybe throws ASDECyustomException
	protected User getCurrentLoggedUser(){
		return ((UserDetailsImp) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
	}
}
