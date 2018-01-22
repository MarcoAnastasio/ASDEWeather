package it.unical.asde.weather.dao.data.extra;

import it.unical.asde.weather.dao.GenericDao;
import it.unical.asde.weather.model.bean.data.extra.UVData;

import java.util.Date;

public interface UVDataDAO extends GenericDao<UVData>{

	UVData findUVDataFromCityAndDay(Long cityId,Date day);


}
