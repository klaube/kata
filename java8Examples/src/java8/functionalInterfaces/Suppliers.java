package java8.functionalInterfaces;

import java.util.function.Supplier;

/** 
 * Suppliers produce a result of a given generic type. 
 * Unlike Functions, Suppliers don't accept arguments.
 */
public class Suppliers {

	public static void main(String[] args) {

		Supplier<Person> personSupplier = Person::new;
		personSupplier.get();   // new Person

	}

}
