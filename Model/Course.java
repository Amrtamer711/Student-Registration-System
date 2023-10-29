package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
public class Course {
	private String code;
	private String name;
	private int creditHours;
	private String section;
	private String time;
	private int room_no;
	private String department;
	private int instructor;
	private ArrayList<Student> students;
	private int numberOfStudents;
	private int limitOfStudents;
	private LocalDate startDate, endDate;
	public Course(String code, String name, int creditHours, String section, String time, int room_no, String department, int instructor, int numberOfStudents, int limitOfStudents, LocalDate startDate, LocalDate endDate) {
		this.code = code;
		this.name = name;
		this.creditHours = creditHours;
		this.section = section;
		this.time = time;
		this.room_no = room_no;
	
		this.instructor = instructor;
		this.department = department;
		this.students = new ArrayList<>();
		this.numberOfStudents = numberOfStudents;
		this.limitOfStudents = limitOfStudents;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public boolean addStudent(Student student) {
		if (numberOfStudents == limitOfStudents)
			return false;
		numberOfStudents++;
		return this.students.add(student);
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCreditHours() {
		return creditHours;
	}
	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getRoom_no() {
		return room_no;
	}
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
	public int getInstructor() {
		return instructor;
	}
	public void setInstructor(int instructor) {
		this.instructor = instructor;
	}
	public ArrayList<Student> getStudents() {
		return students;
	}
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	public int getNumberOfStudents() {
		return numberOfStudents;
	}
	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}
	public int getLimitOfStudents() {
		return limitOfStudents;
	}
	public void setLimitOfStudents(int limitOfStudents) {
		this.limitOfStudents = limitOfStudents;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	 public void setStartDate(LocalDate startDate) {
		 this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String details() {
		String ids = "";
		for (Student s: getStudents())
			ids += "(" + s.getId() + ", " + s.getName() + ") ";
		return "Code=" + getCode() + ", Name=" + getName() + ", ch=" + creditHours + ", Section=" + getSection() + ", time=" + getTime() + "\n\troom_no=" + getRoom_no() + ", Start=" + getStartDate().toString() + ", End=" + getEndDate() + "\n" + ids;
	}
	@Override
	public String toString() {
		return getCode() + " " + getName();
	}
}

