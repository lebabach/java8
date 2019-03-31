package jdk8;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.*;

public class SplitString {
	public static void main(String[] a) {
		String test="test test 1 2 3 4 121 121 121";
		List<String> liString= new ArrayList<String>(Arrays.asList( test.split(" ")));
		
		liString.remove(0);
		liString.remove(0);
		liString.remove(0);
		liString.forEach(x->{
			System.out.println(x);
		});
		System.out.println(liString.stream().collect(Collectors.joining(" ")));
	}
	
	public static String splitStringBy(String string,String charactor){
		String [] strings=string.split(charactor);
		
		return null;
	}
}
