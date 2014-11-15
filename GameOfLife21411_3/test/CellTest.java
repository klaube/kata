import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class CellTest {
	
	@Test
	public void a_new_cell_should_be_alive() throws Exception {
		Cell cut = new Cell();
		assertTrue(cut.isAlive());
	}
	
	@Test
	public void a_lonely_cell_should_die() throws Exception {
		Cell cut = new Cell();
		cut.tick();
		assertFalse(cut.isAlive());
	}
	
	@Test
	public void a_new_star_is_born() throws Exception {
		Cell cut = new Cell();
		cut.setAlive(false);
		
		Cell n1 = new Cell();
		Cell n2 = new Cell();
		Cell n3 = new Cell();		
		
		cut.addNeighbour(n1);
		cut.addNeighbour(n2);
		cut.addNeighbour(n3);
		
		cut.tick();
		
		assertTrue(cut.isAlive());
	}
}
