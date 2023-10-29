package View.student_views;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controller.StudentController;
import Model.Student;
import View.LoginScreen;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class StudentMenuScreen extends JFrame {
	private JPanel contentPane;
	private Student student;
	public static StudentController controller = new StudentController();
	/**
	 * Create the frame.
	 */
	public StudentMenuScreen(Student student) {
		this.student = student;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Student Menu");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(167, 68, 192, 47);
		contentPane.add(lblNewLabel);
		JButton addCourse = new JButton("Add Course");
		addCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AddCourse screen = new AddCourse(student);
				screen.setVisible(true);
			}
		});
		addCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addCourse.setBounds(167, 173, 192, 36);
		contentPane.add(addCourse);

		JButton ViewAllCourses = new JButton("View All Courses");
		ViewAllCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ViewAllCourses screen = new ViewAllCourses();
				screen.setVisible(true);
			}
		});
		ViewAllCourses.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ViewAllCourses.setBounds(167, 243, 192, 36);
		contentPane.add(ViewAllCourses);
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LoginScreen.frame.setVisible(true);
			}
		});
		back.setFont(new Font("Tahoma", Font.PLAIN, 12));
		back.setBounds(22, 299, 95, 36);
		contentPane.add(back);
	}
}
