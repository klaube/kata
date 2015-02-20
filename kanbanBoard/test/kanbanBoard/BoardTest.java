package kanbanBoard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.List;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Isabel Batista, Katharina Laube
 * @since 18.02.2015
 */
@RunWith(JUnitParamsRunner.class)
public class BoardTest {

	private Board cut;

	@Before
	public void setUp() throws Exception {
		cut = new Board();
	}

	@Test
    @Parameters({
    	"ToDo, 10", 
    	"WiP, 0", 
    	"Test, 0", 
    	"Done, 0"})
	public void a_new_board_should_have_tasks_only_with_state_toDo(State state, int numberOfTasks) {
		List<Task> result = cut.getTasks(state);
		assertEquals(numberOfTasks, result.size());
	}

	@Test
    @Parameters({
    	"ToDo, -1", 
    	"WiP, 4", 
    	"Test, 3", 
    	"Done, -1"})
	public void only_columns_wip_and_test_should_have_an_limit(State state, int limit) throws Exception {
		Column column = cut.getColumn(state);
		assertEquals(limit, column.getLimit());
	}
	
	@Test
	public void a_wip_task_should_be_pulled_from_todo() {
		Task taskWip = cut.pull(State.WiP);
		
		assertEquals(State.WiP, taskWip.getState());
		assertFalse(cut.getTasks(State.ToDo).contains(taskWip));
		assertTrue(cut.getTasks(State.WiP).contains(taskWip));
	}
	
	@Test
	public void a_test_task_should_be_pulled_from_test() {
		cut.pull(State.WiP);
		Task taskTest = cut.pull(State.Test);

		assertEquals(State.Test, taskTest.getState());
		assertFalse(cut.getTasks(State.WiP).contains(taskTest));
		assertTrue(cut.getTasks(State.Test).contains(taskTest));
	}
	
	@Test
	public void a_board_has_an_initial_set_of_owner() {
		List<Owner> result = cut.getOwners();
		assertEquals(4, result.size());
	}
	
	@Test
	public void todo_tasks_do_not_have_an_owner() {
		List<Task> result = cut.getTasks(State.ToDo);
		
		for (Task taskToDo : result) {
			assertNull(taskToDo.getOwner());
		}
	}
	
	@Test
	public void a_task_with_state_wip_must_have_an_owner() {
		Task result = cut.pull(State.WiP);		
		assertNotNull(result.getOwner());
	}
	
	@Test
	public void a_task_with_state_wip_must_have_an_owner_from_board() {
		Task result = cut.pull(State.WiP);		
		
		Owner ownerOfTask = result.getOwner();
		assertNotNull(ownerOfTask);
		List<Owner> owners = cut.getOwners();
		assertTrue(owners.contains(ownerOfTask));
		assertTrue(ownerOfTask.has(State.WiP));
		assertFalse(ownerOfTask.has(State.Test));
	}
	
	@Test
	public void a_task_with_state_test_must_have_an_owner_from_board() {
		cut.pull(State.WiP);
		Task taskTest = cut.pull(State.Test);
		
		Owner ownerOfTask = taskTest.getOwner();
		assertNotNull(ownerOfTask);
		List<Owner> owners = cut.getOwners();
		assertTrue(owners.contains(ownerOfTask));
		assertFalse(ownerOfTask.has(State.WiP));
		assertTrue(ownerOfTask.has(State.Test));
	}
	
	@Test
	public void only_four_task_in_state_work_in_progress_are_allowed() {
		
		final HashSet<Owner> owners = new HashSet<>();
		
		pullToWipAndCheckOwner(owners);
		pullToWipAndCheckOwner(owners);
		pullToWipAndCheckOwner(owners);
		pullToWipAndCheckOwner(owners);
		
		try {
			pullToWipAndCheckOwner(owners);
			fail();
		} catch (IllegalStateException e){
			// expected
		}
	}

	private void pullToWipAndCheckOwner(final HashSet<Owner> owners) {
		final Task taskWiP = cut.pull(State.WiP);
		 
		final Owner owner = taskWiP.getOwner();
		assertFalse(owners.contains(owner));
		owners.add(owner);
	}	
	
	@Test
	public void only_three_tasks_in_state_test_are_allowed() {
		
		final HashSet<Owner> owners = new HashSet<>();
		
		pullToTestAndCheckOwner(owners);
		pullToTestAndCheckOwner(owners);
		pullToTestAndCheckOwner(owners);
		
		try {
			pullToTestAndCheckOwner(owners);
			fail();
		} catch (IllegalStateException e){
			// expected
		}
	}

	private void pullToTestAndCheckOwner(final HashSet<Owner> owners) {
		cut.pull(State.WiP);
		final Task taskTest = cut.pull(State.Test);
		
		final Owner owner = taskTest.getOwner();
		assertFalse(owners.contains(owner));
		owners.add(owner);
	}

}
