package wordSearch;

/**
 * A line within the matrix with the given orientation..
 *
 * @author Till Friebe, Katharina Laube
 * @since 12.12.2014
 */
public class Line {

	private String sentence;
	private int startOfLineWithinMatrix;
	private Orientation orientation;
	private int horizontalLength;

	public Line(String sentence, int startPosition, Orientation orientation) {
		this(sentence, startPosition, orientation, -1);
	}

	public Line(String sentence, int startPosition, Orientation orientation, int horizontalLength) {
		this.sentence = sentence;
		this.startOfLineWithinMatrix = startPosition;
		this.orientation = orientation;
		this.horizontalLength = horizontalLength;
	}
	
	int getStartOfWordWithinSentence(String word) {
		return sentence.indexOf(word);
	}

	void add(String currentLetter) {
		sentence += currentLetter;
	}

	public Position getPositionWithinMatrix(String word, int positionInRow) {
		int startOfWordInMatrix = positionInRow + startOfLineWithinMatrix;
		int endInMatrix = getEndWithinMatrix(word, startOfWordInMatrix);
		return new Position(startOfWordInMatrix, endInMatrix);
	}

	private int getEndWithinMatrix(String word, int startOfWordInMatrix) {
		switch (orientation) {
		case HORIZONTAL: return startOfWordInMatrix + word.length() - 1;
		case VERTICAL: return startOfWordInMatrix + ((word.length() - 1) * horizontalLength);
		default: throw new IllegalArgumentException("Orientation "+ orientation + " is not yet supported!");
		} 
	}
	
	String getRow() {
		return sentence;
	}
}
