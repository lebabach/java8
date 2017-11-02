package assignment.domain.entity;

public abstract class Product {
	String name ;

	public Product(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public void display(){
		System.out.println(name);
	}

}
