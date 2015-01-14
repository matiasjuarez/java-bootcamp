package point3Hospital.AbstractFactory;

import java.util.Date;

import point3Hospital.Model.Item;
import point3Hospital.Model.OfficeItem;
import point3Hospital.Model.Type;

public class SurgicalItemFactory extends ItemFactory {

	public SurgicalItemFactory() {
		// Let's initialize the type we will use for all the Items created by
		// this factory
		setType(new Type("Surgical", "scalpels, saws, drills"));
	}

	@Override
	public Item getItem(int numberOfItem) {
		switch (numberOfItem) {
		case 1:
			return new OfficeItem("Scapel", new Date(), getType());
		case 2:
			return new OfficeItem("Drill", new Date(), getType());
		default:
			return null;
		}
	}
}
