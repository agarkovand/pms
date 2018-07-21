package dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

import app.HibernateUtil;
import dao.interfaces.Dao;

public class AbstractDao<T, ID extends Serializable>
		implements Dao<T, ID> {

	private Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	protected Session getSession() {
		return HibernateUtil.getSessionFactory().openSession();
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	@Override
	public T findById(ID id) {

		Session session = null;
		T result = null;

		try {

			session = getSession();
			result = (T) session.get(getPersistentClass(), id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T save(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(T entity) {
		// TODO Auto-generated method stub
		return 0;
	}

}