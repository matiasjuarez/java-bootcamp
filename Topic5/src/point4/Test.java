package point4;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

	public static void main(String args[]) throws SQLException {
		
		MySqlDealer dealer = new MySqlDealer();
		
		dealer.conectToDataBase("matias", "120491oK");
		
		// This shows point 4
		System.out.println("Point 4: \n\n");
		String formatedCourseData = DataShower.showBasicCourseData("History");
		
		System.out.println(formatedCourseData);
		
		//************************
		
		// This shows point 5
		System.out.println("\n\nPoint 5: \n\n");
		System.out.println(DataShower.showStudentsNote("Maths", 3));
		System.out.println(DataShower.showStudentsNote("Maths", "Simpson"));
		
		// ***********************
		
		
		
		
	}
}
