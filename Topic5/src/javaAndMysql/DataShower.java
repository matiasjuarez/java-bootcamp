package javaAndMysql;

import java.sql.ResultSet;
import java.sql.SQLException;

// The intention of this class is to show the data recovered from the database in a specific format
public class DataShower {

	// This method shows the courses name's , the in-charge teacher and all the
	// students of this course
	public static String showBasicCourseData(String courseName)
			throws SQLException {

		MySqlDealer dealer = new MySqlDealer();

		ResultSet resultSet = dealer.getInformationOfCourse(courseName);

		String teacherFirstName = "";
		String teacherLastName = "";

		String studentsData = "";

		String formatedData = "";

		while (resultSet.next()) {
			if (courseName.equals(""))
				courseName = resultSet.getString(1);
			if (teacherFirstName.equals(""))
				teacherFirstName = resultSet.getString(2);
			if (teacherLastName.equals(""))
				teacherLastName = resultSet.getString(3);

			studentsData += "\t" + resultSet.getString(5) + ", "
					+ resultSet.getString(4) + "\n";
		}

		formatedData = "Course: " + courseName + "\n";
		formatedData += "Teacher: " + teacherLastName + ", " + teacherFirstName
				+ "\n";
		formatedData += "Students: \n";
		formatedData += studentsData;

		return formatedData;
	}

	// This method shows the marks of a particular course of a particular
	// student
	public static String showStudentsNote(String courseName,
			int registrationNumber) throws SQLException {
		MySqlDealer dealer = new MySqlDealer();

		ResultSet resultSet = dealer.getStudentsNoteOfCourse(courseName,
				registrationNumber);

		String formatedData = "";

		String studentMarks = "";

		while (resultSet.next()) {
			studentMarks += resultSet.getInt(1) + "\n";
		}

		formatedData = "Course: " + courseName + "\n";
		formatedData += "Student's number: " + registrationNumber + "\n";
		formatedData += studentMarks;

		return formatedData;
	}

	// This method does the same as the previous one, but this time we give this
	// method the last name of the student as a parameter
	public static String showStudentsNote(String courseName,
			String studentLastName) throws SQLException {
		MySqlDealer dealer = new MySqlDealer();

		ResultSet resultSet = dealer.getStudentsNoteOfCourse(courseName,
				studentLastName);

		String formatedData = "Course: " + courseName + "\n";

		String studentMarks = "";

		String studentFirstName = "";

		while (resultSet.next()) {
			if (!resultSet.getString(2).equalsIgnoreCase(studentFirstName)
					&& !studentMarks.equals("")) {
				formatedData += "\n" + studentLastName + ", "
						+ studentFirstName + "\n";
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

	// This method shows the percentage of approved and disapproved students of
	// a particular course
	public static String showDisapprovedApprovedPercentageFromCourse(
			String courseName, double averageToPass) throws SQLException {
		MySqlDealer dealer = new MySqlDealer();

		ResultSet resultSet = dealer
				.getAverageMarkOfStudentsFromCourse(courseName);

		int amountOfStudentsWithMarksApproved = 0;
		int amountOfStudentsWithMarksDisapproved = 0;

		while (resultSet.next()) {
			if (resultSet.getDouble(1) >= averageToPass) {
				amountOfStudentsWithMarksApproved++;
			} else
				amountOfStudentsWithMarksDisapproved++;
		}

		String formatedData = "Course data \n";

		formatedData += "Approved: "
				+ amountOfStudentsWithMarksApproved
				* 100
				/ (amountOfStudentsWithMarksApproved + amountOfStudentsWithMarksDisapproved)
				+ "%\n";
		formatedData += "Disapproved: "
				+ amountOfStudentsWithMarksDisapproved
				* 100
				/ (amountOfStudentsWithMarksApproved + amountOfStudentsWithMarksDisapproved)
				+ "%\n\n";

		return formatedData;
	}
}
