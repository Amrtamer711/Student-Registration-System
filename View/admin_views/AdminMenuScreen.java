package View.admin_views;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controller.AdminController;
import View.LoginScreen;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class AdminMenuScreen extends JFrame {
	public static AdminController controller = new AdminController();
	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=-116,544
	 */
	private final JComboBox comboBox = new JComboBox();
	/**
	 * Create the frame.
	 */
	public AdminMenuScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 872, 592);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(307, 10, 265, 73);
		contentPane.add(lblNewLabel);
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AddStudent screen = new AddStudent();
				screen.setVisible(true);
			}
		});
		btnAddStudent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddStudent.setBounds(47, 105, 162, 53);
		contentPane.add(btnAddStudent);
		JButton btnUpdateStudentData = new JButton("Update Student Data");
		btnUpdateStudentData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				UpdateStudent screen = new UpdateStudent();
				screen.setVisible(true); 
			}
		});
		btnUpdateStudentData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdateStudentData.setBounds(307, 105, 245, 53);
		contentPane.add(btnUpdateStudentData);
		JButton btnRemoveStudent = new JButton("Remove");
		btnRemoveStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Remove screen = new Remove();
				screen.setVisible(true);
			}
		});
		btnRemoveStudent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemoveStudent.setBounds(635, 105, 162, 53);
		contentPane.add(btnRemoveStudent);
		JButton btnAddInstructor = new JButton("Add Instructor");
		btnAddInstructor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AddInstructor screen = new AddInstructor();
				screen.setVisible(true);
			}
		});
		btnAddInstructor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddInstructor.setBounds(47, 172, 162, 53);
		contentPane.add(btnAddInstructor);
		JButton btnUpdateInstructorData = new JButton("Update Instructor Data");
				btnUpdateInstructorData.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						UpdateInstructor screen = new UpdateInstructor();
						screen.setVisible(true);
					}
				});
				btnUpdateInstructorData.setFont(new Font("Tahoma", Font.PLAIN, 
						14));
				btnUpdateInstructorData.setBounds(307, 172, 245, 53);
				contentPane.add(btnUpdateInstructorData);
				JButton btnAddCourse = new JButton("Add Course");
				btnAddCourse.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						AddCourse course = new AddCourse();
						course.setVisible(true);
					}
				});
				btnAddCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnAddCourse.setBounds(47, 243, 162, 53);
				contentPane.add(btnAddCourse);
				JButton btnUpdateCourseData = new JButton("Update Course Data");
				btnUpdateCourseData.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						UpdateCourse screen = new UpdateCourse();
						screen.setVisible(true);
					}
				});
				btnUpdateCourseData.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnUpdateCourseData.setBounds(307, 243, 245, 53);
				contentPane.add(btnUpdateCourseData);
				JButton btnStdbyDept = new JButton("Students by Department");
				btnStdbyDept.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						StudentsByDepartment screen = new StudentsByDepartment();
						screen.setVisible(true);
					}
				});
				btnStdbyDept.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnStdbyDept.setBounds(47, 317, 185, 53);
				contentPane.add(btnStdbyDept);
				JButton btnstdByCrs = new JButton("Students by Course");
				btnstdByCrs.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false); 
						StudentsByCourse screen = new StudentsByCourse();
						screen.setVisible(true);
					}
				});
				btnstdByCrs.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnstdByCrs.setBounds(47, 394, 185, 53);
				contentPane.add(btnstdByCrs);
				JButton btnCrsOfStd = new JButton("Courses of Student");
				btnCrsOfStd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						CoursesByStudent screen = new CoursesByStudent();
						screen.setVisible(true);
					}
				});
				btnCrsOfStd.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnCrsOfStd.setBounds(344, 470, 185, 53);
				contentPane.add(btnCrsOfStd);
				JButton btnAssignCourse = new JButton("Assign Course");
				btnAssignCourse.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						AssignCourse screen = new AssignCourse();
						screen.setVisible(true);
					}
				});
				btnAssignCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnAssignCourse.setBounds(635, 172, 162, 53);
				contentPane.add(btnAssignCourse);
				JButton btnInstByDept = new JButton("Instructors by Department");
				btnInstByDept.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						InstructorsByDepartment screen = new InstructorsByDepartment();
						screen.setVisible(true);
					}
				});
				btnInstByDept.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnInstByDept.setBounds(307, 317, 245, 53);
				contentPane.add(btnInstByDept);
				JButton btnCrsOfInstr = new JButton("Courses of Instructor");
				btnCrsOfInstr.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						CoursesByInstructor screen = new CoursesByInstructor();
						screen.setVisible(true);
					}
				});
				btnCrsOfInstr.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnCrsOfInstr.setBounds(307, 394, 245, 53);
				contentPane.add(btnCrsOfInstr);
				JButton btnInstrBycrs = new JButton("Instructors by Course");
				btnInstrBycrs.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						InstructorsByCourse screen = new InstructorsByCourse();
						screen.setVisible(true); 
					} 
				});
				btnInstrBycrs.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnInstrBycrs.setBounds(612, 243, 185, 53);
				contentPane.add(btnInstrBycrs); 
				JButton btnCrsDetails = new JButton("Course Details");
				btnCrsDetails.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						CourseDetails screen = new CourseDetails();
						screen.setVisible(true);
					}
				});
				btnCrsDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnCrsDetails.setBounds(612, 394, 185, 53);
				contentPane.add(btnCrsDetails);
				JButton btnCrsByDept = new JButton("Course by Department");
				btnCrsByDept.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						CoursesOfDepartment screen = new CoursesOfDepartment();
						screen.setVisible(true);
					}
				});
				btnCrsByDept.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnCrsByDept.setBounds(612, 317, 185, 53);
				contentPane.add(btnCrsByDept);
				JButton btnBack = new JButton("back");
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						LoginScreen.frame.setVisible(true);
					}
				});
				btnBack.setForeground(Color.RED);
				btnBack.setBackground(SystemColor.activeCaptionBorder);
				btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnBack.setBounds(748, 10, 100, 53);
				contentPane.add(btnBack);
	}
}
