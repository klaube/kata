package gol;

public class Game {

	private int count;

	public boolean isAliveInNextGeneration() {
		return false;
	}

	public void createCell(int x, int y) {
		count++;
	}

	public boolean isAliveInNextGeneration(int x, int y) {
		return count > 1 && count < 4;
	}

}
