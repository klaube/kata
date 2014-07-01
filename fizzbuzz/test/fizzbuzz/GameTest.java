package fizzbuzz;

import static org.junit.Assert.assertThat;

import org.hamcrest.core.IsEqual;
import org.junit.Test;

public class GameTest {

	@Test
	public void shouldAnswer7on7() {
		assertThat(Game.calculateAnwser(7), IsEqual.equalTo("7"));
	}
	
	@Test
	public void shouldAnswerFizzOn3() {
		assertThat(Game.calculateAnwser(3), IsEqual.equalTo("fizz"));
	}
	
	@Test
	public void shouldAnswerFizzOn6() {
		assertThat(Game.calculateAnwser(6), IsEqual.equalTo("fizz"));
	}
	
	@Test
	public void shouldAnswerBuzzOn5() {
		assertThat(Game.calculateAnwser(5), IsEqual.equalTo("buzz"));
	}
	
	@Test
	public void shouldAnswerBuzzOn10() {
		assertThat(Game.calculateAnwser(10), IsEqual.equalTo("buzz"));
	}
	
	@Test
	public void shouldAnswerFizzBuzzOn45() {
		assertThat(Game.calculateAnwser(45), IsEqual.equalTo("fizzbuzz"));
	}
	
	@Test
	public void shouldAnswer46On46() {
		assertThat(Game.calculateAnwser(46), IsEqual.equalTo("46"));
	}
	
	@Test
	public void shouldAnswer37On47() {
		assertThat(Game.calculateAnwser(47), IsEqual.equalTo("47"));
	}
	
	@Test
	public void shouldAnswerFizzOn48() {
		assertThat(Game.calculateAnwser(48), IsEqual.equalTo("fizz"));
	}
	
	@Test
	public void shouldAnswerBuzzOn50() {
		assertThat(Game.calculateAnwser(50), IsEqual.equalTo("buzz"));
	}

}
