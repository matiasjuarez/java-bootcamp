package point2House.Builder;

import point2House.Model.Room;

public class DirectorWindowsAndDoors implements DirectorRoomBuilder {
	private RoomBuilder roomBuilder = null;

	public DirectorWindowsAndDoors(RoomBuilder roomBuilder) {
		this.roomBuilder = roomBuilder;
	}

	@Override
	public Room getRoom() {
		return roomBuilder.getRοοm();
	}

	@Override
	public void buildRoom() {
		roomBuilder.buildRoom();
		long randomNumber;

		// Here we build the four walls of a room and using a random number we
		// decide if a wall should have
		// nothing, doors, windows or both
		for (int i = 0; i < 4; i++) {
			roomBuilder.buildWall();
			// The condition for this four is the amount of openings(windows and
			// doors) defined for a specific wall
			for (int j = 0; j < getRoom().getWall(i).getOpenings().length; j++) {
				randomNumber = Math.round(Math.random() * 100);

				if (randomNumber > 33 && randomNumber < 66)
					roomBuilder.buildWindow(getRoom().getWall(i));
				if (randomNumber >= 66) {
					roomBuilder.buildDoor(getRoom().getWall(i));
				}
			}

		}
	}
}
