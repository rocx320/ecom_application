package clothManufacturer;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class SignUp {

	private JFrame frame;
	private JTextField txt_userName;
	private JTextField txt_Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 663, 432);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 631, 83);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		ImageIcon ic3 = new ImageIcon(this.getClass().getResource("/vogue.jpg"));
		lblNewLabel_3.setIcon(ic3);
		lblNewLabel_3.setBounds(10, 11, 611, 61);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(181, 105, 289, 281);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setBounds(127, 5, 42, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setBounds(10, 51, 53, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setBounds(10, 109, 53, 14);
		panel_1.add(lblNewLabel_1_1);
		
		txt_userName = new JTextField();
		txt_userName.setBounds(10, 76, 132, 20);
		panel_1.add(txt_userName);
		txt_userName.setColumns(10);
		
		txt_Password = new JTextField();
		txt_Password.setColumns(10);
		txt_Password.setBounds(10, 134, 132, 20);
		panel_1.add(txt_Password);
		
		JButton btn_login = new JButton("Log In");
		btn_login.setBounds(10, 165, 89, 23);
		panel_1.add(btn_login);
		
		
		btn_login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String u_Name = txt_userName.getText();
				String u_Password = txt_Password.getText();
				String msg = "" + u_Name;
				
				try {
					Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_ecommerce", "root", "admin");
				
					PreparedStatement st = (PreparedStatement) connection
	                        .prepareStatement("Select fullname, password from acc_user where fullname=? and password=?");
					
					 st.setString(1, u_Name);
	                 st.setString(2, u_Password);
	                 
	                 ResultSet rs = st.executeQuery();
	                 
	                 if (rs.next()) {
	                        //dispose();
	                        Men_Women mw = new Men_Women();
							mw.setTitle("Welcome");
							JOptionPane.showMessageDialog(btn_login,
		                            "Welcome back, " + msg);
	                        mw.setVisible(true);
	                    } else {
	                        JOptionPane.showMessageDialog(btn_login, "Wrong Username & Password");
	                    }
				}
	             catch (SQLException sqlException) {
	                     sqlException.printStackTrace();
	                 }
			}
			});
		
		
	
		
		JLabel lblNewLabel_2 = new JLabel("New user? Create a new account to access our store!");
		lblNewLabel_2.setBounds(10, 193, 269, 42);
		panel_1.add(lblNewLabel_2);
		
		JButton btn_signup = new JButton("Sign Up");
		btn_signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register r = new Register();
				r.setVisible(true);
			}
		});
		btn_signup.setBounds(10, 236, 89, 23);
		panel_1.add(btn_signup);
//		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 105, 161, 281);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

//		
		JLabel lblNewLabel_4_1_1 = new JLabel("");
		ImageIcon ic1 = new ImageIcon(this.getClass().getResource("/men_apparel.jpg"));
		lblNewLabel_4_1_1.setIcon(ic1);
		lblNewLabel_4_1_1.setBounds(10, 11, 151, 259);
		panel_2.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("");

		lblNewLabel_4.setBounds(10, 11, 141, 259);
		panel_2.add(lblNewLabel_4);
//		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(480, 105, 161, 281);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		ImageIcon ic2 = new ImageIcon(this.getClass().getResource("/women_apparel.jpg"));
		lblNewLabel_4_1.setIcon(ic2);
		lblNewLabel_4_1.setBounds(10, 11, 141, 259);
		panel_3.add(lblNewLabel_4_1);
	}
}
