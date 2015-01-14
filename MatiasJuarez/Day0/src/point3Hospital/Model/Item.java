package point3Hospital.Model;

import java.util.Date;

//An abstract superClass of CleaningItem, OfficeItem and SurgicalItem
public abstract class Item {
	private String name;
	private Type type;
	private Date registrationDate;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String toString() {
		return "[" + name + " - Registration: " + registrationDate.toString() + " - Type: " + type.getName() + "]";
	}

}
