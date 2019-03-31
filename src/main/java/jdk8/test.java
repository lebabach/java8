package jdk8;

import java.util.ArrayList;
import java.util.Collection;

public class test {
	String name;
	int age;

	public test(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * test p = new test("bach", 27); p.setName("bach1"); returnTest(p);
		 * System.out.println(p.getName());
		 */ 
		//
		//System.out.println(operation(2,0));
		sentence3();
	}
	
	//B
	public static void sentence3(){
		int result = 1;
		for(int i =1; i<=8;i++){
			if(i%2==1){
				result = result *i;
			}
		}
		System.out.println(result);
	}
	
	//4: B
	
	//6: B
	public static void sentence6(){
		int result = 1;
		for(int i =1; i<=-4;i++){
			if(i%2==1){
				result = result *i;
			}
		}
		System.out.println(result);
	}
	
	//7C,8A,9B 
	public static int operation(int a, int b){
		if(b>1){
			return a + operation(a,b-1);
		}else{
			return a;
		}
	}
	
	//10 c
	public static int sentence10(int a, int b){
		if(b>1){
			return a + operation(a,b-1);
		}else{
			return a;
		}
	}
	
	//16b
	//17C
	//18C
	//19D
	//21B
	//22A
	//28D
	//30B
	public static test returnTest(test t) {
		// t=new test("bach2",28);
		t.setName("bach2");
		long y = (byte)100;
		return t;
	}

}
