package jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntToDoubleFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.concurrent.*;

public class JavaFunctionProgrammingTest {

	public static void main(String[] args) {

		List<Student> students = Arrays.asList(new Student("John", 3), new Student("Mark", 4));
		Consumer<String> consumerTest = JavaFunctionProgrammingTest::printNames;
		acceptAllEmployee(students, e -> System.out.println(e.name));
		acceptAllEmployee(students, e -> {
			e.gpa *= 1.5;
		});
		acceptAllEmployee(students, e -> System.out.println(e.name + ": " + e.gpa));
		System.out.println("\n\n");

		// basic declare consumer
		System.out.println("consumer");
		Consumer<String> consumer = JavaFunctionProgrammingTest::printNames;
		consumer.accept("lÃª baÌ� baÌ�ch");
		Consumer<String> consumerName = x -> System.out.println(x);
		consumerName.accept("bach@");

		System.out.println("\n");

		// basic supplier
		System.out.println("supplier");
		String name = "baÌ�ch Ä‘aÌ£i ca";
		Supplier<String> supplier = () -> name;
		System.out.println(supplier.get());

		System.out.println("\n");

		// functinal programming java 8 funtions
		System.out.println("functions");
		Function<Integer, String> increasement = x -> "" + (x + 1);
		System.out.println(increasement.apply(3));
		Function<Integer, Integer> increasement1 = Util::increasement;
		System.out.println(increasement1.apply(3));

		Function<Integer, Integer> sum = x -> x + 1;
		Function<Integer, Integer> mul = x -> x * 3;
		Function<Integer, Integer> result = mul.compose(sum);
		System.out.println("x=10; mul(sum(x))= " + result.apply(10));
		System.out.println(mul.apply(sum.apply(10)));
		System.out.println("");

		Function<Integer, Function<Integer, Integer>> makeAdd = x -> y -> x + y;
		System.out.println("x=1;y=2 ; x -> y -> x + y = " + makeAdd.apply(1).apply(2));

		BinaryOperator<Integer> sumXY = (x, y) -> x + y;
		System.out.println("x+y: " + sumXY.apply(3, 4));

		BinaryOperator<Function<Integer, Integer>> compose1 = (f, g) -> x -> f.apply(g.apply(x));
		System.out.println("BinaryOperator x=10; mul(sum(x))= " + compose1.apply(mul, sum).apply(10));

		// predicate
		Predicate<Integer> check = x -> x > 0;
		System.out.println(check.test(4));

		// implement Math operation
		IntegerMath addition = (a, b) -> a + b;
		IntegerMath subtraction = (a, b) -> a - b;
		System.out.println("40 + 2 = " + apply(40, 2, addition) + " confirm: " + addition.calculate(40, 2));
		System.out.println("20 - 10 = " + apply(20, 10, subtraction));
		System.out.println(
				"10 - 20 = " + apply(20, 10, subtraction.swap()) + " confirm: " + subtraction.swap().calculate(20, 10));

		// factorial
		BiFunction<BiFunction, Double, Double> factHelper = (f, x) -> {
			double result1 = 1.0;
			if (x != 0) {
				result1 = x * (double) f.apply(f, x - 1);
			}
			return result1;
		};
		Function<Double, Double> fact = x -> factHelper.apply(factHelper, x);

		Function<Double, Double> fact1 = x -> {
			BiFunction<BiFunction, Double, Double> fx = (f, d) -> d == 0 ? 1.0 : d * (double) f.apply(f, d - 1);
			return fx.apply(fx, x);

		};

		System.out.println("factorial 80: " + fact1.apply((double) 80));
		// Fibonacci
		Function<Double, Double> resultFibo = n -> {
			BiFunction<BiFunction, Double, Double> fibo = (f, x) -> {
				if (x == 1) {
					return 1.0;
				} else if (x == 0) {
					return 0.0;
				} else {
					return (double) f.apply(f, x - 1) + (double) f.apply(f, x - 2);
				}
			};
			return fibo.apply(fibo, n);
		};
		System.out.println("fibonacci 5: " + resultFibo.apply((double) 6));
	}

	interface IntegerMath {
		int calculate(int a, int b);

		default IntegerMath swap() {
			return (a, b) -> calculate(b, a);
		}
	}

	private static int apply(int a, int b, IntegerMath op) {
		return op.calculate(a, b);
	}

	public static void acceptAllEmployee(List<Student> student, Consumer<Student> printer) {
		for (Student e : student) {
			printer.accept(e);
		}
	}

	public static void printNames(String name) {
		System.out.println(name);
	}

}

class Util {
	public static Integer increasement(Integer x) {
		return x + 1;
	}
}

class Student {
	public String name;
	public double gpa;

	Student(String name, double g) {
		this.name = name;
		this.gpa = g;
	}
}
