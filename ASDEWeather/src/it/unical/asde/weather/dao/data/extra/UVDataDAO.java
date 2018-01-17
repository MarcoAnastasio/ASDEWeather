package it.unical.asde.weather.dao.data.extra;

import java.util.Date;
import java.util.List;

import it.unical.asde.weather.dao.GenericDao;
import it.unical.asde.weather.model.bean.data.extra.UVData;
import it.unical.asde.weather.model.bean.data.weather.WeatherData;

public interface UVDataDAO extends GenericDao<UVData>{

	UVData findUVDataFromCityAndDay(Long cityId,Date day);


}
