package point3Hospital.ShelvingBuilder;

import point3Hospital.Model.Shelf;
import point3Hospital.Model.Shelving;

//This class creates a shelving that holds the same kind of medicine in a particular shelf
public class RegularShelvingBuilder extends ShelvingBuilder {

	@Override
	public void buildShelving() {
		setShelving(new Shelving());

	}

	@Override
	public void buildShelf() {
		// We create a shelf and we give it a maximum amount of medicines it can
		// hold. After that we add this shelf to the shelving we are creating
		Shelf shelf = new Shelf();
		shelf.setNumber(getShelving().getNextShelfNumber());
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

		// Let's decide what kind of medicine will be created on each shelf
		if (shelf.getNumber() % 2 == 0)
			medicineType = "Liquid";
		else if (shelf.getNumber() % 3 == 0)
			medicineType = "Pill";
		else
			medicineType = "Ointment";

		// let's the Factory pattern do it's magic
		for (int i = 0; i <= shelf.getCapacity(); i++) {
			shelf.addMedicine(medicineFactory.getMedicine(medicineType));
		}

	}

}
