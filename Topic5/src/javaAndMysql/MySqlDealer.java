package javaAndMysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlDealer {
	private static Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	// This opens a connection to the data base 'highschool'
	public Connection conectToDataBase(String userName, String password)
			throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		// Properties connectionProperties = new Properties();
		// connectionProperties.put("user", userNamePassed);
		// connectionProperties.put("password", passwordPassed);
		connect = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/highschool?user="
						+ userName + "&password=" + password);

		return connect;
	}

	// This method retrieves the data of a particular course
	public ResultSet getInformationOfCourse(String courseName)
			throws SQLException {

		statement = connect.createStatement();

		String query = "select c.name, c.teacherFirstName, c.teacherLastName, s.firstname, s.lastname from course as C "
				+ "join coursesperstudent as cps on c.name = cps.courseName "
				+ "join student as s on cps.registrationNumber = s.registrationNumber "
				+ "where c.name='" + courseName + "' order by s.lastname";

		resultSet = statement.executeQuery(query);

		return resultSet;
	}

	// This method fetches the notes of a student of a particular course using
	// the registration number of the student
	public ResultSet getStudentsNoteOfCourse(String courseName,
			int registrationNumber) throws SQLException {
		statement = connect.createStatement();

		String query = "select mark from marksperstudentpercourse "
				+ "where courseName='" + courseName
				+ "' and registrationNumber=" + registrationNumber
				+ " order by mark desc";

		resultSet = statement.executeQuery(query);

		return resultSet;

	}

	// This method does the same thing as the previous one but this time using
	// the last name of the student
	public ResultSet getStudentsNoteOfCourse(String courseName,
			String studentLastName) throws SQLException {
		statement = connect.createStatement();

		String query = "select mark, firstName, lastName from marksperstudentpercourse as m "
				+ "join student as s on s.registrationNumber = m.registrationNumber "
				+ "where courseName='"
				+ courseName
				+ "' and lastName='"
				+ studentLastName + "' order by mark desc, firstname";

		resultSet = statement.executeQuery(query);

		return resultSet;

	}

	// This method calculates the average mark of all students of a particular
	// course
	public ResultSet getAverageMarkOfStudentsFromCourse(String courseName)
			throws SQLException {

		statement = connect.createStatement();

		String query = "select AVG(mark) from marksperstudentpercourse"
				+ " where courseName = 'Maths' group by registrationNumber";

		resultSet = statement.executeQuery(query);

		return resultSet;
	}

}
