package it.unical.asde.weather;

import org.junit.Assert;
import org.junit.Test;

import it.unical.asde.weather.dao.geographical.CountryDao;
import it.unical.asde.weather.dao.geographical.CountryDaoImp;
import it.unical.asde.weather.model.bean.geographical.Country;

public class CountryDaoTest {

	@Test
	public void simpleTest(){
		CountryDao countryDao=new CountryDaoImp();
		Assert.assertEquals(countryDao.findAll().size(),0);
		countryDao.save(new Country(null, "test", "TS"));
		
		Assert.assertEquals(countryDao.findAll().size(),1);
	}
	
	
}
