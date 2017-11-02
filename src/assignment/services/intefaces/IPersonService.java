package assignment.services.intefaces;

import java.util.List;

import assignment.domain.entity.Person;

public interface IPersonService{
	public List<Person> getPersonBy(String name);

}
