package fizzbuzz;

import static org.junit.Assert.assertThat;

import org.hamcrest.core.IsEqual;
import org.junit.Test;

public class GameTest {

	@Test
	public void shouldAnswer7on7() {
		assertThat(Game.anwser(7), IsEqual.equalTo("7"));
	}
	
	@Test
	public void shouldAnswerFizzOn3() {
		assertThat(Game.anwser(3), IsEqual.equalTo("fizz"));
	}
	
	@Test
	public void shouldAnswerFizzOn6() {
		assertThat(Game.anwser(6), IsEqual.equalTo("fizz"));
	}
	
	@Test
	public void shouldAnswerBuzzOn5() {
		assertThat(Game.anwser(5), IsEqual.equalTo("buzz"));
	}
	
	@Test
	public void shouldAnswerBuzzOn10() {
		assertThat(Game.anwser(10), IsEqual.equalTo("buzz"));
	}
	
	@Test
	public void shouldAnswerFizzBuzzOn15() {
		assertThat(Game.anwser(15), IsEqual.equalTo("fizzbuzz"));
	}

}
