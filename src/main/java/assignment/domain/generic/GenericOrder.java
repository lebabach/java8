package assignment.domain.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GenericOrder<T> {
	private List<T> products;

	public GenericOrder() {
		products = new ArrayList<T>();
	}

	public List<T> getAllProducts() {
		return products;
	}
	
	public T getProductBy(T t){
		return products.stream().filter(item-> item.equals(t)).findFirst().orElseGet(()-> null);
	}
	
	public T getProductBy(String name){
		return products.stream().filter(item-> item.equals(name)).findFirst().orElseGet(()-> null);
	}
	
	public T getProductByIndex(int index){
		return products.get(index);
	}
	
	public void setProducts (List<T> products){
		this.products.addAll(products);
	}
	
	public void addProducts (T product){
		this.products.add(product);
	}

}
