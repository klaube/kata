package ticTacToe;

public class Game {
	
	private String[][] board = new String[3][3]; 

	public boolean isOver() {
		return false;
	}

	public void setSymbol(String symbol, int x, int y) {
		if (board[x][y] != null) throw new IllegalArgumentException();
		board[x][y] = symbol;
	}

}
