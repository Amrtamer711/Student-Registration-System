package View.instructor_views;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controller.InstructorController;
import Model.Course;
import Model.Instructor;
import Model.Student;
import View.LoginScreen;
import View.admin_views.AdminMenuScreen;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
public class InstructorMenuScreen extends JFrame {
	private JPanel contentPane;
	private Instructor instructor;
	/**
	 * Create the frame.
	 */
	public InstructorMenuScreen(Instructor instructor) {
		this.instructor = instructor;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LoginScreen.frame.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(10, 10, 85, 37);
		contentPane.add(btnBack);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(172, 199, -68, -82);
		contentPane.add(scrollPane); 
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textArea.setBounds(10, 57, 551, 290);
		contentPane.add(textArea);
		InstructorController controller = new
				InstructorController(instructor);
		String s = "";
		for (Course course: controller.viewAllCourses()) {
			String stds = "( ";
			for (Student student: AdminMenuScreen.controller.studentsByCourseCode(course.getCode())) {
				stds += student.getId() + ", ";
			}
			stds += " )";
			s += course.details() + "\t" + stds + "\n";
		}
		textArea.setText(s);
	}
}