package marsRover;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class MarsRoverTest {

	@Parameters(method="northParams")
	@Test
	public void testNorthMovements(
			MarsRover startMarsRover, MarsRover expected, Command move) throws Exception {
		startMarsRover.move(move);
		assertEquals(expected.getPosition(), startMarsRover.getPosition());
		assertEquals(expected.getDirection(), startMarsRover.getDirection());
	}

	@SuppressWarnings("unused")
	private static Object[] northParams() {
		return new Object[]{
				new Object[]{new MarsRover(0,1), new MarsRover(0,2), Command.Forward},
				new Object[]{new MarsRover(0,0), new MarsRover(0,1), Command.Forward},
				new Object[]{new MarsRover(0,-1), new MarsRover(0,0), Command.Forward},

				new Object[]{new MarsRover(0,1), new MarsRover(0,0), Command.Backward},
				new Object[]{new MarsRover(0,0), new MarsRover(0,-1), Command.Backward},
				new Object[]{new MarsRover(0,-1), new MarsRover(0,-2), Command.Backward}
		};
	}

	@Parameters(method="directionParams")
	@Test
	public void testMovements(
			MarsRover startMarsRover, MarsRover expected, Command move) throws Exception {
		startMarsRover.move(move);
		assertEquals(expected.getPosition(), startMarsRover.getPosition());
		assertEquals(expected.getDirection(), startMarsRover.getDirection());
	}

	@SuppressWarnings("unused")
	private static Object[] directionParams() {
		return new Object[]{
				new Object[]{new MarsRover(Direction.East), new MarsRover(1,0, Direction.East), Command.Forward},
				new Object[]{new MarsRover(Direction.East), new MarsRover(-1,0, Direction.East), Command.Backward},

				new Object[]{new MarsRover(Direction.South), new MarsRover(0, -1, Direction.South), Command.Forward},
				new Object[]{new MarsRover(Direction.South), new MarsRover(0, 1, Direction.South), Command.Backward},

				new Object[]{new MarsRover(Direction.West), new MarsRover(-1,0, Direction.West), Command.Forward},
				new Object[]{new MarsRover(Direction.West), new MarsRover(1,0, Direction.West), Command.Backward}
		};
	}

	@Parameters(method="rotateParams")
	@Test
	public void testRotation(
			MarsRover startMarsRover, MarsRover expected, Command rotation) throws Exception {
		startMarsRover.move(rotation);
		assertEquals(expected.getDirection(), startMarsRover.getDirection());
		assertEquals(expected.getPosition(), startMarsRover.getPosition());
	}

	@SuppressWarnings("unused")
	private static Object[] rotateParams() {
		return new Object[]{
				new Object[]{new MarsRover(Direction.North), new MarsRover(Direction.West), Command.Left},
				new Object[]{new MarsRover(Direction.East), new MarsRover(Direction.North), Command.Left},
				new Object[]{new MarsRover(Direction.South), new MarsRover(Direction.East), Command.Left},
				new Object[]{new MarsRover(Direction.West), new MarsRover(Direction.South), Command.Left},

				new Object[]{new MarsRover(Direction.North), new MarsRover(Direction.East), Command.Right},
				new Object[]{new MarsRover(Direction.East), new MarsRover(Direction.South), Command.Right},
				new Object[]{new MarsRover(Direction.South), new MarsRover(Direction.West), Command.Right},
				new Object[]{new MarsRover(Direction.West), new MarsRover(Direction.North), Command.Right}
		};
	}

	@Parameters(method="manyCommands")
	@Test
	public void testManyCommands(Position endPosition, Command... commands) throws Exception {
		MarsRover marsRover = new MarsRover(new Position(0,1));
		marsRover.move(commands);
		assertEquals(endPosition, marsRover.getPosition());
	}

	@SuppressWarnings("unused")
	private static Object[] manyCommands() {
		return new Object[]{
				new Object[]{new Position(0,1), Command.Forward, Command.Backward},
				new Object[]{new Position(0,4), Command.Forward, Command.Forward, Command.Forward}
		};
	}
}