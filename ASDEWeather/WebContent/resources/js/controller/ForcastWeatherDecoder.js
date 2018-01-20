/**
 * Author:Abel Mesfin
 */


function Forecasts(forecasts_input,uvdata) {
	var forecastList = []
	for (var i = 0; i < forecasts_input.length; i++) {
		forecastList[i] = new ForecastWeatherDecoder(forecasts_input[i],uvdata)

	}
	this.forecastList = forecastList;
	if(uvdata != null)
	this.uvdata= uvdata.value;
}

function ForecastWeatherDecoder(forecastWeather_input) {
	this.forecast = forecastWeather_input;
	var dateData = new dateDecoder(forecastWeather_input.dateTimeCalulation);
	this.dateData = dateData;
	this.mainTemp = new MainTempDecoder(forecastWeather_input.mainTemperature);
	this.weather = new WeatherDecoder(forecastWeather_input.weather);
	this.wind = new WindDecoder(forecastWeather_input.wind);
	this.city=new CityDecoder(forecastWeather_input.city);
};

function MainTempDecoder(main_temp_input) {
	this.temp = main_temp_input.temp;
	this.tempMin = main_temp_input.tempMin;
	this.tempMax = main_temp_input.tempMax;
	this.pressure = main_temp_input.pressure;
	this.seaLevel = main_temp_input.seaLevel;
	this.groundLevel = main_temp_input.grndLevel;
	this.humidity = main_temp_input.humidity;
	this.tempKf = main_temp_input.tempKf;
}

function WeatherDecoder(weather_input) {
	this.id=weather_input.id;
	this.main = weather_input.main;
	this.descritpion = weather_input.descritpion;
	//this.icon = weather_input.icon;
	this.icon=iconList[weather_input.id];
	//decodeIcon(weather_input.id);
	console.log(iconList[weather_input.id]);


}
function WindDecoder(wind_input) {
	this.speed = wind_input.speed;
	this.deg = wind_input.deg;

}
function CityDecoder(city_input){
this.name=city_input.name;
this.id=city_input.id;
this.latitude=city_input.latitude;
this.longitude=city_input.longitude;
this.country=new CountryDeoder(city_input.country);
}

function CountryDeoder(country_input){
	this.name=country_input.name;
	this.id=country_input.id;
	this.code=country_input.code;
}

function DayNamer(day, cond) {
	days_name = [ "Sunday", "Monday", "Tuesday", "Wedensday", "Thursday",
			"Friday", "Saturday" ];
	days_short_name = [ "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" ];
	var d = new Date(day);
	return cond ? days_name[d.getDay()] : days_short_name[d.getDay()];
}

function dateDecoder(date_input) {
	this.dateData = date_input;
	var substrings = [];
	substrings = date_input.split(" ");

	var dates = [];
	dates = substrings[0].split("-");

	var times = [];
	times = substrings[1].split(":");

	var day = dates[2];
	var month = dates[1]
	var year = dates[0];
	var hour = times[0];
	var minute = times[1];
	var dayName = DayNamer(month + "/" + day + "/" + year);

	this.day = day;
	this.month = month;
	this.year = year;
	this.hour = hour;
	this.minute = minute;
	this.times = substrings[1];
	this.dayName = dayName;
	

}

function groupBy(array_input, func_input) {
	var groups = {};
	array_input.forEach(function(o) {
		var group = JSON.stringify(func_input(o));
		groups[group] = groups[group] || [];
		groups[group].push(o);
	});
	return Object.keys(groups).map(function(group) {
		return groups[group];
	})
}

var icons={};
function decodeIcon(key) {

	$.getJSON("resources/css/icons.json", function(json) {

	});

}


function getValues(obj, key) {
    var objects = [];
    for (var i in obj) {
        if (!obj.hasOwnProperty(i)) continue;
        if (typeof obj[i] == 'object') {
            objects = objects.concat(getValues(obj[i], key));
        } else if (i == key) {
            objects.push(obj[i]);
        }
    }
    return objects;
    }



