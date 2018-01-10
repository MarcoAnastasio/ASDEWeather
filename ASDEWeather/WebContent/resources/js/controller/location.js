
	// ----- get Current Location by API ----------------------
	function getCurrentLocationByAPI() {
		var coordinates = null;
		console.log("In API location");

		$.ajax({
			type : 'GET',
			async : false,
			url : "http://ip-api.com/json/",
			//url : "http://ip-api.com/json/"+userip,
			dataType : "json",
			success : function(response) {
				if (response.status == "success") {
					coordinates = {
						latitude : response.lat,
						longitude : response.lon
					};
					console.log("In API location return: "+coordinates);
					return coordinates;

				} else {
					console.log("IP API Error");
					console.log(response);
				}
			},
			error : function(response, status) {
				console.log("IP API Error request");
				console.log(status);
				console.log(message);
			}
		});
	}


//	$( document ).ready(function() {
//		console.log( "ready!" );
//		getCurrentLocationByAPI();	
//	});	
	
	// ---------------------end getCurrentLocationByAPI----------------------

	// ----- get Current Location by Geolocation ----------------------------
	function getCurrentLocationByGeolocation() {
		var coordinates = null;

// }, function(error) {
// alert('Error occurred. Error code: ' + error.code);
// },{timeout:5000});
// }
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(function(position) {

				coordinates = {
					latitude : position.coords.latitude,
					longitude : position.coords.longitude
				};
				console.log("aaa:" + coordinates);
				return coordinates;

			}, function(error) {
				console.log('Error occurred. Error code: ' + error.code);
			});

		} else {
			console.log("Geolocation is not supported by this browser");
		}
		//console.log("In geolocation: " + coordinates);
		//return coordinates;
	}
	// ----- end getCurrentLocationByGeolocation ----------------------------

	// ----- get Current Location (if geolocation it's on, call api) -------
	function getCurrentLocation() {
		var location = getCurrentLocationByGeolocation();
		console.log("1.  " + location);

		if (location == null) {
			{
				location = getCurrentLocationByAPI();
				console.log("2.  " + location);
			}
		}

		console.log("in location fun");
		// console.log(location.latitude);
		return location;
	}
	// ----- end getCurrentLocation ----------------------------
	
	
	
	