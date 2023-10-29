package Controller;
import Model.Admin;
import Model.Course;
import Model.Instructor;
import java.sql.SQLException;
import java.util.ArrayList;
public class InstructorController {
	private Database database = new Database();
	private Instructor instructor;
	public InstructorController(Instructor instructor){
		this.instructor = instructor;
	}
	public ArrayList<Course> viewAllCourses(){
		ArrayList<Course> course = new ArrayList<>();
		try {
			database.preStatement = database.connection.prepareStatement("SELECT * FROM course WHERE instructor_id = '" + instructor.getId() + "'");
			database.result = database.preStatement.executeQuery();
			while (database.result.next()){
				course.add(new Course(database.result.getString(1), database.result.getString(2), database.result.getInt(3), database.result.getString(4), database.result.getString(5), database.result.getInt(6),  database.result.getString(7), database.result.getInt(8),  database.result.getInt(11), database.result.getInt(12), database.result.getDate(9).toLocalDate(), database.result.getDate(10).toLocalDate()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return course;
	}
}
