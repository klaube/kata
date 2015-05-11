package happyNumbers;

/**
 * @author Katharina Laube, Oliver Jahns
 * @since 11.05.2015
 */
public class Calculator {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		for (int i = 10; i <= 20; ++i)
			if (calculator.isHappy(i))
				System.out.println(i);
	}
	
	boolean isHappy(int number) {
		if (number == 4)
			return false;
		else if (number == 1)
			return true;
		else
			return isHappy(calcString(number));
	}

	int calcString(int number) {
		int sum = 0;
		String numberAsString = number + "";
		for (int i = 0; i < numberAsString.length(); i++) {
			char digitAsString = numberAsString.charAt(i);

			Integer digit = Integer.valueOf("" + digitAsString);
			sum += digit * digit;
		}
		return sum;
	}

	int calc(int number) {
		int sum = 0;
		while (number > 0) {
			int digit = extractDigit(number);
			number = shiftRight(number);
			sum += power(digit);
		}
		return sum;
	}

	int extractDigit(int number) {
		return number % 10;
	}

	int shiftRight(int number) {
		number = number / 10;
		return number;
	}

	int power(int digit) {
		return digit * digit;
	}

}
