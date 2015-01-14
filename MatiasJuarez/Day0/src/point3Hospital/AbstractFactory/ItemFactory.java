package point3Hospital.AbstractFactory;

import point3Hospital.Model.Item;
import point3Hospital.Model.Type;

//A superClass for CleaningItemFactory, OfficeItemFactory and SurgicalItemFactory
public abstract class ItemFactory {
	private Type type;

	public abstract Item getItem(int numberOfItem);

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
