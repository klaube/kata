package java8.functionalInterfaces;

import java.util.function.Consumer;

/**
 * Consumers represents operations to be performed on a single input argument.
 */
public class Consumers {

	public static void main(String[] args) {

		Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
		greeter.accept(new Person("Luke", "Skywalker"));

	}

}
