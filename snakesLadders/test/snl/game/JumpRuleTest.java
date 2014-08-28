package snl.game;

import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * @author Katharina Laube
 */
public class JumpRuleTest {
	
	@Test
	public void a_ladder_should_end_after_start() throws Exception {
		try {
			new JumpRule(1, 1, Type.LADDER);
			fail("Expected Exception!");
		} catch (IllegalArgumentException e) {
			// expected
		}
	}
	
	@Test
	public void a_snake_should_end_before_start() throws Exception {
		try {
			new JumpRule(1, 1, Type.SNAKE);
			fail("Expected Exception!");
		} catch (IllegalArgumentException e) {
			// expected
		}
	}

}
