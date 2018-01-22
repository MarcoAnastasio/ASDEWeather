package it.unical.asde.weather.dao.geographical;

import it.unical.asde.weather.dao.AbstarctGenericDAO;
import it.unical.asde.weather.model.bean.geographical.Country;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CountryDaoImp extends AbstarctGenericDAO<Country> implements CountryDao{

	@Override
	@Transactional(readOnly=true)
	public Country getCountryFromName(String name) {
		Session session = getSession();
		return session.createNativeQuery("SELECT * FROM country as c where c.name=:nameIn", Country.class).setParameter("nameIn",name ).uniqueResult();
	}

	@Override
	@Transactional(readOnly=true)
	public Country getCountryFromCode(String code) {
		return getSession().createNativeQuery("SELECT * FROM country as c where c.code=:codeIn", Country.class).setParameter("codeIn",code).uniqueResult();
	}
	
}
