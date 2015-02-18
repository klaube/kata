package kanbanBoard;

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
	
	private static final HashMap<State, State> nextState = new HashMap<>();
	static {
		nextState.put(State.ToDo, State.WiP);
		nextState.put(State.WiP, State.Test);
		nextState.put(State.Test, State.Done);
	}
	
	public Task addNewTask() {
		return new Task();
	}

	public Task pull(Task task) {
		
		switch (task.getState()) {
		case ToDo:
			taskWiPCounter++;
			
			if(taskWiPCounter > 4) {
				throw new IllegalArgumentException("No owner available anymore.");
			}
			
			break;
			
		case WiP:
			taskTestCounter++;
			
			if(taskTestCounter > 3) {
				throw new IllegalArgumentException("No owner available anymore.");
			}
			
			break;
			
		default:
			break;
		}
		task.setState(nextState.get(task.getState()));
		
		return task;
	}

	public List<String> getOwners() {
		return Arrays.asList("Sven","Michael","Isabel","Katharina");
	}

}
