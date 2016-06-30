package br.com.christianovale.sistemaenderecos.dao;


import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import br.com.christianovale.sistemaenderecos.hibernate.HibernateUtil;

/**
 * Classe Dao Generica para realizar as operações basicas do Crud.
 * 
 * @author Christiano
 *
 * @param <T>
 */
@Component
public class DAO<T> {

	private Session session;

	public DAO() {
	}

	public T save(T entity) {
		try {
			getSession().beginTransaction();
			getSession().save(entity);
			getSession().getTransaction().commit();
			getSession().close();
			return entity;
		} catch (Exception e) {
			getSession().getTransaction().rollback();
			getSession().close();
			return null;
		}
	}

	public T update(T entity) {
		try {
			getSession().beginTransaction();
			getSession().merge(entity);
			getSession().getTransaction().commit();
			getSession().close();
			return entity;
		} catch (Exception e) {
			getSession().getTransaction().rollback();
			getSession().close();
			return null;
		}
	}

	public void delete(T entity) {
		try {
			getSession().beginTransaction();
			getSession().delete(entity);
			getSession().getTransaction().commit();
		} catch (Exception e) {
			getSession().getTransaction().rollback();
		} finally {
			getSession().close();
		}
	}

	@SuppressWarnings("unchecked")
	public T searchModel(DetachedCriteria query) {
		T model = (T) query.getExecutableCriteria(getSession()).uniqueResult();
		return model;
	}

	@SuppressWarnings("unchecked")
	public List<T> searchModels(DetachedCriteria query) {
		List<T> models = query.getExecutableCriteria(getSession()).list();
		return models;
	}
	
	@SuppressWarnings("unchecked")
	public T getEntity(Class classe, Serializable id) {
        T entity = (T)getSession().get(classe, id);
        return entity;

    }
	
	@SuppressWarnings("unchecked")
	public List<T> getEntities(Class classe) {
		List<T> entities = (List<T>) getSession().createCriteria(classe).list();

        return entities;
    }

	private Session getSession() {
		if (session == null || !session.isOpen()) session = HibernateUtil.getSessionFactory().openSession();
		return session;
	}

}