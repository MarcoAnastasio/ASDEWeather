package it.unical.asde.weather.dao.weather;

import it.unical.asde.weather.dao.GenericDao;
import it.unical.asde.weather.model.bean.weather.WeatherData;

public interface WeatherDataDAO extends GenericDao<WeatherData>{

	WeatherData findWeatherDataFromCityNotOlderThan(Long cityId,Long maxOldValue);

}
