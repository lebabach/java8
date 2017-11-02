package java8.optional;

import java.util.*;
import java.util.Optional;
import java.util.stream.Collectors;


public class OptionalExample {
	private static final List foo = new ArrayList();
	final static class User {
		int id;
		String firstName;
		String lastName;
		int age;
		Optional<String> gender;

		public User(int id, String firstName, String lastName, int age, Optional<String> gender) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
			this.gender = gender;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public Optional<String> getGender() {
			return gender;
		}

		public void setGender(Optional<String> gender) {
			this.gender = gender;
		}
		
		public Optional<User> findById(int id) {
			return  Optional.ofNullable(null);
		}
	}
	public static void main(String[] str) {
		/*
		 * 1.optional of java is combined into java 8 later not like scala, they execute much slower scala's option 
		 * when we convert Optional to List,Set...throught by stream, Otherwise, Scala's Option is integrate into Collection and It resolves this problems
		 * 2. When you use Optional with Map, filter.... It will skip null value. With Stream we need check null when using map, filter...
		 * refer to http://www.nurkiewicz.com/2013/08/optional-in-java-8-cheat-sheet.html
		 * 3. declare Optional type if you know It has nullbable. After that , using flatmap to flat it ex : Option<Option<String>> --> String
		 * 4. When you execute query to database or flatmap to return a list, it will return empty list not null, otherwise is null with a Object
		 * 5. Should not use Optional any fields
		 * 6. Should not pass Optional params, contructors
		 * 7. Should use into fields having nullable
		 * 8. Should use Optional in Repository, Services, Util
		 * */
		UserRepository usrRepository= new UserRepository();
		User user = usrRepository.findUserById(11);
		//List<User> users= new ArrayList<>();
		//users.add(user);
		//List<User> rs= users.stream().filter(u->u!=null && "male".equals(u.firstName)).collect(Collectors.toList());//.forEach(x->System.out.println("12"));//.ifPresent(x->System.out.println(x.getAge()));
		//System.out.println(usrRepository.findAllUser().stream().filter(u->u.getFirstName().equals("bach")).collect(Collectors.toList()));	
		Optional<User> userOptional = usrRepository.findById(11);
		usrRepository.findAllUser().stream().map(x->x.getId()).map(usrRepository::findById).filter(Optional::isPresent).map(Optional::get).collect(Collectors.toList()).forEach(x->System.out.println(x.getId()+" "+x.getFirstName()));
		//userOptional.flatMap(u->u.getGender());
		
		HashSet<String> hset = 
	               new HashSet<String>();

	      // Adding elements to the HashSet
	      hset.add("Apple");
	      hset.add("Mango");
	      hset.add("Grapes");
	      hset.add("Orange");
	      hset.add("Fig");
	      //Addition of duplicate elements
	      hset.add("Apple");
	      hset.add("Mango");
	      hset.add("Mango");
	      hset.add("Mango");
	      //Addition of null values
	      hset.add(null);
	      hset.add(null);
	      //Displaying HashSet elements
	      System.out.println(hset);
	}
}
