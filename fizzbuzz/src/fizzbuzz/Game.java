package fizzbuzz;

public class Game {

	private static final String BUZZ = "buzz";
	private static final String FIZZ = "fizz";

	static String anwser(final Integer input) {
		
		String anwser = "";
		
		if(input % 3 == 0) {
			anwser += FIZZ;
		}
		
		if(input % 5 == 0) {
			anwser += BUZZ;
		}
		
		if (anwser.isEmpty()) {
			anwser = input.toString();
		}
		
		return anwser;
	}
}