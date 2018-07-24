package dao.interfaces;

import java.util.List;

public interface Dao<T, ID> {

	public T findById(ID id);

	public List<T> findAll();

	public T save(T entity);

	public void delete(T entity);

}