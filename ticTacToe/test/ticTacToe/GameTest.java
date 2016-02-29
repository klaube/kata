package ticTacToe;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {
	
	@Test
	public void a_new_game_should_not_be_over() throws Exception {
		Game game = new Game();
		assertFalse(game.isOver());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void a_duplicate_entry_should_not_be_allowed() throws Exception {
		Game game = new Game();
		game.setSymbol("X", 0, 0);
		game.setSymbol("O", 0, 0);
		
	}

}
