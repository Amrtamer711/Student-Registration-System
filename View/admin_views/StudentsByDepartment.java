package View.admin_views;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Model.Course;
import Model.Student;
import View.LoginScreen;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
public class StudentsByDepartment extends JFrame {
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public StudentsByDepartment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CS", "SE", "DS", "SFADA"}));
		comboBox.setBounds(10, 55, 142, 45);
		contentPane.add(comboBox); 
		JButton btnEnter = new JButton("Enter");
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEnter.setBounds(304, 55, 125, 45);
		contentPane.add(btnEnter);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(251, 238, -59, -50);
		contentPane.add(scrollPane); 
		JTextArea area = new JTextArea();
		area.setEditable(false);
		area.setFont(new Font("Monospaced", Font.PLAIN, 16));
		area.setTabSize(20);
		area.setRows(10);
		area.setBounds(10, 109, 557, 278);
		contentPane.add(area); 
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LoginScreen.adminScreen.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(442, 55, 125, 45);
		contentPane.add(btnBack); 
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Student> students = 
						AdminMenuScreen.controller.studentsByDepartment(comboBox.getSelectedItem()
								.toString());
				String data = "";
				for (Student student: students) {
					String stds = "( ";
					for (Course course:
						AdminMenuScreen.controller.coursesByStudent(student.getId())) {
						stds += course.getCode() + ", ";
					}
					stds += " )";
					data += student.toString() + stds + "\n";
				}
				if (students.isEmpty()) data = "No data found";
				area.setText(data);
			}
		});
	}
}
