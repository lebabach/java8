package assignment.repository.implement;

import java.util.List;

import assignment.domain.entity.Person;
import assignment.domain.generic.GenericRepository;
import assignment.repository.interfaces.IPersonRepository;

public class PersonRepository extends GenericRepository<Person> implements IPersonRepository{

	@Override
	public List<Person> getPersonBy(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
