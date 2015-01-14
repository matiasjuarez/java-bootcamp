package point2House.Model;

public class House {
	private Room rooms[];
	private int numberOfRooms = 0;

	public House(int numberOfRooms) {
		rooms = new Room[numberOfRooms];
	}

	public String toString() {
		String str = "Features of the house: \n";

		for (Room room : rooms) {
			str += "Room number " + room.getRoomNumber() + "\n";
			int wallNumber = 1;
			for (Wall wall : room.getWalls()) {
				str += "Wall number " + wallNumber + ":\n";

				for (Opening opening : wall.getOpenings()) {
					if (opening != null)
						str += " + " + opening.getClass().getSimpleName() + "\n";
				}
				wallNumber++;
			}
			str += "\n*********************************************************\n";
		}

		str += "******************************\n****************************\n\n";

		return str;
	}

	public Room[] getRooms() {
		return rooms;
	}

	public boolean addRoom(Room room) {
		if (numberOfRooms == rooms.length)
			return false;
		rooms[numberOfRooms] = room;
		numberOfRooms++;
		return true;
	}
}
