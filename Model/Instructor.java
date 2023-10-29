package Model;

import java.util.ArrayList;
public class Instructor extends Person{
	private String department;
	private int load;
	private ArrayList<Course> courses;
	public Instructor(String name, int id, String password, String department, int load) {
		super(name, id, password);
		this.department = department;
		this.load = load;
		this.courses = new ArrayList<>();
 }
	public void addCourse(Course course){
		this.courses.add(course);
	}
	public ArrayList<Course> getCourses() {
		return courses;
	}
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getLoad() {
		return load;
	}
	public void setLoad(int load) {
		this.load = load;
	}
	@Override
	public String toString() {
		return getId() + " " + getName();
	}
}
