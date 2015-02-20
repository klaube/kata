package kanbanBoard;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Katharina Laube
 * @since 20.02.2015
 */
public class OwnerTest {

	private Owner cut;

	@Before
	public void setUp() throws Exception {
		cut = new Owner("someone");
	}

	@Test
	public void a_new_owner_has_no_work_in_progress() {
		assertFalse(cut.has(State.WiP));
	}

	@Test
	public void a_new_owner_is_not_testing() {
		assertFalse(cut.has(State.Test));
	}

}
