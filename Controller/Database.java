package Controller;

import Model.Admin;
import Model.Course;
import Model.Instructor;
import Model.Student;
import java.sql.*;
import java.util.ArrayList;
public class Database {
	public Connection connection = null;
	public PreparedStatement preStatement = null;
	public ResultSet result = null;
	public final String CONNECTION_URL = "jdbc:mysql://localhost:3306/";
	public final String DATABASE_NAME = "school_system";
	public Database(){
		try {
			connection = DriverManager.getConnection(CONNECTION_URL + DATABASE_NAME , "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Admin getAdmin(){
		try {
			preStatement = connection.prepareStatement("SELECT * FROM admin");
			result = preStatement.executeQuery();
			if (result.next())
				return new Admin(result.getString(2), result.getInt(1), result.getString(3));
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Student getStudent(int id, String password) {
		try {
			preStatement = connection.prepareStatement("SELECT * FROM student WHERE id = '" + id + "' AND password = '" + password + "'");
			result = preStatement.executeQuery();
			if (result.next()) {
				return new Student(result.getString(2), id, password, result.getString(4), result.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Instructor getInstructor(int id, String password) {
		try {
			preStatement = connection.prepareStatement("SELECT * FROM instructor WHERE id = '" + id + "' AND password = '" + password + "'");
			result = preStatement.executeQuery();
			if (result.next()) {
				return new Instructor(result.getString(2), id, password, result.getString(4), result.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
