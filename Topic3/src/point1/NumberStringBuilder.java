package point1;

public class NumberStringBuilder {

	public String translateNumberToText(String number) {

		String textNumber = "";

		String cents = getCents(number);

		// We get the length of the number we are dealing with
		int entireNumberPartLength = getEntireDollars(number).length();

		// We calculate the amount of trios we have to work with
		int numberOfTrios = entireNumberPartLength / 3;

		if (entireNumberPartLength % 3 != 0)
			numberOfTrios++;

		// We build up the String with the name of the number
		for (int trio = numberOfTrios - 1; trio >= 0; trio--) {
			textNumber += hundredsAndTensAndOnesToText(number, trio);
			textNumber += " ";
		}

		// We add the cents to the name
		textNumber += "and " + cents + "/100 dollars";

		// We remove any white space at the beginning or at the end of the
		// String and we return it
		return textNumber.trim();
	}

	// This method let us get the cents of a value
	public String getCents(String number) {

		// We use double backslashes to escape the special character
		String[] splittedString = number.split("\\.");

		// We verify that the value entered has a decimal part
		if (splittedString.length == 2)
			return splittedString[1];
		return "00";
	}

	// This method let us get the part of a number that is not fractional
	public String getEntireDollars(String number) {

		String[] splittedString = number.split("\\.");

		return splittedString[0];
	}

	// We get the ones of each trio. E.g: 51238 has two trios: 051 and 238
	public int getOnes(String number, int trio) {
		String entireDollars = getEntireDollars(number);

		try {
			String ones = Character.toString(entireDollars.charAt(entireDollars
					.length() - 1 - trio * 3));

			return Integer.parseInt(ones);
		} catch (StringIndexOutOfBoundsException e) {
			return 0;
		}

	}

	public int getTens(String number, int trio) {
		String entireDollars = getEntireDollars(number);

		// When we are out of bounds, that means that we are trying to get a
		// nonexistent ten of a particular trio. That could happen when we deal
		// with the next number: 4325. Because we are working with trios, so we
		// have to think that actually this number is 004325. If a particular
		// trio doesn't have tens or hundreds, these methods will catch an
		// exception
		try {
			String tens = Character.toString(entireDollars.charAt(entireDollars
					.length() - 2 - trio * 3));
			return Integer.parseInt(tens);
		} catch (StringIndexOutOfBoundsException e) {
			return 0;
		}

	}

	public int getHundreds(String number, int trio) {
		String entireDollars = getEntireDollars(number);

		try {
			String hundreds = Character.toString(entireDollars
					.charAt(entireDollars.length() - 3 - trio * 3));
			return Integer.parseInt(hundreds);
		} catch (StringIndexOutOfBoundsException e) {
			return 0;
		}
	}

	public String onesToText(String number, int trio) {
		// The number 0 is never mentioned in a number I guess...
		String textNumber = "";

		int numberToTranslate = getOnes(number, trio);

		switch (numberToTranslate) {

		case 1:
			textNumber += "one";
			break;
		case 2:
			textNumber += "two";
			break;
		case 3:
			textNumber += "three";
			break;
		case 4:
			textNumber += "four";
			break;
		case 5:
			textNumber += "five";
			break;
		case 6:
			textNumber += "six";
			break;
		case 7:
			textNumber += "seven";
			break;
		case 8:
			textNumber += "eight";
			break;
		case 9:
			textNumber += "nine";
			break;
		}

		if (trio != 0)
			textNumber += addTrioName(trio);

		return textNumber;
	}

	// We add thousand, million or billion according to the trio parameter
	public String addTrioName(int trio) {
		String trioName = "";
		if (trio == 1)
			trioName += " thousand";
		else if (trio == 2)
			trioName += " million";
		else if (trio == 3)
			trioName += " billion";
		return trioName;
	}

	public String tensAndOnesToText(String number, int trio) {
		String textNumber = "";

		int tens = getTens(number, trio);
		int ones = getOnes(number, trio);

		int numberToTranslate = ones + tens * 10;

		// First we verify if the number is between 10 and 19. Those numbers
		// have special names
		switch (numberToTranslate) {
		case 10:
			textNumber += "ten";
			break;
		case 11:
			textNumber += "eleven";
			break;
		case 12:
			textNumber += "twelve";
			break;
		case 13:
			textNumber += "thirteen";
			break;
		case 14:
			textNumber += "fourteen";
			break;
		case 15:
			textNumber += "fifteen";
			break;
		case 16:
			textNumber += "sixteen";
			break;
		case 17:
			textNumber += "seventeen";
			break;
		case 18:
			textNumber += "eighteen";
			break;
		case 19:
			textNumber += "nineteen";
			break;
		}

		// After 19, the numbers name follow a pattern
		if (numberToTranslate >= 20) {
			switch (tens) {

			case 2:
				textNumber += "twenty";
				break;
			case 3:
				textNumber += "thirty";
				break;
			case 4:
				textNumber += "forty";
				break;
			case 5:
				textNumber += "fifty";
				break;
			case 6:
				textNumber += "sixty";
				break;
			case 7:
				textNumber += "seventy";
				break;
			case 8:
				textNumber += "eighty";
				break;
			case 9:
				textNumber += "ninety";
				break;
			}

			// if the number after the tens is not a zero, we add a line
			if (ones != 0) {
				textNumber += "-";
			}

			// This call adds the ones and also the trio name
			textNumber += onesToText(number, trio);
		}

		if (textNumber == "")
			textNumber += onesToText(number, trio);

		return textNumber;
	}

	public String hundredsAndTensAndOnesToText(String number, int trio) {
		String textNumber = "";

		int ones = getOnes(number, trio);
		int tens = getTens(number, trio);
		int cents = getHundreds(number, trio);

		switch (cents) {

		case 1:
			textNumber += "one";
			break;
		case 2:
			textNumber += "two";
			break;
		case 3:
			textNumber += "three";
			break;
		case 4:
			textNumber += "four";
			break;
		case 5:
			textNumber += "five";
			break;
		case 6:
			textNumber += "six";
			break;
		case 7:
			textNumber += "seven";
			break;
		case 8:
			textNumber += "eight";
			break;
		case 9:
			textNumber += "nine";
			break;
		}

		if (textNumber != "")
			textNumber += " hundred ";

		if ((tens != 0 || ones != 0) && textNumber != "")
			textNumber += "and ";

		textNumber += tensAndOnesToText(number, trio);

		return textNumber;
	}
}
