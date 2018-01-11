package it.unical.asde.weather.dao.data.weather;

import java.util.Date;
import java.util.List;

import it.unical.asde.weather.dao.GenericDao;
import it.unical.asde.weather.model.bean.data.weather.WeatherForecastData;

public interface WeatherForecastDataDAO  extends GenericDao<WeatherForecastData>{

	List<WeatherForecastData> findWeatherForecastDataFromCityNotOlderThan(Long id, Date maxOldValue);

	void saveList(List<WeatherForecastData> listForecastWeather);

}
