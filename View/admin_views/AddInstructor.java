package View.admin_views;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import Model.Instructor;
import Model.Student;
import View.LoginScreen;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
public class AddInstructor extends JFrame {
	private JPanel contentPane;
	private JTextField idTxt;
	private JTextField nameTxt;
	private JTextField passwordTxt;
	/**
	 * Create the frame.
	 */
	public AddInstructor() {
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
		JLabel lblEnter = new JLabel("Enter Name:");
		lblEnter.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnter.setBounds(35, 135, 151, 37);
		contentPane.add(lblEnter);
		nameTxt = new JTextField();
		nameTxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameTxt.setColumns(10);
		nameTxt.setBounds(196, 135, 243, 37);
		contentPane.add(nameTxt);
		JLabel lblNewLabel_1_1 = new JLabel("Enter Password:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(35, 185, 151, 37);
		contentPane.add(lblNewLabel_1_1);

		passwordTxt = new JTextField();
		passwordTxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordTxt.setColumns(10);
		passwordTxt.setBounds(196, 185, 243, 37);
		contentPane.add(passwordTxt);
		JLabel lblNewLabel_1_1_1 = new JLabel("Enter Department:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(35, 240, 151, 37);
		contentPane.add(lblNewLabel_1_1_1);
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CS", "SE", "DS", "SFADA"}));
		comboBox.setBounds(196, 242, 127, 37);
		contentPane.add(comboBox);
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idTxt.getText().equals("") || nameTxt.getText().equals("") || passwordTxt.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Field is empty");
					return;
				}
				Instructor ins = new Instructor(nameTxt.getText(), 
						Integer.parseInt(idTxt.getText()),
						passwordTxt.getText(), 
						comboBox.getSelectedItem().toString(), 0);
				AdminMenuScreen.controller.addInstructor(ins);
				JOptionPane.showMessageDialog(null, "Instructor Data added"); 
			}
		});
				btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnAdd.setBounds(331, 291, 108, 48);
				contentPane.add(btnAdd);
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
				JLabel lblNewLabel_1 = new JLabel("Add Instructor");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
				lblNewLabel_1.setBounds(139, 23, 264, 48);
				contentPane.add(lblNewLabel_1);
				idTxt = new JTextField();
				idTxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
				idTxt.setBounds(210, 88, 193, 37);
				contentPane.add(idTxt);
				idTxt.setColumns(10); 
	}
}