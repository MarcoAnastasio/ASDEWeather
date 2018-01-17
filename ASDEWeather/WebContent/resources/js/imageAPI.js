function getPhotoFromAPI(myPlace, myWidth, myHeight) {
	
	
	toQuery = myPlace.toLowerCase();
	
	var places = new google.maps.places.PlacesService($('#hidden-map').get(0));

	var request = {
		// aggiungere controlli a my place??
		query : toQuery
	};

	places.textSearch(request, callback);
	
	var url;
	function callback(results, status) {
		if (status == google.maps.places.PlacesServiceStatus.OK) {
			for (var i = 0; i < results.length; i++) {
				var place = results[i];
				// console.log("Latitudine: " + place.geometry.location.lat());
				// console.log("Longitudine: " + place.geometry.location.lng());
				// console.log("Formatted addres: " + place.formatted_address);
				// console.log("Name: " + place.name);
				// console.log("length: " + place.photos.length);

				for (var j = 0; j < place.photos.length; j++) {
					url = place.photos[j].getUrl({
						'maxWidth' : myWidth,
						'maxHeight' : myHeight
					});
					 console.log(url);
				}
				$("#img-"+myPlace).attr('src',url)
			}
		}
	}

};