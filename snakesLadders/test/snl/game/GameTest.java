package snl.game;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Max Schwaab, Katharina Laube
 * @since 27.08.2014
 */
public class GameTest {

    private Game cut;

    @Before
    public void setUp() throws Exception {
        cut = new Game();

    }

    @Test
    public void game_board_size_is_100() throws Exception {
        assertThat(cut.getSize(), is(100));

    }

    @Test
    public void game_should_end_when_current_player_position_is_end_field() throws Exception {
        final Player player = new Player();

        player.setPosition(cut.getSize());

        cut.addPlayer(player);

        assertThat(cut.isOver(), is(true));
    }

    @Test
    public void move_player_should_change_player_position() throws Exception {


    }

    @Test
    public void shift_player_should_increase() throws Exception {
        

    }
}
