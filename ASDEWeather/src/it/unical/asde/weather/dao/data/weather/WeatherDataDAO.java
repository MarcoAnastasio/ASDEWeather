package it.unical.asde.weather.dao.data.weather;

import java.util.Date;
import java.util.List;

import it.unical.asde.weather.dao.GenericDao;
import it.unical.asde.weather.model.bean.data.weather.WeatherData;

public interface WeatherDataDAO extends GenericDao<WeatherData>{

	WeatherData findWeatherDataFromCityNotOlderThan(Long cityId,Integer maxOldValue);

	WeatherData findWeatherDataFromCityNotOlderThan(Long cityId, Date maxOldDate);

	List<WeatherData> findWeatherDataFromCitiesNotOlderThan(List<Long> cityIds,Date maxOldDate);

	void saveList(List<WeatherData> listForecastWeather);

}
