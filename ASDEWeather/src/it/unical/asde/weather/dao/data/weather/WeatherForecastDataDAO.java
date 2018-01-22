package it.unical.asde.weather.dao.data.weather;

import it.unical.asde.weather.dao.GenericDao;
import it.unical.asde.weather.model.bean.data.weather.WeatherForecastData;

import java.util.Date;
import java.util.List;

public interface WeatherForecastDataDAO  extends GenericDao<WeatherForecastData>{

	List<WeatherForecastData> findWeatherForecastDataFromCityNotOlderThan(Long id, Date maxOldValue);

	void saveList(List<WeatherForecastData> listForecastWeather);

}
