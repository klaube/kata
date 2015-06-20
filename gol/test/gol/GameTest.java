package gol;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
	
	private Game game;

	@Before
	public void setUp() {
		game = new Game();
		game.createCell(1,1);
	}
	
	@Test
	public void aLonelyCellShouldDie() throws Exception {
		assertFalse(game.isAliveInNextGeneration(1,1));
	}
	
	@Test
	public void testIfCellWithTwoNeighborsSurvives() throws Exception {
		game.createCell(0,1);
		game.createCell(2,1);
		assertTrue(game.isAliveInNextGeneration(1,1));
	}
	
}
