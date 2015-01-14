package point3Hospital.AbstractFactory;

import java.util.Date;

import point3Hospital.Model.Item;
import point3Hospital.Model.OfficeItem;
import point3Hospital.Model.Type;

public class CleaningItemFactory extends ItemFactory {
	public CleaningItemFactory() {
		// Let's initialize the type we will use for all the Items created by
		// this factory
		setType(new Type("Cleaning", "Brooms, sponges, floor mops"));
	}

	@Override
	public Item getItem(int numberOfItem) {
		switch (numberOfItem) {
		case 1:
			return new OfficeItem("Broom", new Date(), getType());
		case 2:
			return new OfficeItem("Sponge", new Date(), getType());
		default:
			return null;
		}
	}
}
