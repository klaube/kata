package snl.game;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Max Schwaab, Katharina Laube
 * @since 27.08.2014
 */
public class GameTest {

    private Game cut;
	private Player firstPlayer;

    @Before
    public void setUp() throws Exception {
        cut = new Game();
        
        firstPlayer = new Player();
        cut.addPlayer(firstPlayer);
    }

    @Test
    public void game_board_size_is_100() throws Exception {
        assertThat(cut.getFieldSize(), equalTo(100));
    }

    @Test
    public void game_should_end_when_current_player_position_is_end_field() throws Exception {
        firstPlayer.setPosition(cut.getFieldSize());
        assertThat(cut.isOver(), equalTo(true));
    }

    @Test
    public void move_player_should_change_players_position() throws Exception {
    	cut.moveCurrentPlayer(4);
    	int endPosition = cut.getPlayersPosition(firstPlayer);
    	assertThat(endPosition, equalTo(5));
    }

    @Test
    public void shift_player_should_change_Player() throws Exception {
        Player secondPlayer = new Player();
		cut.addPlayer(secondPlayer);
		assertThat(cut.getCurrentPlayer(), equalTo(firstPlayer));
		
		cut.shiftPlayer();
		assertThat(cut.getCurrentPlayer(), equalTo(secondPlayer));
    }

	@Test
	public void a_ladder_should_not_start_at_last_field() throws Exception {
		try {
			JumpRule ladder = new JumpRule(cut.getFieldSize(), cut.getFieldSize()+1, Type.LADDER);
			cut.addJumpRule(ladder);
			fail("Expected Exception!");
		} catch (IllegalArgumentException e) {
			// expected
		}
	}
	
	@Test
	public void a_ladder_should_not_start_before_first_field() throws Exception {
		try {
			JumpRule ladder = new JumpRule(0, 15, Type.LADDER);
			cut.addJumpRule(ladder);
			fail("Expected Exception!");
		} catch (IllegalArgumentException e) {
			// expected
		}
	}
}
