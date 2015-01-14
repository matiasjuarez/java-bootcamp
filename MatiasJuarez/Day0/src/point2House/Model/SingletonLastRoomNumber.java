package point2House.Model;

public class SingletonLastRoomNumber {
	private static SingletonLastRoomNumber last = null;

	private int lastNumber;

	private SingletonLastRoomNumber() {
		setLastNumber(1);
	}

	public static SingletonLastRoomNumber getInstance() {
		if (last == null)
			last = new SingletonLastRoomNumber();
		return last;
	}

	public int getLastNumber() {
		return lastNumber;
	}

	public void setLastNumber(int lastNumber) {
		this.lastNumber = lastNumber;
	}

}
