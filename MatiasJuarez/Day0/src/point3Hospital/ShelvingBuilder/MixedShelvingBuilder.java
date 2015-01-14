package point3Hospital.ShelvingBuilder;

import point3Hospital.Model.Shelf;
import point3Hospital.Model.Shelving;

public class MixedShelvingBuilder extends ShelvingBuilder {

	@Override
	public void buildShelving() {
		setShelving(new Shelving());

	}

	@Override
	public void buildShelf() {
		Shelf shelf = new Shelf();
		shelf.setCapacity(5);
		getShelving().addShelf(shelf);

	}

	@Override
	public void addMedicines(Shelf shelf) {
		// In this variable we'll hold the kind of medicine that needs to be
		// created
		String medicineType = "";

		// We use a MedicineFactory to create the different medicines that will
		// be in the different shelves
		MedicineFactory medicineFactory = new MedicineFactory();

		int randomNumber = 0;

		for (int i = 0; i < shelf.getCapacity(); i++) {
			randomNumber = (int) Math.round(Math.random() * 2);

			switch (randomNumber) {
			case 0:
				medicineType = "liquid";
				break;
			case 1:
				medicineType = "pill";
				break;
			case 2:
				medicineType = "ointment";
				break;
			}

			shelf.addMedicine(medicineFactory.getMedicine(medicineType));
		}

	}
}
