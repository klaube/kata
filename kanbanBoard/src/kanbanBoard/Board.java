package kanbanBoard;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Isabel Batista, Katharina Laube
 * @since 18.02.2015
 */
public class Board {
	
	private int taskWiPCounter;
	private int taskTestCounter;
	
	public Task addNewTask() {
		return new Task();
	}

	public Task pull(Task task) {
		
		switch (task.getState()) {
		case ToDo:
			task.setState(State.WiP);
			taskWiPCounter++;
			
			if(taskWiPCounter > 4) {
				throw new IllegalArgumentException("No owner available anymore.");
			}
			
			break;
			
		case WiP:
			task.setState(State.Test);
			taskTestCounter++;
			
			if(taskTestCounter > 3) {
				throw new IllegalArgumentException("No owner available anymore.");
			}
			
			break;

		case Test:
			task.setState(State.Done);
			break;
		default:
			break;
		}
		
		return task;
	}

	public List<String> getOwners() {
		return Arrays.asList("Sven","Michael","Isabel","Katharina");
	}

}
