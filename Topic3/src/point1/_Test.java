package point1;

import static org.junit.Assert.*;

import org.junit.Test;

public class _Test {
	NumberStringBuilder nsb;

	@Test
	public void getCents() {
		nsb = new NumberStringBuilder();

		String cents = nsb.getCents("20.34");

		assertTrue(cents.equalsIgnoreCase("34"));

		cents = nsb.getCents("1.00");

		assertTrue(cents.equalsIgnoreCase("00"));

		cents = nsb.getCents("23");

		assertTrue(cents.equalsIgnoreCase("00"));

	}

	@Test
	public void getEntireDollars() {
		nsb = new NumberStringBuilder();

		String entireDollar = nsb.getEntireDollars("24.31");

		assertTrue(entireDollar.equalsIgnoreCase("24"));
	}

	@Test
	public void getEntireDollarsOnes() {
		nsb = new NumberStringBuilder();

		int dollarOnes = nsb.getOnes("4123", 0);

		assertEquals(3, dollarOnes);

		dollarOnes = nsb.getOnes("4123", 1);

		assertEquals(4, dollarOnes);

		dollarOnes = nsb.getOnes("342", 1);

		assertEquals(0, dollarOnes);
	}

	@Test
	public void getEntireDollarsTens() {
		nsb = new NumberStringBuilder();

		int dollarTens = nsb.getTens("52319", 0);

		assertEquals(1, dollarTens);

		dollarTens = nsb.getTens("52319", 1);

		assertEquals(5, dollarTens);

		dollarTens = nsb.getTens("4", 0);

		assertEquals(0, dollarTens);
	}

	@Test
	public void getEntireDollarsHundreds() {
		nsb = new NumberStringBuilder();

		int dollarHundreds = nsb.getHundreds("3415", 0);

		assertEquals(4, dollarHundreds);

		dollarHundreds = nsb.getHundreds("3415", 1);

		assertEquals(0, dollarHundreds);
	}

	@Test
	public void onesToText() {
		nsb = new NumberStringBuilder();

		String text = nsb.onesToText("3415", 0);

		assertTrue("five".equalsIgnoreCase(text));

		text = nsb.onesToText("3415", 1);

		assertTrue("three thousand".equalsIgnoreCase(text));

		text = nsb.onesToText("4321432", 2);

		assertTrue("four million".equalsIgnoreCase(text));
	}

	@Test
	public void tensAndOnesToText() {
		nsb = new NumberStringBuilder();

		String text = nsb.tensAndOnesToText("3415", 0);

		assertTrue("fifteen".equalsIgnoreCase(text));

		text = nsb.tensAndOnesToText("45123", 0);

		assertTrue("twenty-three".equalsIgnoreCase(text));

		text = nsb.tensAndOnesToText("45123", 1);

		assertTrue("forty-five thousand".equalsIgnoreCase(text));
	}

	@Test
	public void hundredsAndTensAndOnesToText() {
		nsb = new NumberStringBuilder();

		String text = nsb.hundredsAndTensAndOnesToText("3415", 0);

		assertTrue("four hundred and fifteen".equalsIgnoreCase(text));

		text = nsb.hundredsAndTensAndOnesToText("921512", 1);

		assertTrue("nine hundred and twenty-one thousand"
				.equalsIgnoreCase(text));
	}

	@Test
	public void translateNumberToText() {
		nsb = new NumberStringBuilder();

		String text = nsb.translateNumberToText("51230");

		assertTrue("fifty-one thousand two hundred and thirty and 00/100 dollars"
				.equalsIgnoreCase(text));
		
		text = nsb.translateNumberToText("948001023019");
		
		assertTrue("nine hundred and forty-eight billion one million twenty-three thousand nineteen and 00/100 dollars".equals(text));
		
		text = nsb.translateNumberToText("948001023019.34");
		
		assertTrue("nine hundred and forty-eight billion one million twenty-three thousand nineteen and 34/100 dollars".equals(text));
	}
}
