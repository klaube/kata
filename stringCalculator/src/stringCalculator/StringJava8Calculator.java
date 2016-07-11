package stringCalculator;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class StringJava8Calculator {


	public int add(String delimeterAndNumberStr) {
		Predicate<String> isEmpty = String::isEmpty;
		if(isEmpty.test(delimeterAndNumberStr)) {
			return 0;
		}

		if (delimeterAndNumberStr.endsWith("\n")) {
			throw new IllegalArgumentException();
		}

		String delimeter = ",";
		String numberStr = delimeterAndNumberStr;
		if (delimeterAndNumberStr.startsWith("//")) {
			int numberStart = delimeterAndNumberStr.indexOf('\n');
			numberStr = delimeterAndNumberStr.substring(numberStart + 1);
			delimeter = delimeterAndNumberStr.substring(2, numberStart);
		}
		
		List<String> allNumbers = Arrays.asList(numberStr.split(delimeter + "|\n"));
		
		List<Integer> negativNumbers = new ArrayList<>();
		IntStream numbers = allNumbers.stream().mapToInt(it -> {
			Integer number = Integer.valueOf(it);
			
			// collecting negative numbers for Exception
			if(number < 0) {
				negativNumbers.add(number);
			}
			return number;
		});
		
		// sum must be called before checking negativeNumbers
		// otherwise negativeNumbers is not filled 
		int sum = numbers.sum();
		
		if(!negativNumbers.isEmpty()) {
			throw new NegativeNumberException(negativNumbers);
		}
		return sum;
	}
}
