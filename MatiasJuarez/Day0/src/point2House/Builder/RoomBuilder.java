package point2House.Builder;

import point2House.Model.Room;
import point2House.Model.Wall;

public interface RoomBuilder {

	void buildRoom();

	void buildWindow(Wall wall);

	void buildDoor(Wall wall);

	void buildWall();

	Room getRοοm();
}
