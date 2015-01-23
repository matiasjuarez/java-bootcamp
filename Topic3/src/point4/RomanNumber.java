package point4;

public class RomanNumber {
	private char symbol;
	private int value;
	private boolean canSubtract;

	public RomanNumber(char simbol, int value, boolean canSubtract) {

		this.symbol = simbol;
		this.value = value;
		this.canSubtract = canSubtract;
		
	}

	public char getSymbol() {
		return symbol;
	}

	public int getValue() {
		return value;
	}

	public boolean isAbleToSubtract() {
		return canSubtract;
	}


}
