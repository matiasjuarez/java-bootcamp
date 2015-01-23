package point4;

import java.util.ArrayList;

import org.hamcrest.core.SubstringMatcher;

public class RomanArabicConverter {

	private ArrayList<RomanNumber> validRomanNumbers = new ArrayList<RomanNumber>();

	public RomanArabicConverter() {
		fillValidCharacters();
	}

	// We load an array with the Roman numbers
	private void fillValidCharacters() {
		validRomanNumbers.add(new RomanNumber('M', 1000, false));
		validRomanNumbers.add(new RomanNumber('D', 500, false));
		validRomanNumbers.add(new RomanNumber('C', 100, true));
		validRomanNumbers.add(new RomanNumber('L', 50, false));
		validRomanNumbers.add(new RomanNumber('X', 10, true));
		validRomanNumbers.add(new RomanNumber('V', 5, false));
		validRomanNumbers.add(new RomanNumber('I', 1, true));

	}

	// This transforms an int between 1 and 3999 into Roman notation
	public String convertToRoman(int arabicNumber) {

		String ones = convertOnes(getNumber(arabicNumber, 0));
		String tens = convertTens(getNumber(arabicNumber, 1));
		String hundreds = convertHundreds(getNumber(arabicNumber, 2));
		String thousands = convertThousands(getNumber(arabicNumber, 3));

		if (arabicNumber < 4000)
			return thousands + hundreds + tens + ones;
		return "This conversor works with numbers between 1 and 3999";
	}

	private String convertThousands(int number) {
		switch (number) {
		case 1:
			return "M";
		case 2:
			return "MM";
		case 3:
			return "MMM";
		default:
			return "";
		}
	}

	private String convertHundreds(int number) {
		switch (number) {
		case 1:
			return "C";
		case 2:
			return "CC";
		case 3:
			return "CCC";
		case 4:
			return "CD";
		case 5:
			return "D";
		case 6:
			return "DC";
		case 7:
			return "DCC";
		case 8:
			return "DCCC";
		case 9:
			return "CM";
		default:
			return "";
		}
	}

	// This methos let us obtain the ones, tens, hundreds and thousands of a
	// particular number. The first parameter is the number, and second one
	// represents the weight you want to obtain. E.g: 0 for the ones, 1 for
	// tens, etc
	private int getNumber(int arabicNumber, int position) {
		StringBuilder arabicNumberBuilder = new StringBuilder(
				Integer.toString(arabicNumber));

		// We reverse the number we received. It's just to work in a comfortable
		// way
		String reversedArabicNumber = arabicNumberBuilder.reverse().toString();

		// We try to obtain a digit of the Arabic number at the position we send
		// as parameter. If the position is very high, it will produce an
		// exception. When that happens, we simply return 0 for that position.
		try {
			char lonelyNumber = reversedArabicNumber.charAt(position);

			String numberToReturn = Character.toString(lonelyNumber);

			return Integer.parseInt(numberToReturn);
		} catch (StringIndexOutOfBoundsException e) {
			return 0;
		}

	}

	private String convertTens(int number) {
		switch (number) {
		case 1:
			return "X";
		case 2:
			return "XX";
		case 3:
			return "XXX";
		case 4:
			return "XL";
		case 5:
			return "L";
		case 6:
			return "LX";
		case 7:
			return "LXX";
		case 8:
			return "LXXX";
		case 9:
			return "XC";
		default:
			return "";
		}
	}

	private String convertOnes(int number) {
		switch (number) {
		case 1:
			return "I";
		case 2:
			return "II";
		case 3:
			return "III";
		case 4:
			return "IV";
		case 5:
			return "V";
		case 6:
			return "VI";
		case 7:
			return "VII";
		case 8:
			return "VIII";
		case 9:
			return "IX";
		default:
			return "";
		}
	}

	// This method let us know if the Roman number we are working with has a
	// valid format
	public boolean validateRomanFormat(String romanNumber) {

		char[] characters = romanNumber.toCharArray();

		if (validateCharacters(characters)
				&& verifyDescreasingWeight(romanNumber)
				&& validateConsecutiveSymbols(characters))
			return true;

		return false;
	}

	// Here we validate that each character of romanNumber is a valid
	// character. In other words, we verify if each character inside
	// 'characters' can be mapped with a RomanNumber inside validRomanNumber
	public boolean validateCharacters(char[] characters) {

		boolean validCharacters = true;

		for (Character character : characters) {
			validCharacters = false;
			for (RomanNumber validCharacter : validRomanNumbers) {
				if (character == validCharacter.getSymbol()) {
					validCharacters = true;
					break;
				}
			}

			if (validCharacters == false)
				return false;
		}

		return validCharacters;
	}

	// Here we validate if a subtraction is valid or not. To do that, we have to
	// check if the attribute isAbleToSubtract of firstNumber is true. After
	// that we verify the weight of both.
	public boolean isValidSubtraction(char firstNumber, char secondNumber) {

		RomanNumber firstRomanNumber = null;
		RomanNumber secondRomanNumber = null;

		for (RomanNumber romanNumber : validRomanNumbers) {
			if (firstNumber == romanNumber.getSymbol())
				firstRomanNumber = romanNumber;
			if (secondNumber == romanNumber.getSymbol())
				secondRomanNumber = romanNumber;
		}

		if (firstRomanNumber.isAbleToSubtract()
				&& isValidWeight(firstRomanNumber, secondRomanNumber))
			return true;
		return false;

	}

