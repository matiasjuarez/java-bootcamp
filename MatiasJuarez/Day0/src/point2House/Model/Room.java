package point2House.Model;

public class Room {

	private Wall[] walls;

	// This variable will be used to know how many walls have been created

	private int wallsNumber;

	private int numberOfRoom;

	public Room() {
		walls = new Wall[4];
		wallsNumber = 0;
		setWallsNumber(0);
		// In this statement we look for the number for this room
		numberOfRoom = SingletonLastRoomNumber.getInstance().getLastNumber();

		// Update the number that will correspond to the next room we create
		SingletonLastRoomNumber.getInstance().setLastNumber(numberOfRoom + 1);
	}

	// returns false when the array that stores the walls is full
	public boolean addWall(Wall wall) {
		if (wallsNumber == walls.length)
			return false;

		walls[wallsNumber] = wall;
		wallsNumber++;
		return true;
	}

	public int getWallsNumber() {
		return wallsNumber;
	}

	public void setWallsNumber(int wallsNumber) {
		this.wallsNumber = wallsNumber;
	}

	public Wall getWall(int i) {
		return walls[i];
	}

	public Wall[] getWalls() {
		return walls;
	}

	public int getRoomNumber() {
		return numberOfRoom;
	}
}
