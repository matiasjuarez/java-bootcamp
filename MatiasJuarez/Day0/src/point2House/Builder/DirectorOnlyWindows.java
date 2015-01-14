package point2House.Builder;

import point2House.Model.Room;

public class DirectorOnlyWindows implements DirectorRoomBuilder {
	private RoomBuilder roomBuilder = null;

	public DirectorOnlyWindows(RoomBuilder roomBuilder) {
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
		// decide if that wall is going to have
		// 0,1 or 2 windows
		for (int i = 0; i < 4; i++) {
			randomNumber = Math.round(Math.random() * 100);

			roomBuilder.buildWall();

			if (randomNumber > 33 && randomNumber < 66)
				roomBuilder.buildWindow(getRoom().getWall(i));
			if (randomNumber >= 66) {
				roomBuilder.buildWindow(getRoom().getWall(i));
				roomBuilder.buildWindow(getRoom().getWall(i));
			}

		}
	}
}
