package kanbanBoard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author Isabel Batista, Katharina Laube
 * @since 18.02.2015
 */
public class Board {
	
	private int taskWiPCounter;
	private int taskTestCounter;
	private List<Owner> owners;
	private HashMap<State, List<Task>> tasks;
	
	private static final HashMap<State, State> nextState = new HashMap<>();
	static {
		nextState.put(State.ToDo, State.WiP);
		nextState.put(State.WiP, State.Test);
		nextState.put(State.Test, State.Done);
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
			todos.add(addNewTask());
			tasks.put(State.ToDo, todos);
		}
	}
	
	public Task addNewTask() {
		return new Task();
	}

	public Task pull(Task task) {
		
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

	public List<Owner> getOwners() {
		return owners;
	}

	List<Task> getTasks(State state) {
		return tasks.get(state);
	}

}
