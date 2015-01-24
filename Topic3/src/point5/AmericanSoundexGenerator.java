package point5;

import java.util.ArrayList;

public class AmericanSoundexGenerator {

	private ArrayList<AmericanSoundexSymbol> americanSoundexSymbols = new ArrayList<AmericanSoundexSymbol>();
	private char firstLetter = ' ';

	public AmericanSoundexGenerator() {
		fillAmericanSoundexSymbols();
	}

	// This method returns a string in which all the consonants have been
	// replaced by a number that represents that consonant
	// Should be private
	public String transformConsonantsIntoNumbers(String string) {

		// Before we start working, we save the first letter of the word in a
		// variable
		firstLetter = string.charAt(0);

		String replacedConsonants = "";

		// We turn the word to lower case
		String loweredCaseString = string.toLowerCase();

		char[] characters = loweredCaseString.toCharArray();

		for (Character character : characters) {

			// This variable will be used to know if we could map the character
			// with an American soundex symbol
			boolean matchFound = false;

			for (AmericanSoundexSymbol symbol : americanSoundexSymbols) {
				if (character == symbol.getCharacter()) {

					matchFound = true;
					replacedConsonants += symbol.getRepresentingNumber();
					break;
				}
			}

			// If no match was possible, the the letter was a vowel, h or w and
			// we add it to the string we will return
			if (!matchFound)
				replacedConsonants += character;
		}

		return replacedConsonants;
	}

	// This fills our array with what I call American soundex symbol. This
	// symbol is made up of a character and a number that represents that
	// character
	private void fillAmericanSoundexSymbols() {
		americanSoundexSymbols.add(new AmericanSoundexSymbol('b', 1));
		americanSoundexSymbols.add(new AmericanSoundexSymbol('f', 1));
		americanSoundexSymbols.add(new AmericanSoundexSymbol('p', 1));
		americanSoundexSymbols.add(new AmericanSoundexSymbol('v', 1));

		americanSoundexSymbols.add(new AmericanSoundexSymbol('c', 2));
		americanSoundexSymbols.add(new AmericanSoundexSymbol('g', 2));
		americanSoundexSymbols.add(new AmericanSoundexSymbol('j', 2));
		americanSoundexSymbols.add(new AmericanSoundexSymbol('k', 2));
		americanSoundexSymbols.add(new AmericanSoundexSymbol('q', 2));
		americanSoundexSymbols.add(new AmericanSoundexSymbol('s', 2));
		americanSoundexSymbols.add(new AmericanSoundexSymbol('x', 2));
		americanSoundexSymbols.add(new AmericanSoundexSymbol('z', 2));

		americanSoundexSymbols.add(new AmericanSoundexSymbol('d', 3));
		americanSoundexSymbols.add(new AmericanSoundexSymbol('t', 3));

		americanSoundexSymbols.add(new AmericanSoundexSymbol('l', 4));

		americanSoundexSymbols.add(new AmericanSoundexSymbol('m', 5));
		americanSoundexSymbols.add(new AmericanSoundexSymbol('n', 5));

		americanSoundexSymbols.add(new AmericanSoundexSymbol('r', 6));
	}

	// This method finds all the indexes where and H or a W is founded
	// Should be a private method
	public ArrayList<Integer> findLettersWandH(String string) {

		ArrayList<Integer> indexes = new ArrayList<Integer>();

		String loweredCaseString = string.toLowerCase();

		for (int index = 0; index < loweredCaseString.length(); index++) {
			if (loweredCaseString.charAt(index) == 'h'
					|| loweredCaseString.charAt(index) == 'w') {
				indexes.add(index);
			}
		}
		return indexes;
	}

	// This method works with the consonants surrounding H and W and join them
	// in one single number if they share the same representing number in the
	// American soundex convention. It also eliminates the Hs and Ws

	// This method should be private
	public String joinConsonantsBesideHandW(String string) {

		ArrayList<Integer> indexesToWorkWith = findLettersWandH(string);

		StringBuilder joinedString = new StringBuilder(string);

		String leftSymbol = "";
		String rightSymbol = "";

		// Due to the fact that after each iteration of the for cycle we'll
		// remove a
		// letter(h or w) we have to take into account that the length of the
		// StringBuilder we'll be changing so we control those changes by means
		// of this variable
		int deletedSymbols = 0;

		for (Integer index : indexesToWorkWith) {
			// the index represent the place in the word where you can find a H
			// or a W. So, index-1 represents the letter at the left of that H
			// or W
			if (index - 1 >= 0)
				leftSymbol = string.substring(index - 1, index);
			if (index + 1 < string.length())
				rightSymbol = string.substring(index + 1, index + 2);

			// We verify if both symbols in the Strings are a number between 1
			// and 6
			if (isRepresentingNumber(leftSymbol)
					&& isRepresentingNumber(rightSymbol)) {

				// If both symbols are the same, we join them into one single
				// symbol and we eliminate the H or W that was between them
				if (leftSymbol.equals(rightSymbol)) {
					joinedString.replace(index - 1 - deletedSymbols, index + 2
							- deletedSymbols, leftSymbol);
					deletedSymbols += 2;
				}
				// If the symbols are NOT the same
				// we take away the H or W between them
				else {
					joinedString.replace(index - deletedSymbols, index + 1
							- deletedSymbols, "");
					deletedSymbols++;
				}
			}
			// If the symbols are NOT a number between 1
			// and 6, we take away the H or W between them
			else {
				joinedString.replace(index - deletedSymbols, index + 1
						- deletedSymbols, "");
				deletedSymbols++;
			}

			leftSymbol = rightSymbol = "";
		}

		return joinedString.toString();

	}

