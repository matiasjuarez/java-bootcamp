package point1.point1_1;

public class Circle {
	
	private String color;
	private double radius;
	
	public Circle()
	{
		color = "red";
		radius = 1;
	}
	
	public Circle(double radius){
		this.radius = radius;
		color = "red";
	}
	
	public Circle(double radius, String color)
	{
		this.color = color;
		this.radius = radius;
	}
	
	public double getRadius()
	{
		return radius;
	}
	
	public String getColor(){
		return color;
	}
	
	public double getArea(){
		return (radius*radius*Math.PI);
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	public void setRadius(double radius)
	{
		this.radius = radius;
	}
	
	public String toString()
	{
		
		String str = "The circle has radius of " + radius + ", area of " + getArea() + "and is " + color;
		return str;
	}
	
}
