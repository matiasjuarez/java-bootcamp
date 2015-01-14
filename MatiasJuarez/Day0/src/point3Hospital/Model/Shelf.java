package point3Hospital.Model;

import java.util.ArrayList;

public class Shelf {
	private ArrayList<Medicine> medicines;
	private int capacity;
	private int number;

	public ArrayList<Medicine> getMedicines() {
		return medicines;
	}

	public void addMedicine(Medicine medicine) {
		medicines.add(medicine);
	}

	public Shelf() {
		medicines = new ArrayList<Medicine>();
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String toString() {
		String str = "";
		for (int i = 0; i < medicines.size(); i++) {
			str += medicines.get(i).getClass().getSimpleName() + " , ";
		}
		return str.substring(0, str.length() - 3);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
