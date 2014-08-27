package snl.game;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Ignore;
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
    public void playerShouldKnowHisPosition() throws Exception {
        cut.setPosition(4);
        assertThat(cut.getPosition(), equalTo(4));
    }

    @Test
    public void rollDiceShouldIncreasesPosition() throws Exception {
        final int startPosition = cut.getPosition();

        cut.rollDice();

        final int endPosition = cut.getPosition();

        assertThat(endPosition > startPosition, is(true));
    }

    @Ignore
    @Test
    public void rollDiceShouldIncreasePositionByDiceValue() throws Exception {
        cut.setPosition(4);
        cut.rollDice();
        final int diceValue = cut.getDiceValue();
        final int endPosition = cut.getPosition();

        assertThat(endPosition, is(4 + diceValue));

    }
}