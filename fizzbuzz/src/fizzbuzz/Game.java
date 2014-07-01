package fizzbuzz;

import java.util.Arrays;
import java.util.List;

public class Game {

	private static final String BUZZ = "buzz";
	private static final String FIZZ = "fizz";
	
	static String calculateAnwser(final Integer input) {
		return getAllAnswers(input).get(input % 15);
	}

	private static List<String> getAllAnswers(final Integer input) {
		
		final String simpleAnswer = input.toString();
		
		final List<String> answers = Arrays.asList(
				FIZZ+BUZZ, 
				simpleAnswer, 
				simpleAnswer,
				FIZZ, 
				simpleAnswer,
				BUZZ, 
				FIZZ, 
				simpleAnswer,
				simpleAnswer,
				FIZZ, 
				BUZZ, 
				simpleAnswer,
				FIZZ, 
				simpleAnswer,
				simpleAnswer,
				simpleAnswer
				);
		return answers;
	}
}