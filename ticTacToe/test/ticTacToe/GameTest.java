package ticTacToe;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {
	
	@Test
	public void a_new_game_should_not_be_over() throws Exception {
		Game game = new Game();
		assertFalse(game.isOver());
	}

}
