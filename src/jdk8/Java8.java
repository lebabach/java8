//bach
package jdk8;

import java.awt.Point;
import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

abstract class Animal {
	public void walk() {
		System.out.println("walk by feet");
	}
}

class dog extends Animal {

	public void walk() {
		System.out.println("walk by 4 foot");
	}
}

class duck extends Animal {
	public void walk() {
		System.out.println("walk by 2 foot");
	}
}

class Java8 {
	int i[] = { 0 };
	int a = 0;
	String test = "bach0";

	public static void main(String args[]) {
		if ("Welcome".trim() == "Welcome".trim())
			System.out.println("Equal");
		else
			System.out.println("Not Equal");
		char t = 100;
	}

	static void call_array(int i, int arr[]) {
		arr[i] = 6;
		i = 5;
	}

	public void test() {
		boolean x = true;
		String very_long_name;
		int i = 5;
		boolean t = true;
		System.out.println(a);
		if (x)
			a = x ? 1 : 2;
		else
			a = x ? 3 : 4;
		System.out.println(x);

	}

	public static void assertTest() {
		/*
		 * int x =1; assert x > 10 : "x must be greater than zero, but x = " +
		 * x;
		 */
		int num = 1;

		assert num <= 100 : "over 100";
		System.out.println("1111");

	}

	public static void change_i(int i[]) { // xem lai
		i[0] = 3;
		int j[] = { 2 };
		i = j;
	}

	public static void change_i(String s) {
		String newString = "bach2";
		s = newString;
	}

	public static void tricky(Point arg1, Point arg2) throws Exception {
		arg1.x = 100;
		arg1.y = 100;
		Point temp = arg1;
		arg1 = arg2;
		arg2 = temp;
	}

}
