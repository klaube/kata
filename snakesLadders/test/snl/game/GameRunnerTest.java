package snl.game;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Katharina Laube
 * @since 01.09.2014
 */
public class GameRunnerTest {
	
    private GameRunner cut;

	@Before
    public void setUp() throws Exception {
		cut = new GameRunner();
    }

	@Test
    public void field_size_can_be_parsed() throws Exception {
		cut.parseLine("F:10*10");
        assertThat(cut.getFieldSize(), equalTo(100));
    }
	
	@Test
	public void ladder_can_be_parsed() throws Exception {
		cut.parseLine("F:10*10");
		cut.parseLine("L:5:10");
		
		JumpRule actualLadder = cut.getJumpRule(5);
		
		assertThat(actualLadder, notNullValue());
		assertThat(actualLadder.getType(), equalTo(Type.LADDER));
		assertThat(actualLadder.getStartPosition(), equalTo(5));
		assertThat(actualLadder.getEndPosition(), equalTo(10));
	}
	
	@Test
	public void snake_can_be_parsed() throws Exception {
		cut.parseLine("F:10*10");
		cut.parseLine("S:5:1");
		
		JumpRule actualLadder = cut.getJumpRule(5);
		
		assertThat(actualLadder, notNullValue());
		assertThat(actualLadder.getType(), equalTo(Type.SNAKE));
		assertThat(actualLadder.getStartPosition(), equalTo(5));
		assertThat(actualLadder.getEndPosition(), equalTo(1));
	}

	@Test
	public void runFullGameFromFile() throws Exception {
		cut.createGameFromFile();
	}
}
