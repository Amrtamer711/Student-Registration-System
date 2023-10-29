package View;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controller.Database;
import Model.Admin;
import Model.Instructor;
import Model.Student;
import View.admin_views.AdminMenuScreen;
import View.instructor_views.InstructorMenuScreen;
import View.student_views.StudentMenuScreen;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class LoginScreen extends JFrame {
	private JPanel contentPane;
	private JTextField id;
	private JTextField password;
	public static LoginScreen frame;
	public static Admin admin;
	public static Database database;
	public static AdminMenuScreen adminScreen;
	public static StudentMenuScreen studentScreen;
	public static InstructorMenuScreen instructorScreen;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		database = new Database();
		admin = database.getAdmin();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LoginScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public LoginScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(205, 57, 218, 51);
		contentPane.add(lblNewLabel); 
		JButton login = new JButton("Login"); 
		login.setFont(new Font("Tahoma", Font.PLAIN, 14));
		login.setBounds(205, 322, 218, 40);
		contentPane.add(login);
		id = new JTextField();
		id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		id.setBounds(263, 151, 254, 40);
		contentPane.add(id);
		id.setColumns(10);
		JLabel lblNewLabel_1 = new JLabel("Enter ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(112, 150, 128, 40);
		contentPane.add(lblNewLabel_1);
		JLabel lblNewLabel_1_1 = new JLabel("Enter Password:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(112, 211, 128, 40);
		contentPane.add(lblNewLabel_1_1);
		password = new JTextField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 15));
		password.setColumns(10);
		password.setBounds(263, 212, 254, 40);
		contentPane.add(password);
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.RED);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Instructor", "Student"}));
		comboBox.setBounds(243, 278, 136, 34);
		contentPane.add(comboBox);
		login.addActionListener(action->{
			try {
				if (id.getText().equals("") || password.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Field should not be empty");
					return;
				}
				if (comboBox.getSelectedItem().equals("Student")) {
					Student student = database.getStudent(Integer.parseInt(id.getText()), password.getText());
					if (student != null) {
						this.setVisible(false);
						studentScreen= new StudentMenuScreen(student);
						studentScreen.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Student not found");
					}
				}
				else if (comboBox.getSelectedItem().equals("Admin")) {
					if (Integer.parseInt(id.getText()) == admin.getId() && password.getText().equals(admin.getPassword())) {
						this.setVisible(false);
						adminScreen = new AdminMenuScreen();
						adminScreen.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Admin not found (Maybe wrong password)");
					}
				}
				else if (comboBox.getSelectedItem().equals("Instructor")) 
				{
					Instructor instructor = database.getInstructor(Integer.parseInt(id.getText()), password.getText());
					if (instructor != null) {
						this.setVisible(false);
						instructorScreen = new InstructorMenuScreen(instructor);
						instructorScreen.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Instructor not found");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}