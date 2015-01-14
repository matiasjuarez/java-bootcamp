package point1.point2_2;

public class Shape {
	private String color;
	private boolean filled;
	
	public Shape(){
		setColor("red");
		setFilled(true);
	}
	
	public Shape(String color, boolean filled){
		this.setColor(color);
		this.setFilled(filled);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public String toString(){
		String str = "A shape with color of " + color;
		if(filled)
			str += " filled";
		else
			str += " not filled";
		return str;
	}
}
