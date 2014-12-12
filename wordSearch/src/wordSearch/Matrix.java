package wordSearch;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

	private List<Line> lines;
	
	
	public Matrix(String matrixAsString) {
		lines = new ArrayList<>();
		
		// Horizontal lines
		String[] split = matrixAsString.split("\n");
		for (String string : split) {
			lines.add(new Line(string));
		}

		// vertical lines
		int length = split[0].length();
		for (int i = 0, j = 0; i < split.length; i++, j++) {
			String string = split[i];
			String currentChar = string.substring(j, j+1);
		}
		
	}

	public int getRowCount() {
		return lines.size();
	}

	public boolean contains(String string) {
		for (Line horizontalRow : lines) {
			if(horizontalRow.contains(string)) {
				return true;
			}
		}
		return false;
	}

}
