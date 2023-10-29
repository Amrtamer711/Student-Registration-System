package View.admin_views;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import View.LoginScreen;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Remove extends JFrame {
	private JPanel contentPane;
	private JTextField id;
	/**
	 * Create the frame.
	 */
	public Remove() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); 
		JLabel lblNewLabel = new JLabel("Remove Student");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(134, 63, 242, 41);
		contentPane.add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("Enter ID/Code to remove");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 148, 170, 43);
		contentPane.add(lblNewLabel_1);
		id = new JTextField();
		id.setBounds(190, 150, 140, 41);
		contentPane.add(id);
		id.setColumns(10);
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] 
				{"Student", "Instructor", "Course"}));
		comboBox.setBounds(361, 150, 122, 41);
		contentPane.add(comboBox);
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Field is empty");
					return;
				}
				if(comboBox.getSelectedItem().equals("Student")) {

					if(AdminMenuScreen.controller.removeStudent(Integer.parseInt(id.getText()))) {
						JOptionPane.showMessageDialog(null, "Student deleted");
					}
					else {
						JOptionPane.showMessageDialog(null, "Student not found");
					}
				}
				else if(comboBox.getSelectedItem().equals("Instructor")) 
				{

					if(AdminMenuScreen.controller.removeInstructor(Integer.parseInt(id.getText
							()))) {
						JOptionPane.showMessageDialog(null, "Instructor deleted");
					}
					else {
						JOptionPane.showMessageDialog(null, "Instructor not found");
					} 
				}
				else {
					if(AdminMenuScreen.controller.removeCourse(id.getText())) {
						JOptionPane.showMessageDialog(null, "Course deleted");
					}
					else {
						JOptionPane.showMessageDialog(null, "Course not found");
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(190, 234, 140, 41);
		contentPane.add(btnNewButton);
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LoginScreen.adminScreen.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(190, 291, 140, 41);
		contentPane.add(btnBack);
	}
}