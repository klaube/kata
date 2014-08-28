package snl.game;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Max Schwaab, Katharina Laube
 * @since 27.08.2014
 */
public class PlayerTest {

    private Player cut;

    @Before
    public void setUp() throws Exception {
        cut = new Player();
    }
    
    @Test
    public void player_should_start_with_position_1() throws Exception {
    	assertThat(cut.getPosition(), equalTo(1));
    }

    @Test
    public void player_should_change_his_position() throws Exception {
        cut.setPosition(4);
        assertThat(cut.getPosition(), equalTo(4));
    }
}