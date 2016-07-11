package stringCalculator;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringRegexCalculator {


	public int add(String delimeterAndNumberStr) {
		if("".equals(delimeterAndNumberStr)) {
			return 0;
		}

		if (delimeterAndNumberStr.endsWith("\n")) {
			throw new IllegalArgumentException();
		}

		String delimeter = extractDelimeter(delimeterAndNumberStr);


		String numberStr = delimeterAndNumberStr;
		if (delimeterAndNumberStr.startsWith("//")) {
			int numberStart = delimeterAndNumberStr.indexOf('\n');
			numberStr = delimeterAndNumberStr.substring(numberStart + 1);
		}
		
		validate(numberStr);
		return Arrays.asList(numberStr.split(delimeter + "|\n")).stream()
				.mapToInt(it -> Integer.valueOf(it))
				.sum();
	}
	
	String extractDelimeter(String delimeterAndNumberStr) {
		Pattern pattern = Pattern.compile("\\//(.*?)\\\n");
		Matcher m = pattern.matcher(delimeterAndNumberStr);
		while(m.find()) {
			return m.group(1);
		}
		return ",";
	}

	void validate(String numberStr) {
		ArrayList<Integer> negativeNumbers = new ArrayList<>();
		Pattern pattern = Pattern.compile("-\\d+");
		Matcher m = pattern.matcher(numberStr);
		while(m.find()) {
			 negativeNumbers.add(Integer.valueOf(m.group()));
		}
		if(negativeNumbers.isEmpty()) {
			return;
		}
		throw new NegativeNumberException(negativeNumbers);
	}
}
