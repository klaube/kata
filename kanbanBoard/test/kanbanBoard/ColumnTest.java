package kanbanBoard;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Katharina Laube
 * @since 20.02.2015
 */
public class ColumnTest {
	
	@Test
	public void a_task_should_be_added_to_a_column_with_no_limit() throws Exception {
		
		Column cut = new Column();
		Task task = new Task();
		cut.addTask(task);
		
		assertTrue(cut.getTasks().contains(task));
	}
	
	@Test
	public void a_task_should_be_removed_from_column() throws Exception {
		
		Column cut = new Column();
		Task task = new Task();
		
		cut.addTask(task);
		assertTrue(cut.getTasks().contains(task));

		cut.removeTask();
		assertFalse(cut.getTasks().contains(task));
	}	
	
	@Test
	public void limit() {
		
		Column cut = new Column(2);
		cut.addTask(new Task());
		assertTrue(cut.hasSpace());
		
		cut.addTask(new Task());
		assertFalse(cut.hasSpace());
	}

}
