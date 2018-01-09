package it.unical.asde.weather.controller.controllers.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unical.asde.weather.controller.controllers.GenericController;
import it.unical.asde.weather.controller.controllers.UserApiController;
import it.unical.asde.weather.core.services.user.UserService;
import it.unical.asde.weather.model.bean.comunication.response.GenericResponse;
import it.unical.asde.weather.model.bean.user.User;

@Controller
public class UserApiControllerImp extends GenericController implements UserApiController{

	@Autowired
	private UserService userService;
		 
	 @Override
	 @RequestMapping(value = "/api/user/registration", method = RequestMethod.POST,consumes="application/json",produces="application/json")
	public @ResponseBody GenericResponse registerUser(@RequestBody User request) {	
		 
		 try{
			 	User tempUser=userService.registerNewUser(new User(request));
			 	System.out.println("new USer="+tempUser);
			 	GenericResponse response=fillCorrectGenericResponse(request,tempUser);
				return response;
			}catch (Exception e) {
				return fillWrongGenericResponse(e, request);
			}
	    }
	 
	@Override 
	@RequestMapping(value = "/api/auth/user/showUser", method = RequestMethod.GET)
	public @ResponseBody GenericResponse getUserInfo() {
		 	try{
		 		User currentUser=getCurrentLoggedUser();
		 		User response=userService.getCompleteInfo(currentUser);
		 		return fillCorrectGenericResponse(null, response);
		 	}catch(Exception e){
		 		return fillWrongGenericResponse(e, null);
		 	}

	    }
	 
	 
	 @Override
	 @RequestMapping(value = "/api/auth/user/updateUser", method = RequestMethod.POST,consumes="application/json",produces="application/json")
	    public @ResponseBody GenericResponse updateUser(@RequestBody User request) {	
		 try{
		 		//clone request user for store original Request
			 	User originalUserRequest=new User(request);
			 	Object result=userService.updateUser(getCurrentLoggedUser(),request);
			 	GenericResponse response=fillCorrectGenericResponse(originalUserRequest,result);
				return response;
			}catch (Exception e) {
				return fillWrongGenericResponse(e, request);
			}
	    }
	 
	 @Override
	 @RequestMapping(value = "/api/auth/user/login", produces="application/json")
	 public @ResponseBody GenericResponse login() {	
		 try{
			 	GenericResponse response=fillCorrectGenericResponse(null,userService.login(getCurrentLoggedUser()));
				return response;
			}catch (Exception e) {
				return fillWrongGenericResponse(e, null);
			}
	  }
	 
	 @Override
	 @RequestMapping(value = "/api/auth/user/getNotifications", produces="application/json")
	 public @ResponseBody GenericResponse getNotifications() {	
		 try{
			 	GenericResponse response=fillCorrectGenericResponse(null,userService.getNotifications(getCurrentLoggedUser()));
				return response;
			}catch (Exception e) {
				return fillWrongGenericResponse(e, null);
			}
	 }
	 
}
