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
	
	@Test
	public void a_new_game_should_not_be_over2() throws Exception {
		Game game = new Game();
		game.setSymbol("X", 0, 0);
		game.setSymbol("O", 0, 1);
		assertFalse(game.isOver());
	}
	
	@Test
	public void a_new_game_should_not_be_over3() throws Exception {
		Game game = new Game();
		game.setSymbol("X", 0, 0);
		game.setSymbol("O", 0, 1);
		game.setSymbol("X", 0, 2);
		assertFalse(game.isOver());
	}
	
	@Test
	public void a_new_game_should_not_be_() throws Exception {
		Game game = new Game();
		game.setSymbol("X", 0, 0);
		game.setSymbol("X", 0, 1);
		game.setSymbol("X", 0, 2);
		assertTrue(game.isOver());
	}

}
