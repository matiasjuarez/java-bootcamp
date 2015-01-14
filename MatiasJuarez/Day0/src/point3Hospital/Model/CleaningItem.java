package point3Hospital.Model;

import java.util.Date;

public class CleaningItem extends Item {

	public CleaningItem(String name, Date registrationDate, Type type) {
		setName(name);
		setRegistrationDate(registrationDate);
		setType(type);
	}
}
