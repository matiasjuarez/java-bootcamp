package point2House.Builder;

import point2House.Model.Door;
import point2House.Model.Room;
import point2House.Model.Wall;
import point2House.Model.Window;

//This class builds up a room where the room itself, the windows and doors are a square
public class SquareRoomBuilder implements RoomBuilder {

	private Room room = null;

	public void buildRoom() {
		room = new Room();
	}

	@Override
	public void buildWindow(Wall wall) {
		Window window = new Window();
		window.setHeight(100);
		window.setWidth(100);
		wall.addOpening(window);
	}

	@Override
	public void buildDoor(Wall wall) {
		Door door = new Door();
		door.setHeight(200);
		door.setWidth(200);
		wall.addOpening(door);

	}

	@Override
	public void buildWall() {
		Wall wall = new Wall(500, 500);
		room.addWall(wall);
	}

	@Override
	public Room getRοοm() {

		return room;
	}

}
