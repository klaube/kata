package marsRover;

import java.util.ArrayList;
import java.util.List;

public class MarsRover {

	private Position position;
	private Direction direction;
	private Mars mars = new Mars();

	public MarsRover(Position startPosition) {
		this(startPosition, Direction.North);
	}

	public MarsRover(int startX, int startY) {
		this(new Position(startX, startY), Direction.North);
	}

	public MarsRover(Direction startDirection) {
		this(0, 0, startDirection);
	}

	public MarsRover(int startX, int startY, Direction startDirection) {
		this(new Position(startX, startY), startDirection);
	}

	private MarsRover(Position startPosition, Direction startDirection) {
		position = startPosition;
		direction = startDirection;
	}

	private MarsRover(MarsRover marsRover) {
		position = new Position(marsRover.getPosition());
		direction = marsRover.getDirection();
	}

	public Position getPosition() {
		return position;
	}

	public Direction getDirection() {
		return direction;
	}

	public List<MarsRover> move(Command... commands) {
		List<MarsRover> snapShots = new ArrayList<>();
		for (Command command : commands) {
			switch (command) {
			case Forward:
				switch (getDirection()) {
				case North: position.advanceY(1); break;
				case East:  position.advanceX(1); break;
				case South: position.advanceY(-1); break;
				case West:  position.advanceX(-1); break;
				}
				break;
			case Backward:
				switch (getDirection()) {
				case North: position.advanceY(-1); break;
				case East:  position.advanceX(-1); break;
				case South: position.advanceY(1); break;
				case West:  position.advanceX(1); break;
				}
				break;

			case Left:
				direction = direction.getNextDirection(false);
				break;

			case Right:
				direction = direction.getNextDirection(true);
				break;
			}
			snapShots.add(new MarsRover(this));

		}
		return snapShots;
	}

	void print() {
		Position currentPosition = getPosition();
		System.out.println(currentPosition);
		printHorizontal();
		for (int y = mars.getDimY(); y > 0; y--) {
			printVertical();
			for (int x = 0; x <= mars.getDimX(); x++) {
				if(currentPosition.equals(new Position(x, y))){
					getDirection().print();
				}
				else {
					System.out.print(" ");
				}
			}
			printVertical();
			System.out.println();
		}
		printHorizontal();
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void printVertical() {
		System.out.print("|");
	}

	private static void printHorizontal() {
		System.out.println(" -----------");
	}

	@Override
	public String toString() {
		return position + ", " + direction;
	}
}
