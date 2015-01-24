package point5;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class _Test {
	AmericanSoundexGenerator generator;

	@Test
	public void transformConsonantsIntoNumbers() {
		generator = new AmericanSoundexGenerator();

		String string = "Toshiba";

		String numberedString = generator
				.transformConsonantsIntoNumbers(string);

		assertTrue("3o2hi1a".equalsIgnoreCase(numberedString));
	}

	@Test
	public void findLettersWandH() {
		generator = new AmericanSoundexGenerator();

		String string = "horseWhat";

		ArrayList<Integer> indexesFounded = generator.findLettersWandH(string);

		assertEquals(0, indexesFounded.get(0).intValue());
		assertEquals(5, indexesFounded.get(1).intValue());
		assertEquals(6, indexesFounded.get(2).intValue());
	}

	@Test
	public void joinConsonantsBesideHandW() {
		generator = new AmericanSoundexGenerator();

		String string = "adht";

		String numberedString = generator
				.transformConsonantsIntoNumbers(string);

		String numberedStringJoined = generator
				.joinConsonantsBesideHandW(numberedString);

		assertTrue("a3".equalsIgnoreCase(numberedStringJoined));

		string = "adhbaawdchs";
		numberedString = generator.transformConsonantsIntoNumbers(string);
		numberedStringJoined = generator
				.joinConsonantsBesideHandW(numberedString);

		assertTrue("a31aa32".equalsIgnoreCase(numberedStringJoined));
	}

	// Something is wrong with this test. Eclipse doesn't care about the break
	// points inside this test
	@Test
	public void joinConsonantsWithSameRepresantingNumber() {
		generator = new AmericanSoundexGenerator();

		String string = "bvf";

		String numberedString = generator
				.transformConsonantsIntoNumbers(string);
		String numberedStringJoined = generator
				.joinConsonantsWithSameRepresentingNumber(numberedString);

		assertTrue("b".equals(numberedStringJoined));

		string = "bvfafsetd";

		numberedString = generator.transformConsonantsIntoNumbers(string);
		numberedStringJoined = generator
				.joinConsonantsWithSameRepresentingNumber(numberedString);

		assertTrue("b123".equals(numberedStringJoined));

		string = "bhvfafsehtd";

		numberedString = generator.transformConsonantsIntoNumbers(string);
		numberedStringJoined = generator
				.joinConsonantsBesideHandW(numberedString);
		numberedStringJoined = generator
				.joinConsonantsWithSameRepresentingNumber(numberedStringJoined);

		assertTrue("b123".equals(numberedStringJoined));
	}

	@Test
	public void buildStringFourInLength() {
		generator = new AmericanSoundexGenerator();

		String string = "Rubin";

		String numberedString = generator
				.transformConsonantsIntoNumbers(string);
		String numberedStringJoined = generator
				.joinConsonantsBesideHandW(numberedString);
		numberedStringJoined = generator
				.joinConsonantsWithSameRepresentingNumber(numberedStringJoined);
		String fixedString = generator.fixStringLength(numberedStringJoined);

		assertEquals(4, fixedString.length());

		assertTrue("R150".equals(fixedString));

		string = "Ashcroft";

		numberedString = generator.transformConsonantsIntoNumbers(string);
		numberedStringJoined = generator
				.joinConsonantsBesideHandW(numberedString);
		numberedStringJoined = generator
				.joinConsonantsWithSameRepresentingNumber(numberedStringJoined);
		fixedString = generator.fixStringLength(numberedStringJoined);

		assertTrue("A261".equals(fixedString));

	}

	@Test
	public void runAllTheStepsTogether() {
		generator = new AmericanSoundexGenerator();

		String string = "Rubinas";

		String encodedString = generator.encodeString(string);

		assertTrue("R152".equals(encodedString));

		string = "Tymczak";

		encodedString = generator.encodeString(string);

		assertTrue("T522".equals(encodedString));

		string = "Pfister";

		encodedString = generator.encodeString(string);

		assertTrue("P236".equals(encodedString));
		
		string = "what";

		encodedString = generator.encodeString(string);

		assertTrue("W300".equals(encodedString));
	}

}
