package clothManufacturer;

import java.awt.EventQueue;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class DeliveryDetails extends JFrame {

	private JPanel contentPane;
	private JTextField txt_addressLine1;
	private JTextField txt_addressLine2;
	private JTextField txt_landMark;
	private JTextField txt_district;
	private JTextField txt_state;
	private JTextField txt_pincode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeliveryDetails frame = new DeliveryDetails();
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
	public DeliveryDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 102));
		panel.setBounds(10, 11, 718, 443);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delivery Details");
		lblNewLabel.setFont(new Font("Footlight MT Light", Font.PLAIN, 14));
		lblNewLabel.setBounds(315, 11, 131, 14);
		panel.add(lblNewLabel);
		
		JLabel addressLine1 = new JLabel("Address Line 1:");
		addressLine1.setBounds(204, 65, 101, 14);
		panel.add(addressLine1);
		
		txt_addressLine1 = new JTextField();
		txt_addressLine1.setBounds(315, 62, 198, 36);
		panel.add(txt_addressLine1);
		txt_addressLine1.setColumns(10);
		
		JLabel addressLine2 = new JLabel("Address Line 2:");
		addressLine2.setBounds(204, 131, 101, 14);
		panel.add(addressLine2);
		
		txt_addressLine2 = new JTextField();
		txt_addressLine2.setColumns(10);
		txt_addressLine2.setBounds(315, 128, 198, 36);
		panel.add(txt_addressLine2);
		
		JLabel landMark = new JLabel("LandMark");
		landMark.setBounds(204, 200, 58, 14);
		panel.add(landMark);
		
		txt_landMark = new JTextField();
		txt_landMark.setBounds(260, 197, 96, 20);
		panel.add(txt_landMark);
		txt_landMark.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("");
		ImageIcon ic1 = new ImageIcon(this.getClass().getResource("/addressImg.jpg"));
		lblNewLabel_3.setIcon(ic1);
		lblNewLabel_3.setBounds(10, 37, 184, 395);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		ImageIcon ic2 = new ImageIcon(this.getClass().getResource("/addressImg2.jpg"));
		lblNewLabel_4.setIcon(ic2);
		lblNewLabel_4.setBounds(524, 37, 184, 395);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("District");
		lblNewLabel_5.setBounds(366, 200, 48, 14);
		panel.add(lblNewLabel_5);
		
		txt_district = new JTextField();
		txt_district.setBounds(424, 197, 96, 20);
		panel.add(txt_district);
		txt_district.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("State");
		lblNewLabel_2_1.setBounds(204, 258, 58, 14);
		panel.add(lblNewLabel_2_1);
		
		txt_state = new JTextField();
		txt_state.setColumns(10);
		txt_state.setBounds(260, 255, 96, 20);
		panel.add(txt_state);
		
		JLabel lblNewLabel_2_2 = new JLabel("Pincode");
		lblNewLabel_2_2.setBounds(366, 258, 58, 14);
		panel.add(lblNewLabel_2_2);
		
		txt_pincode = new JTextField();
		txt_pincode.setColumns(10);
		txt_pincode.setBounds(424, 255, 96, 20);
		panel.add(txt_pincode);
		
		JButton btn_order = new JButton("Order");
		btn_order.setBounds(315, 360, 89, 23);
		panel.add(btn_order);
		
		btn_order.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
		        String addLine1 = txt_addressLine1.getText();
		        String addLine2 = txt_addressLine2.getText();
		        String lndMark = txt_landMark.getText();
		        String district = txt_district.getText();
		        String state = txt_state.getText();
		        String pincode = txt_pincode.getText();

		        int len = pincode.length();

		        if(len != 6) {
		            JOptionPane.showMessageDialog(btn_order, "Enter a valid pincode");
		            return;
		        }
		        try {
		            Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_ecommerce", "root", "admin");

		            String query = "INSERT INTO delivery_address (address1, address2, landmark, district, state, pincode) VALUES ('" + addLine1 + "','" + addLine2 + "','" + lndMark + "','" + district + "','" + state + "','" + pincode + "')";

		            Statement sta = connection.createStatement();
		            sta.executeUpdate(query);
		            JOptionPane.showMessageDialog(btn_order, "Thank You for ordering!!!");
		        }
		        catch (Exception exception) {
		            exception.printStackTrace();
		        }
		    }
		});	
		
	}
}
