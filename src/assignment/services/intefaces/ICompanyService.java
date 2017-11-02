package assignment.services.intefaces;

import java.util.List;

import assignment.domain.entity.Company;

public interface ICompanyService {
	public List<Company> getCompanyBy(String name);
	public Company add(Company entity);
	public Company update(Company entity);
	public void delete(Company entity);
	public Company findById(int id);
	public List<Company> findAll(); 
}
