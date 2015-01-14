package point3Hospital.Model;

import java.util.Date;

public class OfficeItem extends Item {

	public OfficeItem(String name, Date registrationDate, Type type) {
		setName(name);
		setRegistrationDate(registrationDate);
		setType(type);
	}
}
