package repository;

import java.util.List;

public interface GenericRepository<T, ID> {

	public T save(T t) throws DAOException;

	public int update(T t);

	public int delete(ID id);

	public T getById(ID id);

	public List<T> getAll();

}
