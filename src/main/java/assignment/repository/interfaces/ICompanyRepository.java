package assignment.repository.interfaces;

import java.util.List;

import assignment.domain.entity.Company;
import assignment.domain.generic.IGenericRepository;

public interface ICompanyRepository extends IGenericRepository<Company>{
	
	public List<Company> getCompanyBy(String name);
	

}
