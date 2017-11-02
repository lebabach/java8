package assignment.domain.generic;

import java.util.List;

public interface IGenericRepository<T> {

	T save(T entity);
	T update(T entity);
	void delete(T entity);
	T findById(int id);
	List<T> findAll(); 
}
