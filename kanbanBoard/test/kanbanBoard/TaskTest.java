package kanbanBoard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Katharina Laube
 * @since 19.02.2015
 */
public class TaskTest {

	private Task cut;

	@Before
	public void setUp() throws Exception {
		cut = new Task();
	}

	@Test
	public void a_new_task_should_have_state_toDo() {
		assertNotNull(cut.getState());
		assertEquals(State.ToDo, cut.getState());
	}

	@Test
	public void a_new_task_does_not_have_state_an_owner_yet() {
		assertNull(cut.getOwner());
	}

}
