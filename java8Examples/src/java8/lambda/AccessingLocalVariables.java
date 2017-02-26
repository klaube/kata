package java8.lambda;

public class AccessingLocalVariables {

	public static void main(String[] args) {
		
		accessingLocalVariables();
		
	}

	/**
	 * Accessing outer scope variables from lambda expressions is very similar
	 * to anonymous objects. You can access final variables from the local outer
	 * scope as well as instance fields and static variables. Accessing local
	 * variables. We can read final local variables from the outer scope of
	 * lambda expressions But different to anonymous objects the variable num
	 * does not have to be declared final. 
	 * - However num must be implicitly final for the code to compile. 
	 * - Writing to num from within the lambda expression is also prohibited.
	 **/
	private static void accessingLocalVariables() {
		
		int num = 1;
		Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);
		
		stringConverter.convert(2);     // 3
		
	}
}
