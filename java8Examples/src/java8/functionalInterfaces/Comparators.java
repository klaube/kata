package java8.functionalInterfaces;

import java.util.Comparator;

/**
 * Comparators are well known from older versions of Java. 
 * Java 8 adds various default methods to the interface.
 */
public class Comparators {

	public static void main(String[] args) {

		Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

		Person p1 = new Person("John", "Doe");
		Person p2 = new Person("Alice", "Wonderland");

		comparator.compare(p1, p2);             // > 0
		comparator.reversed().compare(p1, p2);  // < 0

	}

}
