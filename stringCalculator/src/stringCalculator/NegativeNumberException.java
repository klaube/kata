package stringCalculator;

import java.util.List;

public class NegativeNumberException extends RuntimeException {

	private List<Integer> negativeNumbers;
	
	public NegativeNumberException(List<Integer> negativeNumbers) {
		this.negativeNumbers = negativeNumbers;
	}

	List<Integer> getNegativeNumbers() {
		return negativeNumbers;
	}

}
