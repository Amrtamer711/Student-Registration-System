package View.student_views;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Model.Course;
import Model.Student;
import View.LoginScreen;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ViewAllCourses extends JFrame {
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public ViewAllCourses() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); 
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LoginScreen.studentScreen.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(10, 10, 92, 48);
		contentPane.add(btnBack);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(287, 155, -109, -28);
		contentPane.add(scrollPane);
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 68, 557, 357);
		contentPane.add(textArea);
		String s = "";
		ArrayList<Course> crs = StudentMenuScreen.controller.viewCourses();
		for (Course course : crs) {
			s += "Code = " +course.getCode() + ", Name = " + course.getName() + ", Department = " + course.getDepartment() + ", CH = "+ course.getCreditHours() + "\n\tAvailable Seats = "+ (course.getLimitOfStudents() - course.getNumberOfStudents() + ", Section = " + course.getSection() + "\n");
		}
		textArea.setText(s);
	}
}
