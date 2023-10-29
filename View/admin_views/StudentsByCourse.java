package View.admin_views;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Model.Student;
import View.LoginScreen;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
public class StudentsByCourse extends JFrame {
	private JPanel contentPane;
	private JTextField code;
	/**
	 * Create the frame.
	 */
	public StudentsByCourse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); 
		JLabel lblNewLabel = new JLabel("Enter Course Code");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(23, 52, 134, 45);
		contentPane.add(lblNewLabel);
		code = new JTextField();
		code.setBounds(167, 57, 154, 39);
		contentPane.add(code);
		code.setColumns(10); 
		JButton btnEnter = new JButton("Enter");
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEnter.setBounds(331, 59, 94, 35);
		contentPane.add(btnEnter); 
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LoginScreen.adminScreen.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(448, 57, 94, 35);
		contentPane.add(btnBack); 
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(180, 275, 247, -104);
		contentPane.add(scrollPane); 
		JTextArea area = new JTextArea();
		area.setEditable(false);
		area.setBounds(10, 105, 532, 234);
		contentPane.add(area); 
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (code.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Field is empty");
					return;
				}
				ArrayList<Student> students = AdminMenuScreen.controller.studentsByCourseCode(code.getText());
				String data = "";
				for (Student student: students) {
					data += student.toString() + "\n";
				}
				if (students.isEmpty()) data = "No student found";
				area.setText(data); 
			}
		});
	}
}
