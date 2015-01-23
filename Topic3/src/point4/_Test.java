package point4;

import static org.junit.Assert.*;

import org.junit.Test;

public class _Test {
	RomanArabicConverter converter;

	@Test
	public void convertToRoman() {
		converter = new RomanArabicConverter();

		String roman = converter.convertToRoman(2);

		assertTrue(roman.equals("II"));

		roman = converter.convertToRoman(35);

		assertTrue(roman.equals("XXXV"));

		roman = converter.convertToRoman(439);

		assertTrue(roman.equals("CDXXXIX"));

		roman = converter.convertToRoman(3917);

		assertTrue(roman.equals("MMMCMXVII"));
	}

	@Test
	public void valiteConsecutiveSymbols() {
		converter = new RomanArabicConverter();

		String romanNumber;

		romanNumber = "XXXX";
		assertFalse(converter.validateConsecutiveSymbols(romanNumber
				.toCharArray()));

		romanNumber = "XXXII";
		assertTrue(converter.validateConsecutiveSymbols(romanNumber
				.toCharArray()));
	}

	@Test
	public void convertToInt() {
		converter = new RomanArabicConverter();

		String romanNumber = "XXXII";

		int value = converter.convertToInt(romanNumber);

		assertEquals(32, value);

		romanNumber = "MMMCMXCIX";

		value = converter.convertToInt(romanNumber);

		assertEquals(3999, value);
	}

	@Test
	public void validateSubtraction() {
		converter = new RomanArabicConverter();

		char firstNumber = 'X';
		char secondNumber = 'L';

		assertTrue(converter.isValidSubtraction(firstNumber, secondNumber));

		firstNumber = 'I';
		secondNumber = 'C';

		assertFalse(converter.isValidSubtraction(firstNumber, secondNumber));

		firstNumber = 'M';
		secondNumber = 'X';

		assertFalse(converter.isValidSubtraction(firstNumber, secondNumber));
	}

	@Test
	public void obtainWeight() {
		converter = new RomanArabicConverter();

		int weight = converter.getWeight(10);

		assertEquals(1, weight);

		weight = converter.getWeight(198);

		assertEquals(2, weight);
	}

	@Test
	public void verifyDecreasingWeight() {
		converter = new RomanArabicConverter();

		String romanNumber = "MMIV";

		assertTrue(converter.verifyDescreasingWeight(romanNumber));

		romanNumber = "MMIVC";

		assertFalse(converter.verifyDescreasingWeight(romanNumber));
	}

	@Test
	public void validateRomanFormat() {
		converter = new RomanArabicConverter();

		String romanNumber = "";

		romanNumber = "XIV";
		assertTrue(converter.validateRomanFormat(romanNumber));

		romanNumber = "IXI";
		assertFalse(converter.validateRomanFormat(romanNumber));

		romanNumber = "XXXM";
		assertFalse(converter.validateRomanFormat(romanNumber));

		romanNumber = "IXC";
		assertFalse(converter.validateRomanFormat(romanNumber));

		romanNumber = "LXIXX";
		assertFalse(converter.validateRomanFormat(romanNumber));

		romanNumber = "MMMCMXCIX";

		assertTrue(converter.validateRomanFormat(romanNumber));
	}
}