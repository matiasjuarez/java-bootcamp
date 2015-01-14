package point3Hospital.ShelvingBuilder;

import point3Hospital.Model.LiquidMedicine;
import point3Hospital.Model.Medicine;
import point3Hospital.Model.Ointment;
import point3Hospital.Model.Pill;

public class MedicineFactory {

	public Medicine getMedicine(String type) {
		if (type.equalsIgnoreCase("pill"))
			return new Pill();
		if (type.equalsIgnoreCase("liquid"))
			return new LiquidMedicine();
		if (type.equalsIgnoreCase("ointment"))
			return new Ointment();
		return null;
	}
}
