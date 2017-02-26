package java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaExpression {

	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		
		/* The static utility method Collections.sort accepts a list and a comparator in order 
		 * to sort the elements of the given list. You often find yourself creating anonymous comparators 
		 * and pass them to the sort method.
		 * Instead of creating anonymous objects all day long, Java 8 comes with a much shorter syntax, 
		 * lambda expressions: **/
		Collections.sort(names, (String a, String b) -> {
		    return b.compareTo(a);
		});
		
		System.out.println("1. " + names); // [xenia, peter, mike, anna]


		// it gets even shorter:
		Collections.sort(names, (String a, String b) -> b.compareTo(a));
		System.out.println("2. " + names); // [xenia, peter, mike, anna]


		/* For one line method bodies you can skip both the braces {} and the return keyword.
		 * The java compiler is aware of the parameter types so you can skip them as well.
		 */
		Collections.sort(names, (a, b) -> b.compareTo(a));
		System.out.println("3. " + names); // [xenia, peter, mike, anna]



	}
}
