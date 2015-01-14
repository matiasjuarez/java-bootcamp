package point3Hospital.Model;

import java.util.ArrayList;

public class Shelving {
	private ArrayList<Shelf> shelves;
	private int nextShelfNumber = 1;

	public ArrayList<Shelf> getShelves() {
		return shelves;
	}

	public Shelving() {
		shelves = new ArrayList<Shelf>();
	}

	public void addShelf(Shelf shelf) {
		shelves.add(shelf);
		setNextShelfNumber(getNextShelfNumber() + 1);
	}

	public String toString() {
		String str = "Description of the shelving: \n";
		int shelvesNumber = shelves.size();
		for (int i = 0; i < shelvesNumber; i++) {
			str += "Shelf number " + (i + 1) + " contains: \n";
			str += shelves.get(i).toString() + "\n";
		}
		return str;
	}

	public int getNextShelfNumber() {
		return nextShelfNumber;
	}

	public void setNextShelfNumber(int nextShelfNumber) {
		this.nextShelfNumber = nextShelfNumber;
	}
}
