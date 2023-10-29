package View.admin_views;
import com.toedter.calendar.JDateChooser;
import Model.Course;
import View.LoginScreen;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
public class AddCourse extends JFrame {
	private JPanel contentPane;
	private JTextField code;
	private JTextField name;
	private JTextField ch;
	private JTextField section;
	private JTextField time;
	private JTextField limit;
	private JTextField roomNo;
	/**
	 * Create the frame.
	 */
	public AddCourse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Add Course");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(215, 26, 193, 52);
		contentPane.add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("Enter Code");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 105, 130, 36);
		contentPane.add(lblNewLabel_1);
		code = new JTextField();
		code.setFont(new Font("Tahoma", Font.PLAIN, 14));
		code.setBounds(150, 105, 96, 36);
		contentPane.add(code);
		code.setColumns(10);
		JLabel lblNewLabel_1_1 = new JLabel("Enter Name");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(278, 105, 130, 36);
		contentPane.add(lblNewLabel_1_1);
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		name.setColumns(10);
		name.setBounds(418, 105, 171, 36);
		contentPane.add(name);
		JLabel lblNewLabel_1_2 = new JLabel("Credit Hours");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 159, 130, 36);
		contentPane.add(lblNewLabel_1_2);
		ch = new JTextField();
		ch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ch.setColumns(10);
		ch.setBounds(150, 159, 96, 36);
		contentPane.add(ch);
		section = new JTextField();
		section.setFont(new Font("Tahoma", Font.PLAIN, 14));
		section.setColumns(10);
		section.setBounds(150, 217, 96, 36);
		contentPane.add(section);
		JLabel lblNewLabel_1_2_1 = new JLabel("Section");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(10, 216, 130, 36);
		contentPane.add(lblNewLabel_1_2_1);
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Time");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1.setBounds(278, 217, 130, 36);
		contentPane.add(lblNewLabel_1_2_1_1);
		time = new JTextField();
		time.setFont(new Font("Tahoma", Font.PLAIN, 14));
		time.setColumns(10);
		time.setBounds(418, 217, 171, 36);
		contentPane.add(time);
		JLabel lblNewLabel_1_1_1 = new JLabel("Department");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(278, 159, 130, 36);
		contentPane.add(lblNewLabel_1_1_1);
		JDateChooser startDate = new JDateChooser();
		startDate.setBounds(418, 273, 171, 36);
		contentPane.add(startDate);
		JDateChooser endDate = new JDateChooser();
		endDate.setBounds(418, 323, 171, 36);
		contentPane.add(endDate);
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Start Date");
		lblNewLabel_1_2_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1_1.setBounds(278, 273, 130, 36);
		contentPane.add(lblNewLabel_1_2_1_1_1);
		JLabel lblNewLabel_1_2_1_1_2 = new JLabel("End Date");
		lblNewLabel_1_2_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1_2.setBounds(278, 323, 130, 36);
		contentPane.add(lblNewLabel_1_2_1_1_2);
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Student Limit");
		lblNewLabel_1_2_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_2.setBounds(10, 273, 130, 36);
		contentPane.add(lblNewLabel_1_2_1_2);
		limit = new JTextField();
		limit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		limit.setColumns(10);
		limit.setBounds(150, 273, 96, 36);
		contentPane.add(limit);
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LoginScreen.adminScreen.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(150, 380, 96, 36);
		contentPane.add(btnBack);
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.setBounds(453, 380, 96, 36);
		contentPane.add(btnAdd);
		JLabel lblNewLabel_1_2_1_2_1 = new JLabel("Room Number");
		lblNewLabel_1_2_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_2_1.setBounds(10, 323, 130, 36);
		contentPane.add(lblNewLabel_1_2_1_2_1);
		roomNo = new JTextField();
		roomNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		roomNo.setColumns(10);
		roomNo.setBounds(150, 323, 96, 36);
		contentPane.add(roomNo);
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "CS", "SE", "DS", "SFADA" }));
		comboBox.setBounds(428, 159, 161, 36);
		contentPane.add(comboBox);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (code.getText().equals("") || name.getText().equals("") || ch.getText().equals("") || section.getText().equals("") || time.getText().equals("") || limit.getText().equals("")|| startDate == null || endDate == null || roomNo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Field is empty");
					return;
				}
				Course course = new Course(code.getText(), name.getText(), Integer.parseInt(ch.getText()), section.getText(), time.getText(), Integer.parseInt(roomNo.getText()), comboBox.getSelectedItem().toString(), -1, 0, Integer.parseInt(limit.getText()), startDate.getDate().toInstant().atZone(ZoneId.of("Asia/Dubai")).toLocalDate(), endDate.getDate().toInstant().atZone(ZoneId.of("Asia/Dubai")).toLocalDate());
				AdminMenuScreen.controller.addCourse(course);
				JOptionPane.showMessageDialog(null, "Course Added");
			}
		});
	}
}