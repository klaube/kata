package kanbanBoard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
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
	public void a_board_has_an_initial_set_of_owner() {
		List<Owner> result = cut.getOwners();
		assertEquals(4, result.size());
		
		// owner of new board have nothing to do
		for (Owner owner : result) {
			assertFalse(owner.hasWorkInProgress());
			assertFalse(owner.isTesting());
		}
	}
	
	@Test
	public void a_wip_task_should_be_pulled_from_todo() {
		Task taskWip = cut.pull(State.WiP);
		
		assertEquals(State.WiP, taskWip.getState());
		assertFalse(cut.getTasks(State.ToDo).contains(taskWip));
		assertTrue(cut.getTasks(State.WiP).contains(taskWip));
	}
	
	@Test
	public void a_task_with_state_wip_must_have_an_owner() {
		Task task = cut.createNewTask();
		Task result = cut.push(task);
		
		assertNotNull(result.getOwner());
	}
	
	@Test
	public void a_task_with_state_wip_must_have_an_owner_from_board() {
		Task task = cut.createNewTask();
		Task result = cut.push(task);
		
		Owner ownerOfTask = result.getOwner();
		assertNotNull(ownerOfTask);
		List<Owner> owners = cut.getOwners();
		assertTrue(owners.contains(ownerOfTask));
		assertTrue(ownerOfTask.hasWorkInProgress());
		assertFalse(ownerOfTask.isTesting());
	}
	
	@Test
	public void a_task_with_state_test_must_have_an_owner_from_board() {
		Task taskToDo = cut.createNewTask();
		Task taskWiP = cut.push(taskToDo);
		Task result = cut.push(taskWiP);
		
		Owner ownerOfTask = result.getOwner();
		assertNotNull(ownerOfTask);
		List<Owner> owners = cut.getOwners();
		assertTrue(owners.contains(ownerOfTask));
		assertFalse(ownerOfTask.hasWorkInProgress());
		assertTrue(ownerOfTask.isTesting());
	}
	
	@Test
    @Parameters({
    	"1", 
    	"2", 
    	"3", 
    	"4"})
	public void maximum_4_tasks_with_state_wip_are_allow(int numberOfTasks) throws Exception {
		for (int i = 0; i < numberOfTasks; i++) {
			Task task = cut.createNewTask();
			cut.push(task);
		}
	}	
	
	@Test
	public void adding_the_fifth_task_with_state_wip_should_throw_exception() {
		
		for (int i = 0; i < 4; i++) {
			Task task = cut.createNewTask();
			cut.push(task);
		}

		try {
			Task task = cut.createNewTask();
			cut.push(task);
			fail();
		} catch (IllegalArgumentException e) {
			// expected
		}
	}
	
	@Test
	public void a_wip_task_should_be_pulled_to_test() {
		Task taskToDo = cut.createNewTask();
		Task taskWiP = cut.push(taskToDo);
		Task result = cut.push(taskWiP);
		
		assertEquals(State.Test, result.getState());
	}
	
	@Test
	public void a_test_task_should_be_pulled_to_done() {
		Task taskToDo = cut.createNewTask();
		Task taskWiP = cut.push(taskToDo);
		Task taskTest = cut.push(taskWiP);
		Task result = cut.push(taskTest);
		
		assertEquals(State.Done, result.getState());
	}	
	
	@Test
	public void an_owner_only_has_one_task_wip() {
		
		final HashSet<Owner> owners = new HashSet<>();
		
		addTaskPullToWipAndCheckOwner(owners);
		addTaskPullToWipAndCheckOwner(owners);
		addTaskPullToWipAndCheckOwner(owners);
		addTaskPullToWipAndCheckOwner(owners);
		
		try {
			addTaskPullToWipAndCheckOwner(owners);
			fail();
		} catch (IllegalArgumentException e){
			// expected
		}
	}

	private void addTaskPullToWipAndCheckOwner(final HashSet<Owner> owners) {
		final Task taskToDo = cut.createNewTask();
		final Task taskWiP = cut.push(taskToDo);
		
		final Owner owner = taskWiP.getOwner();
		assertFalse(owners.contains(owner));
		owners.add(owner);
	}	
	
	@Test
	public void an_owner_only_has_one_task_test() {
		
		final HashSet<Owner> owners = new HashSet<>();
		
		addTaskPullToTestAndCheckOwner(owners);
		addTaskPullToTestAndCheckOwner(owners);
		addTaskPullToTestAndCheckOwner(owners);
		
		try {
			addTaskPullToTestAndCheckOwner(owners);
			fail();
		} catch (IllegalArgumentException e){
			// expected
		}
	}

	private void addTaskPullToTestAndCheckOwner(final HashSet<Owner> owners) {
		final Task taskToDo = cut.createNewTask();
		final Task taskWiP = cut.push(taskToDo);
		final Task taskTest = cut.push(taskWiP);
		
		final Owner owner = taskTest.getOwner();
		assertFalse(owners.contains(owner));
		owners.add(owner);
	}

}
