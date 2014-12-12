package wordSearch;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

	private List<Line> rows = new ArrayList<>();
	private List<Line> columns = new ArrayList<>();


	public Matrix(String matrixAsString) {

		String[] split = matrixAsString.split("\n");
		int lengthOfRow = split[0].length();
		for (int y = 0; y < split.length; y++) {
			
			// horizontal lines
			String rowAsString = split[y];
			Line row = new Line(rowAsString, y*lengthOfRow, Orientation.HORIZONTAL);
			rows.add(row);
			
			// vertical lines
			fillColumns(lengthOfRow, y, rowAsString);
		}
	}

	void fillColumns(int lengthOfRow, int y, String rowAsString) {
		for (int x = 0; x < lengthOfRow; x++) {
			String currentLetter = rowAsString.substring(x, x+1);
			if(y == 0) {
				Line column = new Line(currentLetter, x, Orientation.VERTICAL, lengthOfRow);
				columns.add(column);
			} else {
				columns.get(x).add(currentLetter);
			}
		}
	}

	public int getRowCount() {
		return rows.size();
	}

	public Position getPosition(String word) {
		
		// horizontals
		for (Line horizontal : rows) {
			int positionInRow = horizontal.getStartOfWord(word);
			if(positionInRow > -1) {
				return horizontal.getPosition(word, positionInRow);
			}
		}
		
		//verticals
		for (Line vertical : columns) {
			int positionInColumn = vertical.getStartOfWord(word);
			if(positionInColumn > -1) {
				return vertical.getPosition(word, positionInColumn);
			}
		}
		
		throw new IllegalArgumentException("Word is unknown!");
	}

	public int getColumnCount() {
		return columns.size();
	}

}
