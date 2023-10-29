package View.student_views;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controller.AdminController;
import Model.Student;
import View.LoginScreen;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class AddCourse extends JFrame {
	private JPanel contentPane;
	private JTextField code;
	/**
	 * Create the frame.
	 */
	public AddCourse(Student student) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 323);
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
		btnBack.setBounds(10, 10, 85, 52);
		contentPane.add(btnBack);
		JLabel lblNewLabel = new JLabel("Course Code");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 98, 150, 36);
		contentPane.add(lblNewLabel);
		code = new JTextField();
		code.setBounds(200, 98, 214, 36);
		contentPane.add(code);
		code.setColumns(10);
		JButton btnEnroll = new JButton("Enroll");
		btnEnroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (code.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Field is empty");
					return;
				}
				AdminController controller = new AdminController();
				if (StudentMenuScreen.controller.addCourse(code.getText(), controller.getCourseCreditHours(code.getText()) , student.getId())) {
					JOptionPane.showMessageDialog(null, "Student enrolled the course");
				}else {
					JOptionPane.showMessageDialog(null, "Due to Some problem Course can't be added. Check course code and also credit hours.\n" + "(Student credit hours must be less than or equal to 15 And also check available seats)");
				} 
			}
		});
		btnEnroll.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEnroll.setBounds(166, 199, 154, 36);
		contentPane.add(btnEnroll);
	}
}

