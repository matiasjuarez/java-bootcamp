package point5;

public class AmericanSoundexSymbol {
	private char character;
	private int representingNumber;

	public AmericanSoundexSymbol(char character, int representingNumber) {
		this.character = character;
		this.representingNumber = representingNumber;
	}

	public char getCharacter() {
		return character;
	}

	public int getRepresentingNumber() {
		return representingNumber;
	}
}
