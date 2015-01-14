package point3Hospital.ShelvingBuilder;

import point3Hospital.Model.Shelf;
import point3Hospital.Model.Shelving;

public abstract class ShelvingBuilder {
	private Shelving shelving;

	public Shelving getShelving() {
		return shelving;
	}

	public void setShelving(Shelving shelving) {
		this.shelving = shelving;
	}

	public abstract void buildShelving();

	public abstract void buildShelf();

	public abstract void addMedicines(Shelf shelf);
}
