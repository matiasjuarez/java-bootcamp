package point2;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class _Test {
	StringWrapper sw;

	@Test
	public void calculateHowManyWrappers() {

		String string = "I don't feel like programming right now";

		sw = new StringWrapper(string, 4);

		int amountOfWrappers = sw.calculateWrappers();

		assertEquals(10, amountOfWrappers);
	}

	@Test
	public void findNextCutPoint() {

		String string = "I don't feel like programming right now";

		sw = new StringWrapper(string, 3);

		int lastCutPoint = sw.getNextCutPoint();

		assertEquals(3, lastCutPoint);

		sw = new StringWrapper("hello", 7);

		lastCutPoint = sw.getNextCutPoint();

		assertEquals(5, lastCutPoint);
	}

	@Test
	public void buildNextWrapper() {

		String string = "I don't feel like programming right now";

		sw = new StringWrapper(string, 3);

		String wrap = sw.wrapNextWord();

		assertTrue("I d".equals(wrap));
	}

	@Test
	public void createWrappers() {

		String string = "I don't feel like programming right now";

		sw = new StringWrapper(string, 5);

		String[] arrayOfWrappers = sw.createWrapperArray();

		assertEquals(8, arrayOfWrappers.length);

		string = "give me money";

		sw = new StringWrapper(string, 3);

		String listOfWrappers = sw.getListOfWrappers();

		assertTrue("\"giv\",\"e m\",\"e m\",\"one\",\"y\"".equals(listOfWrappers));
	}
}
