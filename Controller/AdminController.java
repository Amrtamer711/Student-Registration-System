package Controller;
import Model.Course;
import Model.Instructor;
import Model.Student;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
public class AdminController {
	Database database = new Database();
	public AdminController(){}
	//actions on students
	public boolean addStudent(Student student){
		try {
			database.preStatement = database.connection.prepareStatement("INSERT INTO student VALUES(?,?,?,?,?)");
			database.preStatement.setInt(1, student.getId());
			database.preStatement.setString(2, student.getName());
			database.preStatement.setString(3, student.getPassword());
			database.preStatement.setString(4, student.getDepartment());
			database.preStatement.setInt(5, student.getRegisteredHours());
			int a = database.preStatement.executeUpdate();
			if (a > 0) return true;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean removeStudent(int id){
		try {
			database.preStatement = database.connection.prepareStatement("DELETE FROM student WHERE id = '"+id+"'");
			int a = database.preStatement.executeUpdate();
			if (a > 0) return true;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean modifyStudent(int id, Student student){
		if (removeStudent(id)) return addStudent(student);
		return false;
	}
	public ArrayList<Student> studentsByDepartment(String department){
		ArrayList<Student> students = new ArrayList<>();
		try {
			database.preStatement = database.connection.prepareStatement("SELECT * FROM student WHERE department = '" + department + "'");
			database.result = database.preStatement.executeQuery();
			while (database.result.next()){
				students.add(new Student(database.result.getString(2), database.result.getInt(1), database.result.getString(3), database.result.getString(4), database.result.getInt(5 )));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
	public ArrayList<Student> studentsByCourseCode(String code){
		ArrayList<Student> students = new ArrayList<>();
		try {
			database.preStatement = database.connection.prepareStatement("SELECT s.* FROM student_courses sc JOIN student s ON (s.id = sc.student_id)" + " WHERE sc.course_id = '"+code+"'");
			database.result = database.preStatement.executeQuery();
			while (database.result.next()){
				students.add(new Student(database.result.getString(2), database.result.getInt(1), database.result.getString(3), database.result.getString(4), database.result.getInt(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
	public ArrayList<Course> coursesByStudent(int id){
		ArrayList<Course> courses = new ArrayList<>();
		try {
			database.preStatement = database.connection.prepareStatement("SELECT c.* FROM student_courses sc JOIN course c ON (c.code = sc.course_id) " + "WHERE sc.student_id = '" +id+"'");
			database.result = database.preStatement.executeQuery();
			while (database.result.next()){
				courses.add(new Course(database.result.getString(1), database.result.getString(2), database.result.getInt(3), database.result.getString(4), database.result.getString(5), database.result.getInt(6), database.result.getString(7), database.result.getInt(8), database.result.getInt(11), database.result.getInt(12), database.result.getDate(9).toLocalDate(), database.result.getDate(10).toLocalDate()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courses;
	}
	//instructors
	public boolean addInstructor(Instructor instructor){
		try {
			database.preStatement = database.connection.prepareStatement("INSERT INTO instructor VALUES(?,?,?,?,?)");
			database.preStatement.setInt(1, instructor.getId());
			database.preStatement.setString(2, instructor.getName());
			database.preStatement.setString(3, instructor.getPassword());
			database.preStatement.setString(4, instructor.getDepartment());
			database.preStatement.setInt(5, 0);
			int a = database.preStatement.executeUpdate();
			if (a > 0) return true;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean removeInstructor(int id){
		try {
			database.preStatement = database.connection.prepareStatement("DELETE FROM instructor WHERE id = '" + id + "'");
			int a = database.preStatement.executeUpdate();
			if (a > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean modifyInstructor(int id, Instructor instructor){
		if (removeInstructor(id)){
			return addInstructor(instructor);
		}
		return false;
	}
	public boolean assignedCourse(int insId, String code){
		try {
			database.preStatement = database.connection.prepareStatement("SELECT load_ FROM instructor WHERE id = '" + insId + "'");
			database.result = database.preStatement.executeQuery();
			int load = 0;
			if (database.result.next()) {
				int result = database.result.getInt(1);
				if (result == -1) {
					return false;
				}
				else if (result + courseByCode(code).getCreditHours() > 12) {
					return false;
				}
				load = result + courseByCode(code).getCreditHours();
			}
			else return false;
			database.preStatement = database.connection.prepareStatement("UPDATE instructor SET load_ = '" + load + "' WHERE id = '" + insId + "'");
			database.preStatement.execute();
			database.preStatement = database.connection.prepareStatement("UPDATE course SET instructor_id = '"+insId+"' WHERE code = '"+code+"'");
			int a = database.preStatement.executeUpdate();
			if (a > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<Instructor> instructorsByDepartment(String
			department){
		ArrayList<Instructor> instructors = new ArrayList<>();
		try {
			database.preStatement = database.connection.prepareStatement("SELECT * FROM instructor WHERE department = '" + department + "'");
			database.result = database.preStatement.executeQuery();
			while (database.result.next()){
				instructors.add(new Instructor(database.result.getString(2), database.result.getInt(1), database.result.getString(3), database.result.getString(4), database.result.getInt(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return instructors;
	}
	public ArrayList<Instructor> instructorsByCourseCode(String code){
		ArrayList<Instructor> instructors = new ArrayList<>();
		try {
			database.preStatement = database.connection.prepareStatement("SELECT i.* FROM instructor i JOIN course c ON (i.id = c.instructor_id) WHERE c.code = '" + code + "'");
			database.result = database.preStatement.executeQuery();
			while (database.result.next()){
				instructors.add(new Instructor(database.result.getString(2), database.result.getInt(1), database.result.getString(3), database.result.getString(4), database.result.getInt(5 )));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return instructors;
	}
	public ArrayList<Course> coursesByInstructor(int id){
		ArrayList<Course> courses = new ArrayList<>();
		try {
			database.preStatement = database.connection.prepareStatement("SELECT * FROM course WHERE instructor_id = '" + id + "'");
			database.result = database.preStatement.executeQuery();
			while (database.result.next()){
				courses.add(new Course(database.result.getString(1), database.result.getString(2), database.result.getInt(3), database.result.getString(4), database.result.getString(5), database.result.getInt(6), database.result.getString(7), database.result.getInt(8), database.result.getInt(11), database.result.getInt(12), database.result.getDate(9).toLocalDate(), database.result.getDate(10).toLocalDate()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courses;
	}
	public ArrayList<Course> coursesByDepartment(String department){
		ArrayList<Course> courses = new ArrayList<>();
		try {
			database.preStatement = database.connection.prepareStatement("SELECT * FROM course WHERE department = '" + department + "'");
			database.result = database.preStatement.executeQuery();
			while (database.result.next()){
				courses.add(new Course(database.result.getString(1), database.result.getString(2), database.result.getInt(3),
						database.result.getString(4), database.result.getString(5), database.result.getInt(6), database.result.getString(7), database.result.getInt(8), database.result.getInt(11), database.result.getInt(12), database.result.getDate(9).toLocalDate(), database.result.getDate(10).toLocalDate()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courses;
	}
	//courses
	public boolean addCourse(Course course){
		try {
			database.preStatement = database.connection.prepareStatement("INSERT INTO course VALUES (? ,? ,?, ? ,?, ?, ?, ?, ? ,? ,?, ?)");
			database.preStatement.setString(1, course.getCode());
			database.preStatement.setString(2, course.getName());
			database.preStatement.setInt(3, course.getCreditHours());
			database.preStatement.setString(4, course.getSection());
			database.preStatement.setString(5, course.getTime());
			database.preStatement.setInt(6, course.getRoom_no());
			database.preStatement.setString(7, course.getDepartment());
			database.preStatement.setInt(8, course.getInstructor());
			database.preStatement.setDate(9, Date.valueOf(course.getStartDate()));
			database.preStatement.setDate(10, Date.valueOf(course.getEndDate()));
			database.preStatement.setInt(11, 0);
			database.preStatement.setInt(12, course.getLimitOfStudents());
			int a = database.preStatement.executeUpdate();
			if (a > 0) return true;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean removeCourse(String code){
		try {
			database.preStatement = database.connection.prepareStatement("DELETE FROM course WHERE code = '"+code+"'");
			int a = database.preStatement.executeUpdate();
			if (a > 0)
				return true;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean modifyCourse(String code, Course course){
		if (removeCourse(code)) return addCourse(course);
		return false;
	}
	public Course courseByCode(String code){
		try {
			database.preStatement = database.connection.prepareStatement("SELECT * FROM course WHERE code = '" + code + "'");
			database.result = database.preStatement.executeQuery();
			if(database.result.next()){
				Course course = new Course(database.result.getString(1), database.result.getString(2), database.result.getInt(3), database.result.getString(4), database.result.getString(5), database.result.getInt(6), database.result.getString(7), database.result.getInt(8), database.result.getInt(11), database.result.getInt(12), database.result.getDate(9).toLocalDate(), database.result.getDate(10).toLocalDate());
				return course;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public int getStudentRegisterHours(int id) {
		try {
			database.preStatement = database.connection.prepareStatement("SELECT register_hours FROM student WHERE id = '" + id + "'");
			database.result = database.preStatement.executeQuery();
			if (database.result.next()) return database.result.getInt(1);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public int getInstructorLoad(int id) {
		try {
			database.preStatement = database.connection.prepareStatement
					("SELECT load_ FROM instructor WHERE id = '"+id+"'");
			database.result = database.preStatement.executeQuery();
			if (database.result.next()) return database.result.getInt(1);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public int getCourseNoOfStudents(String code) {
		try {
			database.preStatement = database.connection.prepareStatement("SELECT no_of_students FROM course WHERE code = '" + code + "'");
			database.result = database.preStatement.executeQuery();
			if (database.result.next()){
				return database.result.getInt(1);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public int getCourseCreditHours(String code) {
		try {
			database.preStatement = database.connection.prepareStatement("SELECT credit_hours FROM course WHERE code = '" + code + "'");
			database.result = database.preStatement.executeQuery();
			if (database.result.next()){
				return database.result.getInt(1);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public boolean containsInstructor(int id) {
		try {
			database.preStatement = database.connection.prepareStatement("SELECT * FROM instructor WHERE id = '" + id + "'");
			database.result = database.preStatement.executeQuery();
			if (database.result.next()){
				return true;
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}




