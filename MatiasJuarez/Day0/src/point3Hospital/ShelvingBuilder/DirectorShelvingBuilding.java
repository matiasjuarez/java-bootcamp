package point3Hospital.ShelvingBuilder;

import point3Hospital.Model.Shelf;
import point3Hospital.Model.Shelving;

public class DirectorShelvingBuilding {
	private ShelvingBuilder shelvingBuilder = null;

	public DirectorShelvingBuilding(ShelvingBuilder shelvingBuilder) {
		this.shelvingBuilder = shelvingBuilder;
	}

	public void buildShelving() {
		shelvingBuilder.buildShelving();
		// We decided that this director will built a shelving with just 3
		// shelves
		for (int i = 0; i < 3; i++) {
			shelvingBuilder.buildShelf();

		}

		// We add the medicine to the shelves of the shelving
		for (Shelf shelf : getShelving().getShelves()) { // we obtain the
															// shelves of the
															// shelving

			shelvingBuilder.addMedicines(shelf);

			shelf.getMedicines().trimToSize();
		}
	}

	public Shelving getShelving() {
		return shelvingBuilder.getShelving();
	}
}
