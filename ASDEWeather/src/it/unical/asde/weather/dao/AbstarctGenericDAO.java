package it.unical.asde.weather.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.unical.asde.weather.model.bean.geographical.Country;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public abstract class AbstarctGenericDAO<E> implements GenericDao<E> {

	private final Class<E> entityClass;

	public AbstarctGenericDAO() {
		this.entityClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	@Transactional(readOnly=true)
	public E findById(final Serializable id) {
		return (E) getSession().get(this.entityClass, id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Serializable save(E entity) {
		Session session = getSession();

		System.out.println("save Session="+System.identityHashCode(session));
		return session.save(entity);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveOrUpdate(E entity) {
		getSession().saveOrUpdate(entity);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void delete(E entity) {
		getSession().delete(entity);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteAll() {
		List<E> entities = findAll();
		for (E entity : entities) {
			getSession().delete(entity);
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<E> findAll() {
		Session session = getSession();
		System.out.println("findAll Original Session="+System.identityHashCode(session));
		return session.createCriteria(this.entityClass).list();
	}

	@Override
	@Transactional(readOnly=true)
	public List<E> findAllByExample(E entity) {
		Example example = Example.create(entity).ignoreCase().enableLike().excludeZeroes();
		return getSession().createCriteria(this.entityClass).add(example).list();
	}

	@Override
	public void clear() {
		getSession().clear();

	}

	@Override
	public void flush() {
		getSession().flush();

	}


	 
}