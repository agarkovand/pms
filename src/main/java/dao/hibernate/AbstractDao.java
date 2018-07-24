package dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

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

			session = this.getSession();
			result = (T) session.get(this.getPersistentClass(), id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public List<T> findAll() {

		Session session = null;
		List<T> result = null;

		try {

			session = this.getSession();

			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<T> criteria = cb
					.createQuery(this.getPersistentClass());

			Root<T> from = criteria.from(this.getPersistentClass());
			CriteriaQuery<T> select = criteria.select(from);

			Query<T> query = session.createQuery(select);
			result = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public T save(T entity) {
		Session session = null;
		org.hibernate.Transaction tx = null;

		try {

			session = this.getSession();
			tx = session.beginTransaction();

			session.saveOrUpdate(entity);

			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

		return entity;
	}

	@Override
	public void delete(T entity) {
		Session session = null;
		org.hibernate.Transaction tx = null;
		try {

			System.out.println(
					"Deleting entity of class: " + entity.getClass());
			session = this.getSession();
			tx = session.beginTransaction();
			session.delete(entity);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}