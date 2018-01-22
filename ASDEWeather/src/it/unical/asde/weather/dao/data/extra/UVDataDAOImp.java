package it.unical.asde.weather.dao.data.extra;

import it.unical.asde.weather.dao.AbstarctGenericDAO;
import it.unical.asde.weather.model.bean.data.extra.UVData;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UVDataDAOImp extends AbstarctGenericDAO<UVData> implements UVDataDAO{

	@Override
	@Transactional(readOnly=true,propagation=Propagation.REQUIRED)
	public UVData findUVDataFromCityAndDay(Long cityId, Date day) {
		return getSession().createQuery("from UVData where city_id=:cityId "
				+ "and  dateCalulation =:day",UVData.class)
				.setParameter("cityId", cityId)
				.setParameter("day", day)
				.uniqueResult();
		
	}

}
