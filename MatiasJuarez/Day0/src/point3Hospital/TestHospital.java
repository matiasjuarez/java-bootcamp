package point3Hospital;

import point3Hospital.AbstractFactory.AbstractFactory;
import point3Hospital.AbstractFactory.ItemFactory;
import point3Hospital.Model.Item;
import point3Hospital.Model.Shelving;
import point3Hospital.ShelvingBuilder.DirectorShelvingBuilding;
import point3Hospital.ShelvingBuilder.MixedShelvingBuilder;
import point3Hospital.ShelvingBuilder.RegularShelvingBuilder;

public class TestHospital {
	public static void main(String[] args) {
		// Here we test a builder pattern that uses a factory patter

		Shelving shelving1; // Let's build a shelving

		// we can choose any of these two builders

		// this one puts the same kind of medicine in each shelf
		// RegularShelvingBuilder rsb = new RegularShelvingBuilder();

		// this one can mix different kind of medicine in each shelf
		MixedShelvingBuilder msb = new MixedShelvingBuilder();

		// this is the director that will build the shelving
		DirectorShelvingBuilding dsb = new DirectorShelvingBuilding(msb);
		dsb.buildShelving();

		shelving1 = dsb.getShelving();

		System.out.println(shelving1);

		System.out
				.println("\n\n\n\n Let's test the abstract factory pattern now...");
		// here starts the test of the abstract factory pattern
		AbstractFactory abstractFactory = new AbstractFactory();

		// You can use a parameter with value 1 = CleaningItemFactory, 2 =
		// OfficeItemFactory or 3 = SurgicalItemFactory
		ItemFactory itemFactory = abstractFactory.getItemFactory(3);
		// The different factories only receive a parameter = 1 or 2. Other
		// numbers return null
		Item item1 = itemFactory.getItem(1);
		Item item2 = itemFactory.getItem(2);

		ItemFactory itemFactory2 = abstractFactory.getItemFactory(1);

		Item item3 = itemFactory2.getItem(1);
		Item item4 = itemFactory2.getItem(2);

		System.out.println(item1);
		System.out.println(item2);
		System.out.println(item3);
		System.out.println(item4);
	}

}
