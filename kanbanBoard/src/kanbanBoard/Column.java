package kanbanBoard;

import java.util.ArrayList;
import java.util.List;

/**
 * One column represents one state of a task.
 * A column may have a limit which is the maximum number of allowed tasks.
 * 
 * @author Katharina Laube
 * @since 20.02.2015
 */
public class Column {
	
	private List<Task> tasks;
	private int limit;
	
	public Column() {
		this(-1);
	}

	public Column(int maximumNumberOfTasks) {
		this.limit = maximumNumberOfTasks;
		tasks = new ArrayList<Task>();
	}
	
	boolean hasSpace() {
		return limit == -1 || tasks.size() < limit;
	}

	public void addTask(Task task) {
		tasks.add(task);
	}

	public Task removeTask() {
		if(tasks.isEmpty()) {
			throw new IllegalStateException("Column has no tasks!");
		}
		
		return tasks.remove(tasks.size()-1);
	}

	public List<Task> getTasks() {
		return tasks;
	}

	int getLimit() {
		return limit;
	}
}
