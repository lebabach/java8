package assignment.repository.interfaces;

import java.util.List;

import assignment.domain.entity.Person;
import assignment.domain.generic.IGenericRepository;

public interface IPersonRepository extends IGenericRepository<Person> {
	public List<Person> getPersonBy(String name);
}
