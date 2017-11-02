package jdk8;

import java.io.IOException;

public class PassByValueOrRef {

	public static void main( String[] args ){
	    try{
	    	doSomeThing();
	    }catch(IOException e){
	    	System.out.println(e);
	    }
	}
	static void doSomeThing() throws IOException{
		if(1>0.5){
			throw new IOException();
			
		}
		throw new RuntimeException();
		
	}

}
