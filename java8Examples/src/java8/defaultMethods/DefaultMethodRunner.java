package java8.defaultMethods;

public class DefaultMethodRunner {

	public static void main(String[] args) {

		// The formula is implemented as an anonymous object. 
		Formula formula = new Formula() {
			@Override
			public double calculate(int a) {
				return sqrt(a * 100);
			}
		};
		
		System.out.println(formula.calculate(9));     // 30.0
		System.out.println(formula.sqrt(16));           // 4.0
	}
}
