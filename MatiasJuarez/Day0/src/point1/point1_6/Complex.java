package point1.point1_6;

public class Complex {
	private double imaginary;
	private double real;
	
	public Complex(double real, double imaginary){
		this.setImaginary(imaginary);
		this.setReal(real);
	}

	public double getImaginary() {
		return imaginary;
	}

	public void setImaginary(double imaginary) {
		this.imaginary = imaginary;
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}
	
	public void setValue(double real, double imaginary){
		this.real = real;
		this.imaginary = imaginary;
	}
	
	public String toString(){
		return "("+real+" + " + imaginary + "i )";
		
	}
	
	public boolean isReal()
	{
		if(imaginary == 0)
			return true;
		return false;
	}
	
	public boolean isImaginary(){
		if(real == 0)
			return true;
		return false;
	}
	
	public boolean equals(double real, double imaginary){
		if(this.real == real && this.imaginary == imaginary)
			return true;
		return false;
	}
	
	public boolean equals(Complex another){
		if(this.imaginary == another.imaginary && this.real == another.real)
			return true;
		return false;
	}
	
	public double magnitude(){
		return Math.sqrt(real * real + imaginary * imaginary);
	}
	
	
	
	public Complex divide(Complex another){
		Complex ancillary;
		
		double ancReal = ((this.real * another.real) + (this.imaginary * another.imaginary))/(Math.pow(another.imaginary, 2) + Math.pow(another.real, 2));
		double ancImaginary = (this.imaginary * another.real - this.real * another.imaginary) / (Math.pow(another.real, 2) + Math.pow(another.imaginary, 2));
		
		ancillary = new Complex(ancReal, ancImaginary);
		
		return ancillary;
	}
	
	
}
