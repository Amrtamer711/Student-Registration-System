package View.admin_views;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import Model.Course;
import Model.Student;
import View.LoginScreen;
public class CoursesByStudent extends JFrame {
	private JPanel contentPane;
	private JTextField id;
	/**
	 * Create the frame.
	 */
	public CoursesByStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); 
		JLabel lblNewLabel = new JLabel("Enter Student ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(23, 52, 134, 45);
		contentPane.add(lblNewLabel);
		id = new JTextField();
		id.setBounds(167, 57, 154, 39);
		contentPane.add(id);
		id.setColumns(10);
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
		scrollPane.setBounds(10, 338, 532, -228);
		contentPane.add(scrollPane);
		JTextArea area = new JTextArea();
		area.setEditable(false);
		area.setBounds(10, 105, 532, 234);
		contentPane.add(area);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (id.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Field is empty");
					return;
				}
				ArrayList<Course> courses= AdminMenuScreen.controller.coursesByStudent(Integer.parseInt(id.getText()));
				String data = "";
				for (Course course: courses) {
					data += course.toString() + "\n";
				}
				if (courses.isEmpty()) data = "No Course found";
				area.setText(data); 
			}
		});
	}
}
