package point4;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataShower {
	
	public static String showBasicCourseData(String courseName) throws SQLException{
		
		MySqlDealer dealer = new MySqlDealer();
		
		ResultSet resultSet = dealer.getInformationOfCourse(courseName);
		
		String teacherFirstName = "";
		String teacherLastName = "";
		
		String studentsData = "";
		
		String formatedData = "";
		
		while(resultSet.next()){
			if(courseName.equals(""))
				courseName = resultSet.getString(1);
			if(teacherFirstName.equals(""))
				teacherFirstName = resultSet.getString(2);
			if(teacherLastName.equals(""))
				teacherLastName = resultSet.getString(3);
			
			studentsData += "\t" + resultSet.getString(5) + ", " + resultSet.getString(4) + "\n";
		}
		
		formatedData = "Course: " + courseName + "\n";
		formatedData += "Teacher: " + teacherLastName + ", " + teacherFirstName + "\n";
		formatedData += "Students: \n";
		formatedData += studentsData;
		
		
		return formatedData;
	}
	
	public static String showStudentsNote(String courseName, int registrationNumber) throws SQLException{
		MySqlDealer dealer = new MySqlDealer();
		
		ResultSet resultSet = dealer.getStudentsNoteOfCourse(courseName, registrationNumber);
		
		String formatedData = "";
		
		String studentMarks = "";
		
		while(resultSet.next()){
			studentMarks += resultSet.getInt(1) + "\n";
		}
		
		formatedData = "Course: " + courseName + "\n";
		formatedData += "Student's number: " + registrationNumber + "\n";
		formatedData += studentMarks;
		
		return formatedData;
	}
	
	public static String showStudentsNote(String courseName, String studentLastName) throws SQLException{
		MySqlDealer dealer = new MySqlDealer();
		
		ResultSet resultSet = dealer.getStudentsNoteOfCourse(courseName, studentLastName);
		
		String formatedData = "Course: " + courseName + "\n";
		
		String studentMarks = "";
		
		String studentFirstName = "";
		
		while(resultSet.next()){
			if(!resultSet.getString(2).equalsIgnoreCase(studentFirstName) && !studentMarks.equals(""))
			{
				formatedData += "\n" + studentLastName + ", " + studentFirstName + "\n";
				formatedData += studentMarks + "\n";
				studentMarks = "";
			}
			studentFirstName = resultSet.getString(2);
			studentMarks += resultSet.getInt(1) + "\n";
		}
		
		formatedData += "\n" + studentLastName + ", " + studentFirstName + "\n";
		formatedData += studentMarks;

		return formatedData;
	}
}
