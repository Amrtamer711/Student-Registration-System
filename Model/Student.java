package Model;

import java.util.ArrayList;
public class Student extends Person {
	private String department;
	private int registeredHours;
	private ArrayList<Course> courses;
	public Student(String name, int id, String password, String department, int registeredHours) {
		super(name, id, password);
		this.department = department;
		this.registeredHours = registeredHours;
		this.courses = new ArrayList<>();
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getRegisteredHours() {
		return registeredHours;
	}
	public void setRegisteredHours(int registeredHours) {
		this.registeredHours = registeredHours;
	}
	public ArrayList<Course> getCourses() {
		return courses;
	}
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	public boolean addCourse(Course course) {
		if
		(!course.getDepartment().equalsIgnoreCase(this.getDepartment()))
			return false;
		if (registeredHours + course.getCreditHours() > 15)
			return false;
		this.registeredHours += course.getCreditHours();
		return this.courses.add(course);
	}
	@Override
	public String toString() {
		return getId() + " " + getName();
	}
}
