package point2House.Model;

public class Wall {

	private double height;
	private double width;
	private Opening[] openings = new Opening[2];
	private int openingsNumber = 0;

	public Wall() {
		setHeight(300);
		setWidth(300);
	}

	public Wall(double height) {

		this.setHeight(height);
	}

	public Wall(double height, double width) {

		this.setHeight(height);
		this.setWidth(width);
	}

	// returns false when the array that stores the openings is full
	public boolean addOpening(Opening opening) {
		if (openingsNumber == openings.length)
			return false;

		openings[openingsNumber] = opening;
		openingsNumber++;
		return true;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public Opening[] getOpenings() {
		return openings;
	}

	public void setOpenings(Opening[] openings) {
		this.openings = openings;
	}

	public int getOpeningsNumber() {
		return openingsNumber;
	}

	public void setOpeningsNumber(int openingsNumber) {
		this.openingsNumber = openingsNumber;
	}
}
