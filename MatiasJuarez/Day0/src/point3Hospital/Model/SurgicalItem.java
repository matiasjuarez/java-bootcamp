package point3Hospital.Model;

import java.util.Date;

public class SurgicalItem extends Item {

	public SurgicalItem(String name, Date registrationDate, Type type) {
		setName(name);
		setRegistrationDate(registrationDate);
		setType(type);
	}
}
