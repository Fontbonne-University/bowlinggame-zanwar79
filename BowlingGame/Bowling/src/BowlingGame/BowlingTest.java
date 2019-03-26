package BowlingGame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BowlingTest {

	private Game g;

	@Before
	public void setUp() throws Exception {
		g = new Game();
	}

	private void rollSpare() {
		g.roll(5);
		g.roll(5);  //spare
	}

	
	private void rollMany(int n, int pins) {
		for(int i=0; i< n; i++)
			g.roll(pins);
	}

	@Test
	public void canRoll()
	{
		Game g= new Game();
		g.roll(0);
	}
	
	@Test
	public void GutterGame()
	{
		rollMany(20, 0);
		assertEquals(0, g.score());
	}

	
	@Test
	public void allOnes()
	{
		rollMany(20, 1);
		assertEquals(20, g.score());
	}
	
	@Test
	public void oneSpare()
	{
		rollSpare();
		g.roll(3);
		rollMany(17,0);
		assertEquals(16,g.score());
	}

	@Test
	public void oneStrike()
	{
		g.roll(10);
		g.roll(3);
		g.roll(4);
		rollMany(16, 0);
	}
}
