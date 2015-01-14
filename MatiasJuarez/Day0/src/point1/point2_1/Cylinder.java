package point1.point2_1;

public class Cylinder extends Circle{
	
	private double height;
	
	public Cylinder(){
		super();
		height = 1;
	}
	
	public Cylinder(double height)
	{
		super();
		this.height = height;
	}
	
	public Cylinder(double height, double radius)
	{
		super(radius);
		this.height = height;
	}
	
	public double getHeight(){
		return height;
	}
	
	public double getVolume(){
		return super.getArea()*height;
	}
	
	@Override
	public double getArea(){
		return (getRadius()*height*Math.PI) + (super.getArea() * 2);
	}
}
