/**
 * 
 */
App.service('responseHandler',function($rootScope){
	
	this.serverCall = function (serverurl,sendingtype,data,auth,user,caller){		
		console.log("IN SERVER CALL")
		var functionResponse = [];

			if(auth==null){
				 $.ajax({
					type : sendingtype,
					url : serverurl,
					dataType : "json",
					contentType : "application/json",
					data : JSON.stringify(data),
					success : function(response, status) {

						if (response.status == "OK") {
							
							functionResponse = response.response;
							$rootScope.response(functionResponse,caller);
							
						} else {
							console.log("Search Response for selected city Error");
							console.log(response);
						}
					},
					error : function(e) {
						console.log(e);
					}
				});
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
							functionResponse = response;
							$rootScope.response(functionResponse,caller);
							//return response;
							//UserService.setLoggedUser(response.response);
						}
					else{
							console.log("Server Error response")
							console.log(response.status);
						}   		

					},
					error:function(xhr,status){
						
					}
				});
			} // end of else 

		} //  end of functi
})
