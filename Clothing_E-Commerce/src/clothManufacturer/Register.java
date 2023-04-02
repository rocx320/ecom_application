package clothManufacturer;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField text_fullName;
	private JTextField text_phoneNumber;
	private JTextField text_email;
	private JTextField text_password;
	private JTextField text_confirmPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -11, 663, 432);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelFullName = new JLabel("Full Name:");
		labelFullName.setBounds(36, 107, 71, 14);
		contentPane.add(labelFullName);
		
		text_fullName = new JTextField();
		text_fullName.setBounds(117, 104, 96, 20);
		contentPane.add(text_fullName);
		text_fullName.setColumns(10);
		
		JLabel phoneNumber = new JLabel("Phone Number:");
		phoneNumber.setBounds(390, 110, 104, 14);
		contentPane.add(phoneNumber);
		
		text_phoneNumber = new JTextField();
		text_phoneNumber.setBounds(504, 107, 96, 20);
		contentPane.add(text_phoneNumber);
		text_phoneNumber.setColumns(10);
		
		JLabel email = new JLabel("Email:");
		email.setBounds(36, 162, 48, 14);
		contentPane.add(email);
		
		text_email = new JTextField();
		text_email.setColumns(10);
		text_email.setBounds(117, 159, 96, 20);
		contentPane.add(text_email);
		
		JLabel password = new JLabel("Password:");
		password.setBounds(390, 165, 71, 14);
		contentPane.add(password);
		
		text_password = new JTextField();
		text_password.setColumns(10);
		text_password.setBounds(504, 162, 96, 20);
		contentPane.add(text_password);
		
		JLabel confirmPassword = new JLabel("Confirm Password:");
		confirmPassword.setBounds(390, 221, 116, 14);
		contentPane.add(confirmPassword);
		
		text_confirmPassword = new JTextField();
		text_confirmPassword.setColumns(10);
		text_confirmPassword.setBounds(504, 218, 96, 20);
		contentPane.add(text_confirmPassword);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("I would like to get the newsletters and latest updates on my email.");
		chckbxNewCheckBox.setBounds(36, 275, 387, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JRadioButton maleRadioButton = new JRadioButton("Male");
		maleRadioButton.setBounds(117, 215, 60, 23);
		contentPane.add(maleRadioButton);
		
		JRadioButton femaleNewRadioButton_1 = new JRadioButton("Female");
		femaleNewRadioButton_1.setBounds(179, 215, 71, 23);
		contentPane.add(femaleNewRadioButton_1);
		
		JLabel gender = new JLabel("Gender");
		gender.setBounds(36, 219, 48, 14);
		contentPane.add(gender);
		
		JButton createAccount_btn = new JButton("CREATE");
		createAccount_btn.setBounds(287, 322, 89, 23);
		contentPane.add(createAccount_btn);
		
		JCheckBox chckbxAgreeToTerms = new JCheckBox("Agree to Terms and Conditions.");
		chckbxAgreeToTerms.setBounds(246, 367, 215, 23);
		contentPane.add(chckbxAgreeToTerms);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 0, 631, 83);
		contentPane.add(panel);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		ImageIcon ic1 = new ImageIcon(this.getClass().getResource("/vogue.jpg"));
		lblNewLabel_3_1.setIcon(ic1);
		lblNewLabel_3_1.setBounds(0, 11, 621, 61);
		panel.add(lblNewLabel_3_1);
		
		JLabel label_accountCreate = new JLabel("CREATE AN NEW ACCOUNT!!!");
		label_accountCreate.setBounds(246, 85, 215, 14);
		contentPane.add(label_accountCreate);
		
		JLabel lbl_threadTime = new JLabel("Time:");
		lbl_threadTime.setBounds(504, 371, 137, 14);
		contentPane.add(lbl_threadTime);
		
		createAccount_btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String fullName = text_fullName.getText();
				String email = text_email.getText();
				String gender = maleRadioButton.getText();
				String phoneNumber = text_phoneNumber.getText();
				int len = phoneNumber.length();
				
				String password = text_password.getText();
				
				String msg = "" + fullName;
				msg += " \n";
				if(len != 10) {
					JOptionPane.showMessageDialog(createAccount_btn, "Enter a valid mobile number");
                }
				try {
					Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_ecommerce", "root", "admin");
					
					 String query = "INSERT INTO acc_user values('" + fullName + "','"+
		                        email + "','" + gender + "','" + phoneNumber+ "','" + password + "')";
				
					 Statement sta = connection.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(createAccount_btn, "This is alredy exist");
	                    } else {
	                        JOptionPane.showMessageDialog(createAccount_btn,
	                            "Welcome, " + msg + "Your account is sucessfully created");
	                       
	                        if (JOptionPane.OK_OPTION == JOptionPane.YES_OPTION) {
	                        	Men_Women MW = new Men_Women();
	                        	MW.setVisible(true);
	                        }
	                    }
	                    
				}
				catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		
//		createAccount_btn.setFont(new Font("Tahoma", Font.PLAIN, 22));
//		createAccount_btn.setBounds(399, 447, 259, 74);
//        contentPane.add(createAccount_btn);
		}
	}
