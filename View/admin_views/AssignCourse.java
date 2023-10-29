package View.admin_views;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controller.AdminController;
import View.LoginScreen;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class AssignCourse extends JFrame {
	private JPanel contentPane;
	private JTextField insID;
	private JTextField code;
	/**
	 * Create the frame.
	 */
	public AssignCourse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Enter Instructor ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(21, 73, 184, 55);
		contentPane.add(lblNewLabel);
		insID = new JTextField();
		insID.setBounds(202, 82, 279, 41);
		contentPane.add(insID);
		insID.setColumns(10); 
		JLabel lblAssignCourseCode = new JLabel("Assign Course Code");
		lblAssignCourseCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAssignCourseCode.setBounds(21, 146, 184, 55);
		contentPane.add(lblAssignCourseCode);
		code = new JTextField();
		code.setColumns(10);
		code.setBounds(202, 155, 279, 41);
		contentPane.add(code);
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LoginScreen.adminScreen.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(176, 300, 101, 32);
		contentPane.add(btnBack);
		JButton btnAssign = new JButton("Assign");
		btnAssign.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAssign.setBounds(176, 234, 101, 32);
		contentPane.add(btnAssign); 
		btnAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (insID.getText().equals("") || 
						code.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Field is empty");
					return;
				}
				if
				(AdminMenuScreen.controller.assignedCourse(Integer.parseInt(insID.getText(
						)), code.getText())) {
					JOptionPane.showMessageDialog(null, "Course assigned to Instructor");
				}else {
					JOptionPane.showMessageDialog(null, "Any field is invalid or not found");
				}
			}
		});
	}
}
