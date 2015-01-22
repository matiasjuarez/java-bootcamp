package point2;

import java.util.ArrayList;

public class StringWrapper {

	private int rowLength;
	private int lastCutPoint;
	private String string;
	private String[] arrayOfWrappers;

	public StringWrapper(String string, int rowLength) {
		this.rowLength = rowLength;

		lastCutPoint = 0;

		this.string = string;
		
		arrayOfWrappers = createWrapperArray();
	}

	public ArrayList<String> wrapString(String string, int rowLength) {

		ArrayList<String> stringsList = new ArrayList<String>();

		return stringsList;
	}

	public int calculateWrappers() {
		int stringLength = string.length();
		int wrappers = stringLength / this.rowLength;

		if (stringLength % this.rowLength > 0)
			wrappers++;

		return wrappers;

	}

	public int getNextCutPoint() {
		int newCutPoint = lastCutPoint + rowLength;

		if (newCutPoint > string.length())
			newCutPoint = string.length();

		return newCutPoint;
	}

	public String wrapNextWord() {
		return string.substring(lastCutPoint, getNextCutPoint());
	}

	public String[] createWrapperArray() {
		arrayOfWrappers = new String[calculateWrappers()];

		for (int index = 0; index < arrayOfWrappers.length; index++) {
			arrayOfWrappers[index] = wrapNextWord();
			lastCutPoint = getNextCutPoint();
		}
		
		lastCutPoint = 0;
		return arrayOfWrappers;
	}


	public String getListOfWrappers() {
		String str = "";

		for (String wrapper : arrayOfWrappers) {
			str += "\"" + wrapper + "\",";
		}
		
		return str.substring(0, str.length() - 1);
	}

}
