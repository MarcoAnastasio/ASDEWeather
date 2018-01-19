/**
 * 
 */
App.service('locationService',function(){
	
	var serverCall = function (url,type,dataToSend,auth,user){
		
		if(auth=="NONE"){
			
		}
		else {
			
			$.ajax({
				type:type,
				url:url, 
				contentType:"application/json",
				dataType:"json",
				data:JSON.stringify(dataToSend),
				beforeSend: function (xhr) {
					xhr.setRequestHeader ("Authorization", "Basic " + btoa(user.username + ":" + user.password));
				},    	
				success:function(response,status){

					if(response.status=="OK"){
						return ressponse.response;
						//UserService.setLoggedUser(response.response);
					}
				else{
						console.log(response.status);
					}   		

				},
				error:function(xhr,status){
					
				}
			});
		} // end of else 
	} //  end of function
	
})
