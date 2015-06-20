package gol;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
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
	
	@Test
	public void testIfCellWithFourNeighborsDies() throws Exception {
		game.createCell(0,1);
		game.createCell(2,1);
		game.createCell(2,2);
		assertFalse(game.isAliveInNextGeneration(1,1));
	}
	

	
	@Test
	public void testNeighbourCount0() throws Exception {
		assertEquals(0, game.getNeighbourCount(1,1));
	}
	
	@Test
	public void testNeighbourCount3() throws Exception {
		game.createCell(0,0);
		game.createCell(0,1);
		game.createCell(1,0);
		game.createCell(1,1);
		assertEquals(3,game.getNeighbourCount(0,0));
	}
	
	@Ignore
	@Test
	@Parameters({
		"0,0",
//		"0,1",
//		"1,0",
//		"1,1",
	})
	public void testThatASquareOfCellsStaysImmortal(int x, int y) throws Exception {
		game.createCell(0,0);
		game.createCell(0,1);
		game.createCell(1,0);
		game.createCell(1,1);
		assertTrue(game.isAliveInNextGeneration(x,y));
	}
	
}
