package point2House;

import point2House.Builder.DirectorOnlyWindows;
import point2House.Builder.DirectorWindowsAndDoors;
import point2House.Builder.SquareRoomBuilder;
import point2House.Model.House;
import point2House.Model.SingletonLastRoomNumber;

public class TestHouse {
	public static void main(String[] args) {

		// The parameter is used to create an array of length = x. This array
		// stores the amount of rooms of the house
		House house = new House(3);
		House house2 = new House(2);
		// This is the builder that builds the different parts of the house
		SquareRoomBuilder srb = new SquareRoomBuilder();

		// these are the directors that lead the construction
		DirectorWindowsAndDoors dir = new DirectorWindowsAndDoors(srb);
		DirectorOnlyWindows dir2 = new DirectorOnlyWindows(srb);

		// Here we build the different rooms that belong to a house
		for (int i = 0; i < house.getRooms().length; i++) {
			dir.buildRoom();
			house.addRoom(dir.getRoom());
		}

		// This statement restarts the Singleton. If you comment it, all the
		// rooms of the different houses you create
		// will follow a sequence instead of starting again from zero.
		SingletonLastRoomNumber.getInstance().setLastNumber(1);

		// We build the rooms that belong to another house
		for (int i = 0; i < house2.getRooms().length; i++) {
			dir2.buildRoom();
			house2.addRoom(dir.getRoom());
		}

		SingletonLastRoomNumber.getInstance().setLastNumber(1);

		System.out.println(house);
		System.out.println(house2);
	}
}
