package stringCalculator;


import java.util.ArrayList;

/**
 * Implementation with Java 5
 *
 * @author Katharina Laube
 */
public class StringCalculator {

	public int add(String numbersWithDelimeter) {
		if("".equals(numbersWithDelimeter)) {
			return 0;
		}

		if (numbersWithDelimeter.endsWith("\n")) {
			throw new IllegalArgumentException();
		}

		String delimeter = extractDelimeter(numbersWithDelimeter);

		String numbersString = numbersWithDelimeter;
		if (numbersWithDelimeter.startsWith("//")) {
			int numberStart = numbersWithDelimeter.indexOf('\n');
			numbersString = numbersWithDelimeter.substring(numberStart + 1);
		}
		
		int sum = 0;
		ArrayList<Integer> negativeNumbers = new ArrayList<>();
		
		String[] numbers = numbersString.split(delimeter + "|\n");
		for (String numberString : numbers) {
			int number = Integer.valueOf(numberString).intValue();
			if(number < 0) {
				negativeNumbers.add(number);
			}
			else {
				sum += number;
			}
		}
		
		if(negativeNumbers.isEmpty()) {
			return sum;
		}
		
		throw new NegativeNumberException(negativeNumbers);
	}
	
	String extractDelimeter(String delimeterAndNumberStr) {
		int begin = delimeterAndNumberStr.indexOf("//");
		if(begin < 0) {
			return ",";
		}
		int end = delimeterAndNumberStr.indexOf("\n");
		return delimeterAndNumberStr.substring(begin+2, end);
	}

}
