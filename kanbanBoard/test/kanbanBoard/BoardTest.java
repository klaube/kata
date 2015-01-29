package kanbanBoard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 
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
	public void a_new_task_should_have_state_toDo() {
		Task result = cut.addNewTask();
		assertNotNull(result.getState());
		assertEquals(State.ToDo, result.getState());
	}
	
	@Test
	public void a_toDo_task_should_be_pulled_to_wip() {
		Task task = cut.addNewTask();
		Task result = cut.pull(task);
		
		assertEquals(State.WiP, result.getState());
	}
	
	@Test
	public void a_task_with_state_wip_must_have_an_owner() {
		Task task = cut.addNewTask();
		Task result = cut.pull(task);
		
		assertNotNull(result.getOwner());
	}
	
	@Test
	public void a_board_has_an_initial_set_of_owner() {
		List<String> result = cut.getOwners();
		assertEquals(4, result.size());
	}
	
	@Test
	public void a_task_with_state_wip_must_have_an_owner_from_board() {
		Task task = cut.addNewTask();
		Task result = cut.pull(task);
		
		String ownerOfTask = result.getOwner();
		assertNotNull(ownerOfTask);
		List<String> owners = cut.getOwners();
		assertTrue(owners.contains(ownerOfTask));
	}
	
	@Test
	public void a_task_with_state_test_must_have_an_owner_from_board() {
		Task taskToDo = cut.addNewTask();
		Task taskWiP = cut.pull(taskToDo);
		Task result = cut.pull(taskWiP);
		
		String ownerOfTask = result.getOwner();
		assertNotNull(ownerOfTask);
		List<String> owners = cut.getOwners();
		assertTrue(owners.contains(ownerOfTask));
	}
	
	@Test
    @Parameters({
    	"1", 
    	"2", 
    	"3", 
    	"4"})
	public void maximum_4_tasks_with_state_wip_are_allow(int numberOfTasks) throws Exception {
		for (int i = 0; i < numberOfTasks; i++) {
			Task task = cut.addNewTask();
			cut.pull(task);
		}
	}	
	
	@Test
	public void adding_the_fifth_task_with_state_wip_should_throw_exception() {
		
		for (int i = 0; i < 4; i++) {
			Task task = cut.addNewTask();
			cut.pull(task);
		}

		try {
			Task task = cut.addNewTask();
			cut.pull(task);
			fail();
		} catch (IllegalArgumentException e) {
			// expected
		}
	}
	
	@Test
	public void a_wip_task_should_be_pulled_to_test() {
		Task taskToDo = cut.addNewTask();
		Task taskWiP = cut.pull(taskToDo);
		Task result = cut.pull(taskWiP);
		
		assertEquals(State.Test, result.getState());
	}
	
	@Test
	public void a_test_task_should_be_pulled_to_done() {
		Task taskToDo = cut.addNewTask();
		Task taskWiP = cut.pull(taskToDo);
		Task taskTest = cut.pull(taskWiP);
		Task result = cut.pull(taskTest);
		
		assertEquals(State.Done, result.getState());
	}

}
