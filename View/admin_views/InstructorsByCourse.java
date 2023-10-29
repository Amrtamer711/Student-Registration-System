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
import Model.Instructor;
import Model.Student;
import View.LoginScreen;
public class InstructorsByCourse extends JFrame {
	private JPanel contentPane;
	private JTextField code;
	/**
	 * Create the frame.
	 */
	public InstructorsByCourse() {
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
				ArrayList<Instructor> instructors = 
						AdminMenuScreen.controller.instructorsByCourseCode(code.getText());
				String data = "";
				for (Instructor ins: instructors) {
					data += ins.toString() + "\n";
				}
				if (instructors.isEmpty()) data = "No Instructor found";
				area.setText(data); 
			}
		});
	}
}