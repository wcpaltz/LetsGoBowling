import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BowlingTest {
	// COMMENT TEST
	Bowling b;
	int gameScore = 0;

	@Before
	public void beforeTest() {
		b = new Bowling();
		gameScore = 0;
	}

	@Test
	public void testOneThrow() {
		b.addThrow(7, 2);
		assertEquals(b.getScore() - 2, 7);
	}

	@Test
	public void testSecondThrow() {
		b.addThrow(7, 2);
		assertEquals(b.getScore(), 9);
		assertEquals(b.getScore(), gameScore + 9);
	}

	@Test
	public void testThreeThrow() {
		b.addThrow(7, 2);
		b.addThrow(8, 1);
		assertEquals(b.getScore() - 1, 17);
		assertEquals(b.getScore() - 1, gameScore + 17);
		assertEquals(b.getFrameScore(1), 9);
		assertEquals(b.getFrameScore(2) - 1, 8);
	}

	@Test
	public void testSpareCountsNextFrameScore() {
		b.addThrow(7, 3);
		b.addThrow(5, 3);
		assertEquals(b.getFrameScore(1), 18);
	}

	@Test
	public void testStrikeMovesToNextFrame() {
		b.addThrow(10, 0);
		b.addThrow(4, 3);
		b.addThrow(2, 1);
		assertEquals(b.getFrameScore(2), 7);
	}

	@Test
	public void testStrikeCountsNextFrameScore() {
		b.addThrow(10, 0);
		b.addThrow(4, 3);
		b.addThrow(2, 1);
		assertEquals(b.getFrameScore(1), 20);
	}

	@Test
	public void testSpareOnLastFrame() {
		b.addThrow(2, 1);
		b.addThrow(2, 1);
		b.addThrow(2, 1);
		b.addThrow(2, 1);
		b.addThrow(2, 1);
		b.addThrow(2, 1);
		b.addThrow(2, 1);
		b.addThrow(2, 1);
		b.addThrow(2, 1);
		b.addThrow(8, 2);
		assertEquals(b.getScore(), 37);
	}

	@Test
	public void testStrikeOnLastFrame() {
		b.addThrow(2, 1);
		b.addThrow(2, 1);
		b.addThrow(2, 1);
		b.addThrow(2, 1);
		b.addThrow(2, 1);
		b.addThrow(2, 1);
		b.addThrow(2, 1);
		b.addThrow(10, 0);
		b.addThrow(10, 0);
		b.addThrow(10, 0);
		assertEquals(b.getScore(), 81);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testThrowOn11thFrame() {
		b.addThrow(2, 1);
		b.addThrow(2, 1);
		b.addThrow(2, 1);
		b.addThrow(2, 1);
		b.addThrow(2, 1);
		b.addThrow(2, 1);
		b.addThrow(2, 1);
		b.addThrow(10, 0);
		b.addThrow(10, 0);
		b.addThrow(10, 0);
		b.addThrow(7, 2); // Should throw exception
	}

}
