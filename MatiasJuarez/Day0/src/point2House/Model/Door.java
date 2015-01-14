package point2House.Model;

public class Door extends Opening {

	private boolean opened;

	public Door() {

		setOpened(false);
	}

	public boolean isOpened() {
		return opened;
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
	}

}
