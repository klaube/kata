package wordSearch;

public class Line {

	private String sentence;
	private int startOfLineWithinMatrix;
	private Orientation orientation;
	private int horizontalLength;

	public Line(String sentence, int startPosition, Orientation orientation) {
		this.sentence = sentence;
		this.startOfLineWithinMatrix = startPosition;
		this.orientation = orientation;
	}

	public Line(String sentence, int startPosition, Orientation orientation, int horizontalLength) {
		this.sentence = sentence;
		this.startOfLineWithinMatrix = startPosition;
		this.orientation = orientation;
		this.horizontalLength = horizontalLength;
	}
	
	int getStartOfWord(String word) {
		return sentence.indexOf(word);
	}

	int getStartWithinMatrix() {
		return startOfLineWithinMatrix;
	}

	void add(String currentLetter) {
		sentence += currentLetter;
	}

	public Position getPosition(String word, int positionInRow) {
		int startOfWordInMatrix = positionInRow + startOfLineWithinMatrix;
		int endInMatrix = getEndInMatrix(word, startOfWordInMatrix);
		return new Position(startOfWordInMatrix, endInMatrix);
	}

	int getEndInMatrix(String word, int startOfWordInMatrix) {
		switch (orientation) {
		case HORIZONTAL: return startOfWordInMatrix + word.length() - 1;
		case VERTICAL: return startOfWordInMatrix + ((word.length() - 1) * horizontalLength);
		default: return -1;
		}
	}
	
	String getRow() {
		return sentence;
	}
}
