package wordSearch;

/**
 * The position of the word within the 2-dimensional matrix (x*y) declared by starts and end. 
 * The upper left corner is 0 and end the lower right corner is x*y-1.
 * 
 * @author Katharina Laube
 * @since 12.12.2014
 */
public class Position {

	private int start;
	private int end;

	public Position(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

}
