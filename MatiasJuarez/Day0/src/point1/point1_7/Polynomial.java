package point1.point1_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Polynomial {
	double coef[];

	public Polynomial(double... coef) {
		this.coef = coef;
	}

	public Polynomial(File file) {
		Scanner in = null;
		try {
			in = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		coef = new double[in.nextInt()];
		for (int i = 0; i < coef.length; i++) {
			coef[i] = in.nextDouble();
		}
	}

	public int getDegree() {
		return coef.length - 1;
	}

	public String toString() {
		String str = "";
		for (int i = coef.length - 1; i >= 0; i--) {
			str += coef[i] + " X ^ " + i + " + ";
		}

		return str.substring(0, str.length() - 2);
	}
	
	public Polynomial add(Polynomial another)
	{
		int longer = coef.length;
		if(another.coef.length > longer)
			longer = another.coef.length;
		
		double []ancillary = new double[longer];
		
		for(int i = another.coef.length - 1; i >= 0; i--)
		{
			ancillary[i] += another.coef[i];
		}
		
		for(int i = coef.length - 1; i >= 0 ; i--){
			ancillary[i] += coef[i];
		}
		
		return new Polynomial(ancillary);
	}
	
	public Polynomial multiply(Polynomial another)
	{
		int degree = this.getDegree() + another.getDegree() + 1;
		
		double ancillary [] = new double[degree];
		
		for(int i= 0; i < coef.length; i++)
		{
			for(int j = 0; j < another.coef.length;j++)
			{
				ancillary[j+i] += this.coef[i] * another.coef[j];
			}
		}
		
		return new Polynomial(ancillary);
	}
}
