package assignment.repository.implement;

import java.util.List;
import java.util.stream.Collectors;

import assignment.domain.entity.Company;
import assignment.domain.generic.GenericRepository;
import assignment.repository.interfaces.ICompanyRepository;

public class CompanyRepository extends GenericRepository<Company> implements ICompanyRepository {
	
	public CompanyRepository() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Company save(Company entity) {
		// TODO Auto-generated method stub
		this.save(entity);
		return entity;
	} 

	@Override
	public List<Company> getCompanyBy(String name) {
		// TODO Auto-generated method stub
		return this.findAll().stream().filter(item->item.getName().equals(name)).collect(Collectors.toList());
	}
}
