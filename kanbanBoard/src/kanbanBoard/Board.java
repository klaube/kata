package kanbanBoard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Each column of the board is represented by a state.
 * The tasks of the board are in a certain column.
 * 
 * @author Isabel Batista, Katharina Laube
 * @since 18.02.2015
 */
public class Board {
	
	private List<Owner> owners;
	private HashMap<State, Column> columns;
	
	private static final HashMap<State, State> previousStates = new HashMap<>();
	static {
		previousStates.put(State.WiP, State.ToDo);
		previousStates.put(State.Test, State.WiP);
		previousStates.put(State.Done, State.Test);
	}
	
	public Board() {
		owners = Arrays.asList(
				new Owner("Sven"), 
				new Owner("Michael"), 
				new Owner("Isabel"), 
				new Owner("Katharina"));
		
		columns = new HashMap<>();
		columns.put(State.ToDo, new Column());
		columns.put(State.WiP, new Column(4));
		columns.put(State.Test, new Column(3));
		columns.put(State.Done, new Column());
		
		final Column toDoColumn = columns.get(State.ToDo);
		for (int i = 0; i < 10; i++) {
			toDoColumn.addTask(new Task());
		}
	}

	public Task pull(State newState) {
		
		if (!getColumn(newState).hasSpace()) {
			throw new IllegalStateException("Task could not be pulled, because the maximimum number of tasks is reached!");
		}

		// remove task from previous state
		final State previousState = previousStates.get(newState);
		Task task = getColumn(previousState).removeTask();

		// move task to new state
		task.setState(newState);
		
		// add owner of task
		for (Owner owner : owners) {
			if(!owner.has(newState)){
				task.setOwner(owner);
				owner.setNewState(newState);
				break;
			}
		}
		columns.get(task.getState()).addTask(task);
		
		return task;
	}

	Column getColumn(State state) {
		return columns.get(state);
	}
	
	List<Owner> getOwners() {
		return owners;
	}

	List<Task> getTasks(State state) {
		return getColumn(state).getTasks();
	}

}
