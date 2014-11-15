import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class CellTest {
	
	@Test
	public void a_new_cell_should_be_alive() throws Exception {
		Cell cut = new Cell();
		assertTrue(cut.isAlive());
	}
	
	@Test // rule 1
	public void a_lonely_cell_should_die() throws Exception {
		Cell cut = new Cell();
		cut.tick();
		assertFalse(cut.isAlive());
	}
	
	@Test // rule 2
	public void should_i_stay_or_should_i_go() throws Exception {
		Cell cut = new Cell();
		
		cut.addNeighbour(new Cell());
		cut.addNeighbour(new Cell());
		if(Math.random() > 0.5) {
			cut.addNeighbour(new Cell());
		}
		
		cut.tick();
		
		assertTrue(cut.isAlive());
	}
	
	@Test // rule 3
	public void party_people_die() throws Exception {
		Cell cut = new Cell();
		
		cut.addNeighbour(new Cell());
		cut.addNeighbour(new Cell());
		cut.addNeighbour(new Cell());
		cut.addNeighbour(new Cell());
		
		cut.tick();
		
		assertFalse(cut.isAlive());
	}
	
	@Test // rule 4
	public void a_new_star_is_born() throws Exception {
		Cell cut = new Cell();
		cut.setAlive(false);
		
		cut.addNeighbour(new Cell());
		cut.addNeighbour(new Cell());
		cut.addNeighbour(new Cell());
		
		cut.tick();
		
		assertTrue(cut.isAlive());
	}
}