	private boolean isRepresentingNumber(String string) {

		if (string.equals("1"))
			return true;
		if (string.equals("2"))
			return true;
		if (string.equals("3"))
			return true;
		if (string.equals("4"))
			return true;
		if (string.equals("5"))
			return true;
		if (string.equals("6"))
			return true;

		return false;
	}

	// We look for adjacent consonants with the same representing number and we
	// join them into one single number

	// THis should be private
	public String joinConsonantsWithSameRepresentingNumber(String string) {

		String[] groupsToWorkWith = transformVowelsInSeparator(string);

		String consonantsJoined = "";

		// These variables represent a character and the next character
		// respectively
		char aSymbol = ' ';
		char nextSymbol = ' ';

		// This variable becomes true when we have a round of the same number.
		// E.g: if have aSymbol = 1 and nextSymbol = 1, the variable becomes
		// true
		boolean stillSameRound = false;

		for (String consonantString : groupsToWorkWith) {
			for (Character character : consonantString.toCharArray()) {
				if (aSymbol == ' ')
					aSymbol = character;
				else
					nextSymbol = character;

				// If both variable has a character to be compared, then we do
				// it
				if (aSymbol != ' ' && nextSymbol != ' ') {
					// here is were we decide if we have to join the numbers or
					// not
					if (aSymbol == nextSymbol) {
						// If stillSameRound is true, this means we already have
						// added say a 1... if the next number is also a
						// 1 then we shouldn't add that 1 to the returned string
						if (!stillSameRound)
							consonantsJoined += aSymbol;
						nextSymbol = ' ';
						stillSameRound = true;
					}

					else {
						// If stillSameRound is true, it would mean that aSymbol
						// is a number of a round we were working with. In other
						// words, if stillSameRound is true, and we have
						// aSymbol = 1, that means that we where working with at
						// least one 1 before, and we should join them into a
						// single number.
						// E.g Try it with 112
						if (!stillSameRound) {
							consonantsJoined += aSymbol;
							aSymbol = nextSymbol;
							nextSymbol = ' ';
						} else {

							aSymbol = nextSymbol;
							nextSymbol = ' ';
							stillSameRound = false;
						}
					}
				}
			}

			// After we finished with a particular group of consonants, we put
			// this variable to false because both groups were separated by a
			// vowel in the original string
			if (stillSameRound) {
				stillSameRound = false;
				aSymbol = ' ';
			}
		}
		if (aSymbol != ' ')
			consonantsJoined += aSymbol;
		return addFirstLetterAgain(consonantsJoined, firstLetter);
	}

	// After working with the word, we call this method and it changes the first
	// number in the string we obtained by the first letter we stored in the
	// variable firstLetter
	private String addFirstLetterAgain(String string, char firstLetter) {
		StringBuilder stringBuilder = new StringBuilder(string);
		stringBuilder.replace(0, 1, Character.toString(firstLetter));
		return stringBuilder.toString();
	}

	// This method return an array of Strings where each string is a group of
	// consonants representing numbers of consonants
	private String[] transformVowelsInSeparator(String string) {

		boolean vowelFound = false;

		char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'y' };

		StringBuilder stringWithSeparators = new StringBuilder(string);

		for (int i = 1; i < string.length(); i++) {
			for (Character character : vowels) {
				if (character == string.charAt(i)) {
					stringWithSeparators.replace(i, i + 1, ".");
					vowelFound = true;
					break;
				}

			}
		}

		String[] groupsOfConsonants;
		if (vowelFound) {
			groupsOfConsonants = stringWithSeparators.toString().split("\\.");

			return groupsOfConsonants;
		}

		else {
			String[] noVowelsFound = { string };
			return noVowelsFound;
		}
	}

	// This method cuts the string or add zeros at the end if it's necessary

	// Should be private
	public String fixStringLength(String numberedStringJoined) {

		String fixedString = numberedStringJoined;

		int zerosToAdd = 4 - numberedStringJoined.length();

		if (zerosToAdd > 0)
			for (int i = 0; i < zerosToAdd; i++) {
				fixedString += "0";
			}
		else
			fixedString = fixedString.substring(0, 4);
		return fixedString.toUpperCase();
	}

	// This is the only method that will be public. It runs all the steps to get
	// the encoded string. The order of the steps is the one represented by this
	// method. If you do these steps in a different order, you can be sure the
	// program will fail
	public String encodeString(String string) {
		String encodedString = transformConsonantsIntoNumbers(string);
		encodedString = joinConsonantsBesideHandW(encodedString);
		encodedString = joinConsonantsWithSameRepresentingNumber(encodedString);
		encodedString = fixStringLength(encodedString);

		return encodedString;
	}
}
