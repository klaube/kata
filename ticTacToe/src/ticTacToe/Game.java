package ticTacToe;

public class Game {
	
	private String[][] board = new String[3][3]; 

	public boolean isOver() {
		return hasFullRow();
	}

	private boolean hasFullRow() {
		return "X".equals(board[0][0]) && "X".equals(board[0][1]) && "X".equals(board[0][2]);
	}

	public void setSymbol(String symbol, int x, int y) {
		if (board[x][y] != null) throw new IllegalArgumentException();
		board[x][y] = symbol;
	}

}
