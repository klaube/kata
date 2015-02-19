package kanbanBoard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Each column of the board is represented by a state.
 * The tasks of the board are in a certain state.
 * 
 * @author Isabel Batista, Katharina Laube
 * @since 18.02.2015
 */
public class Board {
	
	private int taskWiPCounter;
	private int taskTestCounter;
	private List<Owner> owners;
	private HashMap<State, List<Task>> tasks;
	
	// TODO use a LinkedList to union nextState and previousState
	private static final HashMap<State, State> nextState = new HashMap<>();
	static {
		nextState.put(State.ToDo, State.WiP);
		nextState.put(State.WiP, State.Test);
		nextState.put(State.Test, State.Done);
	}
	
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
		
		tasks = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			List<Task> todos = tasks.getOrDefault(State.ToDo, new ArrayList<>());
			todos.add(createNewTask());
			tasks.put(State.ToDo, todos);
		}
	}
	
	Task createNewTask() {
		return new Task();
	}

	Task push(Task task) {
		
		switch (task.getState()) {
		case ToDo:
			
			if(taskWiPCounter >= 4) {
				throw new IllegalArgumentException("No owner available anymore.");
			}
			taskWiPCounter++;
			break;
			
		case WiP:
			
			if(taskTestCounter >= 3) {
				throw new IllegalArgumentException("No owner available anymore.");
			}
			taskWiPCounter--;
			taskTestCounter++;
			break;
			
		default:
			break;
		}
		
		final State newState = nextState.get(task.getState());
		task.setState(newState);
		
		for (Owner owner : owners) {
			if(!owner.has(newState)){
				task.setOwner(owner);
				owner.setNewState(newState);
				break;
			}
		}
		return task;
	}

	List<Owner> getOwners() {
		return owners;
	}

	List<Task> getTasks(State state) {
		return tasks.getOrDefault(state, new ArrayList<>());
	}

	public Task pull(State newState) {
		
		final State previousState = previousStates.get(newState);
		final List<Task> tasksOfPreviousState = getTasks(previousState);
		final int numberOfOpenTasks = tasksOfPreviousState.size();
		if (numberOfOpenTasks == 0) {
			return null;
		}
		
		// remove task from previous state
		final Task taskWithPreviousState = tasksOfPreviousState.remove(numberOfOpenTasks - 1);
		Task taskWithNewState = push(taskWithPreviousState);
		tasks.put(previousState, tasksOfPreviousState);
		
		// move task to new state
		final List<Task> tasksOfNewState = getTasks(newState);
		tasksOfNewState.add(taskWithNewState);
		tasks.put(newState, tasksOfNewState);
		return taskWithNewState;
	}

}
