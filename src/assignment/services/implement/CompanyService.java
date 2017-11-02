package assignment.services.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import assignment.domain.entity.Company;
import assignment.repository.implement.CompanyRepository;
import assignment.repository.interfaces.ICompanyRepository;
import assignment.services.intefaces.ICompanyService;

public class CompanyService implements ICompanyService {
	ICompanyRepository companyRepository;
	public CompanyService() {
		companyRepository = new CompanyRepository();
	}

	@Override
	public List<Company> getCompanyBy(String name) {
		// TODO Auto-generated method stub
		return companyRepository.getCompanyBy(name);
	}

	@Override
	public Company add(Company entity) {
		// TODO Auto-generated method stub
		Company company = companyRepository.save(entity);
		return company;
	}

	@Override
	public Company update(Company entity) {
		// TODO Auto-generated method stub
		companyRepository.update(entity);
		return companyRepository.update(entity);
	}

	@Override
	public void delete(Company entity) {
		// TODO Auto-generated method stub
		companyRepository.delete(entity);
	}

	@Override
	public Company findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> findAll() {
		// TODO Auto-generated method stub
		return companyRepository.findAll();
	}

}
