package marsRover;

import java.util.List;

public class Expedition {

	public static void main(String[] args) {

		MarsRover rover = new MarsRover(4, 6, Direction.North);
		List<MarsRover> snapShots = rover.move(

				Command.Right, Command.Forward, Command.Forward, Command.Forward,
				Command.Right, Command.Forward, Command.Forward, Command.Forward,
				Command.Right, Command.Forward, Command.Forward, Command.Forward,
				Command.Right, Command.Forward, Command.Forward, Command.Forward,

				Command.Forward, Command.Forward, Command.Forward, Command.Forward,
				Command.Forward, Command.Forward, Command.Forward, Command.Forward,

				Command.Backward, Command.Backward, Command.Backward, Command.Backward,
				Command.Backward, Command.Backward, Command.Backward, Command.Backward

				);
		snapShots.add(0, rover);

		for (MarsRover marsRover : snapShots) {
			marsRover.print();
		}
	}
}
