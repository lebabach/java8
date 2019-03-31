package assignment.domain.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GenericRepository<T> implements IGenericRepository<T> {
	List<T> list;
	
	public GenericRepository() {
		this.list = new ArrayList<T>();
	}

	@Override
	public T save(T entity) {
		// TODO Auto-generated method stub
		System.out.println("print save generic: ");
		list.add(entity);
		return entity;
	}

	@Override
	public T update(T entity){
		// TODO Auto-generated method stub
		if(entity!=null){
			delete(entity);
			list.add(entity);
		}
		return entity;
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		if(entity != null){
			list = list.stream().filter(item->!item.equals(entity)).collect(Collectors.toList());	
		}
	}

	@Override
	public T findById(int id) {
		// TODO Auto-generated method stub
		return list.get(id);
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return list;
	}

}
