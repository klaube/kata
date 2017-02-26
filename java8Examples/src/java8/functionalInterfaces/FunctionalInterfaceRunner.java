package java8.functionalInterfaces;

public class FunctionalInterfaceRunner {
	
	public static void main(String[] args) {
		
		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer converted = converter.convert("123");
		System.out.println(converted);    // 123
		
		/* The above example code can be further simplified by utilizing static method references. 
		 * Java 8 enables you to pass references of methods or constructors via the :: keyword.*/
		 
		// The below example shows how to reference a static method.
		staticMethodReferences();
		
		// But we can also reference object methods
		objectReferences();
		
		constructorReferences();
	}

	private static void staticMethodReferences() {
		Converter<String, Integer> converter2 = Integer::valueOf;
		Integer converted2 = converter2.convert("123");
		System.out.println(converted2);   // 123
	}

	private static void objectReferences() {
		Something something = new Something();
		Converter<String, String> converter = something::startsWith;
		String converted = converter.convert("Java");
		System.out.println(converted);    // "J"
	}

	/**
	 * Instead of implementing the factory manually, we glue everything together
	 * via constructor references We create a reference to the Person
	 * constructor via Person::new. The Java compiler automatically chooses the
	 * right constructor by matching the signature of PersonFactory.create.
	 */
	private static void constructorReferences() {
		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.create("Peter", "Parker");
		System.out.println(person);
	}
}
