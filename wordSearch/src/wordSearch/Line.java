package wordSearch;

public class Line {

	private String row;

	public Line(String row) {
		this.row = row;
	}

	public boolean contains(String word) {
		return row.indexOf(word) > -1;
	}

}
