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
import View.LoginScreen;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
public class CoursesOfDepartment extends JFrame {
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public CoursesOfDepartment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
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
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CS", "SE", "DS", "SFADA"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(30, 59, 168, 35);
		contentPane.add(comboBox);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				ArrayList<Course> courses= 
						AdminMenuScreen.controller.coursesByDepartment(comboBox.getSelectedItem().
								toString());
				String data = "";
				for (Course course: courses) {
					data += course.toString() + "\n";
				}
				if (courses.isEmpty()) {
					data = "No Course found";
				}
				area.setText(data); 
			}
		});
	}
}
