package point3Hospital.AbstractFactory;

public class AbstractFactory {

	// This will create a particular factory which will return an Item
	public ItemFactory getItemFactory(int factoryNumber) {
		switch (factoryNumber) {
		case 1:
			return new CleaningItemFactory();
		case 2:
			return new OfficeItemFactory();
		case 3:
			return new SurgicalItemFactory();
		default:
			return null;
		}
	}
}
