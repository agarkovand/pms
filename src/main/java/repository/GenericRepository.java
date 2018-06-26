package repository;

import java.util.List;

public interface GenericRepository<T, ID> {

	public ID save(T t);

	public int delete(ID id);

	public T getById(ID id);

	public List<T> getAll();

}