	public boolean isValidSubstraction(RomanNumber firstRomanNumber,
			RomanNumber secondRomanNumber) {
		if (firstRomanNumber.isAbleToSubtract()
				&& isValidWeight(firstRomanNumber, secondRomanNumber))
			return true;
		return false;
	}

	// We use it to know if we are subtracting ones, or ones with tens, or tens
	// with tents, etc. You can only subtract ones from ones, ones from tens,
	// tens from tens, tens from hundreds, hundreds from hundreds and hundreds
	// from thousands
	public boolean isValidWeight(RomanNumber firstNumber,
			RomanNumber secondNumber) {

		if (getWeight(firstNumber.getValue()) == getWeight(secondNumber
				.getValue())
				|| getWeight(firstNumber.getValue()) == getWeight(secondNumber
						.getValue()) - 1)
			return true;
		return false;
	}

	// This method validates that there are no more that three consecutive
	// symbols
	public boolean validateConsecutiveSymbols(char[] characters) {

		int amountOfConsecutiveSymbols = 1;
		char currentSymbol = ' ';

		for (Character character : characters) {
			if (currentSymbol == character)
				amountOfConsecutiveSymbols++;
			else {
				currentSymbol = character;
				amountOfConsecutiveSymbols = 1;
			}

			if (amountOfConsecutiveSymbols > 3)
				return false;
		}
		return true;
	}

	// Here we calculate how much the Roman number represents
	public int convertToInt(String romanNumber) {

		int accumulated = 0;

		ArrayList<RomanNumber> romanNumbersToBeAdded = convertStringToRomanArray(romanNumber);

		RomanNumber firstNumber = null;
		RomanNumber secondNumber = null;

		if (romanNumbersToBeAdded == null)
			return 0;

		for (RomanNumber romanNumberToAdd : romanNumbersToBeAdded) {
			if (firstNumber == null)
				firstNumber = romanNumberToAdd;
			else {
				secondNumber = romanNumberToAdd;

				// We do this verification to know if firstNumber and
				// secondNumber represent a subtraction
				if (firstNumber.getValue() < secondNumber.getValue()) {
					accumulated += secondNumber.getValue()
							- firstNumber.getValue();

					// They represent a subtraction and that's why we don't need
					// to work with them anymore
					firstNumber = secondNumber = null;
				}

				else {
					accumulated += firstNumber.getValue();
					firstNumber = secondNumber;
					secondNumber = null;
				}

			}
		}

		// We need to do this to add the last number
		if (firstNumber != null)
			accumulated += firstNumber.getValue();

		return accumulated;
	}

	// We transform a string that represents a valid Roman number into an
	// ArrayList of RomanNumbers

	public ArrayList<RomanNumber> convertStringToRomanArray(String romanNumber) {

		ArrayList<RomanNumber> romanNumbers = new ArrayList<RomanNumber>();

		// We transform the string romanNumber into an array of chars
		char[] characters = romanNumber.toCharArray();

		// We map each character with a RomanNumber
		for (Character character : characters) {
			for (RomanNumber validRomanNumber : validRomanNumbers) {
				if (character == validRomanNumber.getSymbol()) {
					romanNumbers.add(validRomanNumber);
					break;
				}
			}
		}

		return romanNumbers;
	}

	public int getWeight(int number) {
		if (number < 10)
			return 0;
		else if (number < 100)
			return 1;
		else if (number < 1000)
			return 2;
		return 3;
	}

	// This is useful to get the weight of a subtraction between two
	// RomanNumbers
	public int getWeight(RomanNumber firstNumber, RomanNumber secondNumber) {
		int difference = secondNumber.getValue() - firstNumber.getValue();

		return getWeight(difference);
	}

	// We verify that all the symbols and the subtraction in a particular number
	// are occurring in a decreasing way
	public boolean verifyDescreasingWeight(String stringRomanNumber) {
		ArrayList<RomanNumber> romanNumbers = convertStringToRomanArray(stringRomanNumber);

		RomanNumber firstNumber = null;
		RomanNumber secondNumber = null;
		int maxWeightAllowed = 3;

		for (RomanNumber romanNumber : romanNumbers) {
			if (firstNumber == null)
				firstNumber = romanNumber;
			else {
				secondNumber = romanNumber;

				if (firstNumber.getValue() < secondNumber.getValue()) {
					if (isValidSubstraction(firstNumber, secondNumber)) {
						if (getWeight(firstNumber, secondNumber) <= maxWeightAllowed) {
							// After the subtraction, we assign a new maxWeight.
							// At the right of a subtraction can't be a number
							// or a subtraction with the same or higher weight
							maxWeightAllowed = getWeight(firstNumber,
									secondNumber) - 1;
							firstNumber = secondNumber = null;
						} else
							return false;
					} else
						return false;
				}

				else {
					if (getWeight(firstNumber.getValue()) <= maxWeightAllowed) {
						maxWeightAllowed = getWeight(firstNumber.getValue());
						firstNumber = secondNumber;
						secondNumber = null;
					}
				}
			}
		}

		if (firstNumber != null
				&& getWeight(firstNumber.getValue()) > maxWeightAllowed) {
			return false;
		}
		return true;
	}
}
