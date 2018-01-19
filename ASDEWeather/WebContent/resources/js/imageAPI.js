function getPhotoFromAPI(myPlace, myWidth, myHeight, preferred) {

	toQuery = myPlace.toLowerCase();

	var places = new google.maps.places.PlacesService($('#hidden-map').get(0));

	var request = {
		query : toQuery
	};

	places.textSearch(request, callback);

	var url;
	function callback(results, status) {
		if (status == google.maps.places.PlacesServiceStatus.OK) {
			for (var i = 0; i < results.length; i++) {
				var place = results[i];

				for (var j = 0; j < place.photos.length; j++) {
					url = place.photos[j].getUrl({
						'maxWidth' : myWidth,
						'maxHeight' : myHeight
					});
					console.log(url);
				}

				var card;

				myPlace = myPlace.replace(/\s/g, '');
				if (preferred == false) {

					card = $("#img-" + myPlace);

				} else {
					card = $("#img-" + myPlace + "-p");
				
				}

				if (card != null) {
					card.attr('src', url);
					card.css("width", 348.4);
					card.css("height", 261.3);
				}
			}

		}
	}

};