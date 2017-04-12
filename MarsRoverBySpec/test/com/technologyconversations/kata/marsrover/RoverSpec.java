package com.technologyconversations.kata.marsrover;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.beans.SamePropertyValuesAs.*;
import static org.hamcrest.core.StringEndsWith.endsWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * based on: http://dallashackclub.com/rover<br />
 * changed from AssertJ to Junit with hamcrest
 * <p>
 * Develop an api that moves a rover around on a grid.
 * <p>
 * You are given the initial starting point (x,y) of a rover and the direction
 * (N,S,E,W) it is facing.<br />
 * - The rover receives a character array of commands.<br />
 * - Implement commands that move the rover forward/backward (f,b).<br />
 * - Implement commands that turn the rover left/right (l,r).<br />
 * - Implement wrapping from one edge of the grid to another. (planets are
 * spheres after all)<br />
 * - Implement obstacle detection before each move to a new square.<br />
 * If a given sequence of commands encounters an obstacle, the rover moves up to
 * the last possible point and reports the obstacle.
 */
public class RoverSpec {

    private Rover rover;
    private Coordinates roverCoordinates;
    private final Direction direction = Direction.NORTH;
    private Point x;
    private Point y;
    private List<Obstacle> obstacles;

    @Before
    public void beforeRoverTest() {
        x = new Point(1, 9);
        y = new Point(2, 9);
        obstacles = new ArrayList<Obstacle>();
        roverCoordinates = new Coordinates(x, y, direction, obstacles);
        rover = new Rover(roverCoordinates);
    }

    @Test
    public void newInstanceShouldSetRoverCoordinatesAndDirection() {
        assertThat(rover.getCoordinates(), samePropertyValuesAs(roverCoordinates));
    }

    @Ignore
    @Test
    public void receiveSingleCommandShouldMoveForwardWhenCommandIsF() throws Exception {
        int expected = y.getLocation() + 1;
        rover.receiveSingleCommand('F');
        assertEquals(expected, rover.getCoordinates().getY().getLocation());
    }

    @Ignore
    @Test
    public void receiveSingleCommandShouldMoveBackwardWhenCommandIsB() throws Exception {
        int expected = y.getLocation() - 1;
        rover.receiveSingleCommand('B');
        assertEquals(expected, rover.getCoordinates().getY().getLocation());
    }

    @Ignore
    @Test
    public void receiveSingleCommandShouldTurnLeftWhenCommandIsL() throws Exception {
        rover.receiveSingleCommand('L');
        assertEquals(Direction.WEST, rover.getCoordinates().getDirection());
    }

    @Ignore
    @Test
    public void receiveSingleCommandShouldTurnRightWhenCommandIsR() throws Exception {
        rover.receiveSingleCommand('R');
        assertEquals(Direction.EAST, rover.getCoordinates().getDirection());
    }

    @Ignore
    @Test
    public void receiveSingleCommandShouldIgnoreCase() throws Exception {
        rover.receiveSingleCommand('r');
        assertEquals(Direction.EAST, rover.getCoordinates().getDirection());
    }

    @Ignore
    @Test(expected = Exception.class)
    public void receiveSingleCommandShouldThrowExceptionWhenCommandIsUnknown() throws Exception {
        rover.receiveSingleCommand('X');
    }

    @Ignore
    @Test
    public void receiveCommandsShouldBeAbleToReceiveMultipleCommands() throws Exception {
        int expected = x.getLocation() + 1;
        rover.receiveCommands("RFR");
        assertEquals(expected, rover.getCoordinates().getX().getLocation());
        assertEquals(Direction.SOUTH, rover.getCoordinates().getDirection());
    }

    @Ignore
    @Test
    public void receiveCommandShouldWhatFromOneEdgeOfTheGridToAnother() throws Exception {
        int expected = x.getMaxLocation() + x.getLocation() - 2;
        rover.receiveCommands("LFFF");
        assertEquals(expected, rover.getCoordinates().getX().getLocation());
    }

    @Ignore
    @Test
    public void receiveCommandsShouldStopWhenObstacleIsFound() throws Exception {
        int expected = x.getLocation() + 1;
        rover.getCoordinates().setObstacles(Arrays.asList(new Obstacle(expected + 1, y.getLocation())));
        rover.getCoordinates().setDirection(Direction.EAST);
        rover.receiveCommands("FFFRF");
        assertEquals(expected, rover.getCoordinates().getX().getLocation());
        assertEquals(Direction.EAST, rover.getCoordinates().getDirection());
    }

    @Ignore
    @Test
    public void positionShouldReturnXYAndDirection() throws Exception {
        rover.receiveCommands("LFFFRFF");
        assertEquals("8 X 4 N", rover.getPosition());
    }

    @Ignore
    @Test
    public void positionShouldReturnNokWhenObstacleIsFound() throws Exception {
        rover.getCoordinates().setObstacles(Arrays.asList(new Obstacle(x.getLocation() + 1, y.getLocation())));
        rover.getCoordinates().setDirection(Direction.EAST);
        rover.receiveCommands("F");
        assertThat(rover.getPosition(), endsWith(" NOK"));
    }

}