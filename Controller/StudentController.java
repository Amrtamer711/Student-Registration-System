package Controller;
import Model.Course;
import Model.Student;
import java.sql.SQLException;
import java.util.ArrayList;
public class StudentController {
	private Database database = new Database();
	public StudentController() {
	}
	public ArrayList<Course> viewCourses(){
		ArrayList<Course> courses = new ArrayList<>();
		try {
			database.preStatement = database.connection.prepareStatement("SELECT * FROM course");
			database.result = database.preStatement.executeQuery();
			while (database.result.next()){
				courses.add(new Course(database.result.getString(1), database.result.getString(2), database.result.getInt(3), database.result.getString(4),  database.result.getString(5), database.result.getInt(6),  database.result.getString(7), database.result.getInt(8),  database.result.getInt(11), database.result.getInt(12), database.result.getDate(9).toLocalDate(), database.result.getDate(10).toLocalDate()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courses;
	}
	public boolean addCourse(String code, int creditHours, int id){
		if (canAddCourseToStudent(creditHours, id) && 
				haveAvailableSeats(code)){
			try {
				database.preStatement = database.connection.prepareStatement("UPDATE course SET no_of_student = no_of_student + '" + 1 + "' WHERE code = '" + code + "'");
				database.preStatement.execute();
				database.preStatement = database.connection.prepareStatement("UPDATE student SET register_hours = register_hours + '" + creditHours + "' WHERE id = '"+id+"'");
				database.preStatement.execute();
				database.preStatement = database.connection.prepareStatement("INSERT INTO student_courses VALUES(?, ?)");
				database.preStatement.setInt(1, id);
				database.preStatement.setString(2, code);
				database.preStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}
	public boolean canAddCourseToStudent(int cr, int studentId){
		try {
			database.preStatement = database.connection.prepareStatement("SELECT register_hours FROM student WHERE id = '" + studentId + "'");database.result = database.preStatement.executeQuery();
			if (database.result.next()){
				return database.result.getInt(1) + cr <= 15;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	} 
	public boolean haveAvailableSeats(String code) {
		try {
			database.preStatement = database.connection.prepareStatement("SELECT no_of_student, limit_students FROM course WHERE code = '"+code+"'");
			database.result = database.preStatement.executeQuery();
			if (database.result.next()){
				return database.result.getInt(2) - database.result.getInt(1) > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; 
	}
}

