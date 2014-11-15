import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class CellTest {
	
	@Test
	public void a_new_cell_should_be_alive() throws Exception {
		Cell cut = new Cell();
		assertTrue(cut.isAlive());
	}
}
