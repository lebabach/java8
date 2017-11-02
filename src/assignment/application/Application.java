package assignment.application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import assignment.domain.entity.Company;
import assignment.domain.entity.ComputerPart;
import assignment.domain.entity.Person;
import assignment.domain.entity.Product;
import assignment.services.implement.CompanyService;
import assignment.services.intefaces.ICompanyService;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Product p = new ComputerPart("computer"); p.display();
		 */

		/*ICompanyService companyServices = new CompanyService();
		// company1
		Person person1 = new Person("le ba bach", 1000, "nguyen tri phuong");
		Person person2 = new Person("le ba quy", 1000, "tran quy khoach");
		List<Person> persons = new ArrayList<Person>();
		persons.add(person1);
		persons.add(person2);
		Company company1 = new Company("Dac", persons);

		// company2
		Person person3 = new Person("duong dinh nghia", 2000, "bach dang");
		Person person4 = new Person("nguyen phuc thang", 3000, "Tran phu");
		persons = new ArrayList<Person>();
		persons.add(person3);
		persons.add(person4);
		Company company2 = new Company("live pass", persons);

		companyServices.add(company1);
		companyServices.add(company2);

		// remove company 1
		// companyServices.delete(company1);
		List<Company> companies = companyServices.findAll();
		companies = companyServices.getCompanyBy("Dac");
		// update company 1
		// company1.setName("NeoLab12121");
		// companyServices.update(company1);
		// companies = companyServices.findAll();
		companies.forEach(item -> System.out.println("name: " + item.getName() + " ===========  person name: "
				+ item.getPersons().stream().map(person -> person.getName()).collect(Collectors.joining(",")) + "\n"));*/
		
		String string="xyzABBAzyx";
		System.out.println(1/2);
		System.out.println("result: "+backWards(0, string.length(), string.split("")));

	}
	//&& !str[index].equals(str[index].toUpperCase())
	//&& !str[index].equals(str[n-1-index].toUpperCase())
	public static String backWards(int index, int n, String[] str) {
		if (index <= (n - 1)/2 && str[index].equals(str[n-1-index])) {
			return str[index] + backWards(index + 1, n, str);
		} else {
			return "";
		}
	}

}
