package View.admin_views;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import Model.Student;
import View.LoginScreen;
public class UpdateStudent extends JFrame {
	private JPanel contentPane;
	private JTextField idTxt;
	private JTextField nameTxt;
	private JTextField passwordTxt;
	/**
	 * Create the frame.
	 */
	public UpdateStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); 
		JLabel lblNewLabel = new JLabel("Enter ID:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(35, 88, 151, 37);
		contentPane.add(lblNewLabel);
		idTxt = new JTextField();
		idTxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idTxt.setBounds(196, 88, 175, 37);
		contentPane.add(idTxt);
		idTxt.setColumns(10); 
		JLabel lblEnter = new JLabel("Enter New Name:");
		lblEnter.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnter.setBounds(35, 135, 151, 37);
		contentPane.add(lblEnter); 
		nameTxt = new JTextField();
		nameTxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameTxt.setColumns(10);
		nameTxt.setBounds(196, 135, 243, 37);
		contentPane.add(nameTxt); 
		JLabel lblNewLabel_1_1 = new JLabel("Enter New Password:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(35, 185, 151, 37);
		contentPane.add(lblNewLabel_1_1); 
		passwordTxt = new JTextField();
		passwordTxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordTxt.setColumns(10);
		passwordTxt.setBounds(196, 185, 243, 37);
		contentPane.add(passwordTxt); 
		JLabel lblNewLabel_1_1_1 = new JLabel("Enter New Department:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(35, 240, 151, 37);
		contentPane.add(lblNewLabel_1_1_1); 
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CS", "SE", "DS", "SFADA"}));
		comboBox.setBounds(196, 240, 141, 37);
		contentPane.add(comboBox);
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idTxt.getText().equals("") || nameTxt.getText().equals("") || passwordTxt.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Field is empty");
					return;
				}
				Student std = new Student(nameTxt.getText(), Integer.parseInt(idTxt.getText()), passwordTxt.getText(), comboBox.getSelectedItem().toString(), AdminMenuScreen.controller.getStudentRegisterHours(Integer.parseInt(idTxt.getText())));
				if (AdminMenuScreen.controller.modifyStudent(Integer.parseInt(idTxt.getText()), std)) {
					JOptionPane.showMessageDialog(null, "Student Data Updted");
				}
				else {
					JOptionPane.showMessageDialog(null, "Student ID not found");
				} 
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBounds(331, 291, 108, 48);
		contentPane.add(btnUpdate);
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LoginScreen.adminScreen.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(45, 291, 108, 48);
		contentPane.add(btnBack);
		JLabel lblNewLabel_1 = new JLabel("Update Student");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(139, 23, 264, 48);
		contentPane.add(lblNewLabel_1);
	}
}