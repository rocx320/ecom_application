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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import java.awt.Color;
import javax.swing.JRadioButton;

public class MenTopWear extends JFrame {	

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenTopWear frame = new MenTopWear();
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
	public MenTopWear() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Cart_Items cartItemsFrame = new Cart_Items(); 
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 67, 728, 196);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setBackground(new Color(240, 240, 240));
		ImageIcon ic1 = new ImageIcon(this.getClass().getResource("/men_shirt.jpg"));
		lblNewLabel.setIcon(ic1);
		lblNewLabel.setBounds(10, 11, 129, 98);
		panel.add(lblNewLabel);
//		lblNewLabel.setForeground(Color.RED);
//		lblNewLabel.setBackground(new Color(0, 0, 255));
		
		JLabel lblShirts = new JLabel(""); //jacket
		ImageIcon ic4 = new ImageIcon(this.getClass().getResource("/men_jacket.jpg"));
		lblShirts.setIcon(ic4);
//		lblShirts.setForeground(Color.YELLOW);
//		lblShirts.setBackground(Color.BLUE);
		lblShirts.setBounds(205, 11, 129, 98);
		panel.add(lblShirts);
		
		JLabel lblShirts_2 = new JLabel("");
		ImageIcon ic2 = new ImageIcon(this.getClass().getResource("/men_sweatshirt.jpg"));
		lblShirts_2.setIcon(ic2);
//		lblShirts_2.setForeground(Color.BLUE);
//		lblShirts_2.setBackground(Color.BLUE);
		lblShirts_2.setBounds(380, 11, 129, 98);
		panel.add(lblShirts_2);
		
		JLabel lblShirts_3 = new JLabel("");
		ImageIcon ic7 = new ImageIcon(this.getClass().getResource("/men_belt.jpg"));
		lblShirts_3.setIcon(ic7);
//		lblShirts_3.setForeground(Color.MAGENTA);
//		lblShirts_3.setBackground(Color.BLUE);
		lblShirts_3.setBounds(560, 11, 129, 98);
		panel.add(lblShirts_3);
		
		JRadioButton shirt_S_size = new JRadioButton("S");
		shirt_S_size.setBounds(20, 116, 35, 20);
		panel.add(shirt_S_size);
		
		JRadioButton shirt_M_size = new JRadioButton("M");
		shirt_M_size.setBounds(59, 116, 40, 20);
		panel.add(shirt_M_size);
		
		JRadioButton shirt_L_size = new JRadioButton("L");
		shirt_L_size.setBounds(104, 116, 35, 20);
		panel.add(shirt_L_size);
		
		JButton addToCart_btn_shirt = new JButton("Add to cart");
		addToCart_btn_shirt.setBounds(30, 143, 101, 23);
		panel.add(addToCart_btn_shirt);
		
		addToCart_btn_shirt.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Retrieve the item data
		        String itemName = "Shirt";
		        double itemPrice = 1500;
		        String size_Shirt ="";
		        
		        if (shirt_S_size.isSelected()) {
		            size_Shirt = "S";
		            shirt_M_size.setEnabled(false);
		            shirt_L_size.setEnabled(false);
		        } else if (shirt_M_size.isSelected()) {
		            size_Shirt = "M";
		            shirt_S_size.setEnabled(false);
		            shirt_L_size.setEnabled(false);
		        } else if (shirt_L_size.isSelected()) {
		            size_Shirt = "L";
		            shirt_S_size.setEnabled(false);
		            shirt_M_size.setEnabled(false);
		        } else {
		            JOptionPane.showMessageDialog(addToCart_btn_shirt,
		                "Please select a size!");
		            return;
		        }
		        
		        try {
		            Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_ecommerce", "root", "admin");
		            
		            String query = "INSERT INTO cart_items values('" + itemName + "','"+
		                    itemPrice + "','" + size_Shirt + "')";
		    
		            Statement sta = connection.createStatement();
		            int x = sta.executeUpdate(query);
		            if (x == 0) {
		                JOptionPane.showMessageDialog(addToCart_btn_shirt, "This is already exist");
		            } else {
		                JOptionPane.showMessageDialog(addToCart_btn_shirt,
		                    "The " + itemName + " is added to cart!");
		            }
		            
		        } catch (Exception exception) {
		            exception.printStackTrace();
		        }
		        
		        cartItemsFrame.addItemToCart(itemName, itemPrice, size_Shirt);
		        //cartItemsFrame.updateTable();
		        cartItemsFrame.setVisible(true);
		    }
		});
		        

		        //Cart_Items cart_shirt = new Cart_Items();
		
		
		
		JRadioButton sweatshirt_S_size = new JRadioButton("S");
		sweatshirt_S_size.setBounds(390, 116, 35, 20);
		panel.add(sweatshirt_S_size);
		
		JRadioButton sweatshirt_M_size = new JRadioButton("M");
		sweatshirt_M_size.setBounds(429, 116, 40, 20);
		panel.add(sweatshirt_M_size);
		
		JRadioButton sweatshirt_L_size = new JRadioButton("L");
		sweatshirt_L_size.setBounds(471, 116, 35, 20);
		panel.add(sweatshirt_L_size);
		
		JButton addToCart_Sweatshirt = new JButton("Add to cart");
		addToCart_Sweatshirt.setBounds(400, 143, 101, 23);
		panel.add(addToCart_Sweatshirt);
		
		addToCart_Sweatshirt.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Retrieve the item data
		        String itemName = "Sweatshirt";
		        double itemPrice = 2500;
		        String size_Sweatshirt ="";
		        
		        if (sweatshirt_S_size.isSelected()) {
		        	size_Sweatshirt = "S";
                } else if (sweatshirt_M_size.isSelected()) {
                	size_Sweatshirt = "M";
                } else if (sweatshirt_L_size.isSelected()) {
                	size_Sweatshirt = "L";
                }

		        try {
					Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_ecommerce", "root", "admin");
					
					 String query = "INSERT INTO cart_items values('" + itemName + "','"+
							 itemPrice + "','" + size_Sweatshirt + "')";
				
					 Statement sta = connection.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(addToCart_btn_shirt, "This item alredy exist");
	                    } else {
	                        JOptionPane.showMessageDialog(addToCart_btn_shirt,
	                            "The " + itemName + " is added to cart!");
	                    }
	                    
				}
				catch (Exception exception) {
					exception.printStackTrace();
				}
		        

		        //Cart_Items cart_shirt = new Cart_Items();
		        cartItemsFrame.addItemToCart(itemName, itemPrice, size_Sweatshirt);
		        cartItemsFrame.setVisible(true);
		    }
		});
		
		
		
		JRadioButton belt_S_size = new JRadioButton("S");
		belt_S_size.setBounds(570, 116, 35, 20);
		panel.add(belt_S_size);
		
		JRadioButton belt_M_size = new JRadioButton("M");
		belt_M_size.setBounds(609, 116, 40, 20);
		panel.add(belt_M_size);
		
		JRadioButton belt_L_size = new JRadioButton("L");
		belt_L_size.setBounds(651, 116, 35, 20);
		panel.add(belt_L_size);
		
		JButton addToCart_Belt = new JButton("Add to cart");
		addToCart_Belt.setBounds(580, 143, 101, 23);
		panel.add(addToCart_Belt);
		
		
		addToCart_Belt.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Retrieve the item data
		        String itemName = "Belt";
		        double itemPrice = 1000;
		        String size_Belt ="";
		        
		        if (belt_S_size.isSelected()) {
		        	size_Belt = "S";
                } else if (belt_M_size.isSelected()) {
                	size_Belt = "M";
                } else if (belt_L_size.isSelected()) {
                	size_Belt = "L";
                }
		        
		        try {
					Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_ecommerce", "root", "admin");
					
					 String query = "INSERT INTO cart_items values('" + itemName + "','"+
							 itemPrice + "','" + size_Belt + "')";
				
					 Statement sta = connection.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(addToCart_btn_shirt, "This item alredy exist");
	                    } else {
	                        JOptionPane.showMessageDialog(addToCart_btn_shirt,
	                            "The " + itemName + " is added to cart!");
	                    }
	                    
				}
				catch (Exception exception) {
					exception.printStackTrace();
				}
		        

		        //Cart_Items cart_shirt = new Cart_Items();
		        cartItemsFrame.addItemToCart(itemName, itemPrice, size_Belt);
		        cartItemsFrame.setVisible(true);
		    }
		});		
		
		JRadioButton jacket_S_size = new JRadioButton("S");
		jacket_S_size.setBounds(215, 116, 35, 20);
		panel.add(jacket_S_size);
		
		JRadioButton jacket_M_size = new JRadioButton("M");
		jacket_M_size.setBounds(254, 116, 40, 20);
		panel.add(jacket_M_size);
		
		JRadioButton jacket_L_size = new JRadioButton("L");
		jacket_L_size.setBounds(296, 116, 35, 20);
		panel.add(jacket_L_size);
		
		JButton addToCart_Jacket = new JButton("Add to cart");
		addToCart_Jacket.setBounds(225, 143, 101, 23);
		panel.add(addToCart_Jacket);
		
		addToCart_Jacket.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
//		         Retrieve the item data
		        String itemName = "Jacket";
		        double itemPrice = 3500;
		        String size_Jacket ="";
		        
		        if (jacket_S_size.isSelected()) {
		        	size_Jacket = "S";
                } else if (jacket_M_size.isSelected()) {
                	size_Jacket = "M";
                } else if (jacket_L_size.isSelected()) {
                	size_Jacket = "L";
                }
		        
		        try {
					Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_ecommerce", "root", "admin");
					
					 String query = "INSERT INTO cart_items values('" + itemName + "','"+
							 itemPrice + "','" + size_Jacket + "')";
				
					 Statement sta = connection.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(addToCart_btn_shirt, "This item alredy exist");
	                    } else {
	                        JOptionPane.showMessageDialog(addToCart_btn_shirt,
	                            "The " + itemName + " is added to cart!");
	                    }
	                    
				}
				catch (Exception exception) {
					exception.printStackTrace();
				}
		        

		        //Cart_Items cart_shirt = new Cart_Items();
		        cartItemsFrame.addItemToCart(itemName, itemPrice, size_Jacket);
		        cartItemsFrame.setVisible(true);
		    }
		});

		
		
		JLabel lblNewLabel_5 = new JLabel("Rs. 1500/-");
		lblNewLabel_5.setForeground(Color.BLUE);
		lblNewLabel_5.setBounds(51, 177, 64, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Rs. 3500/-");
		lblNewLabel_5_1.setForeground(Color.BLUE);
		lblNewLabel_5_1.setBounds(235, 177, 64, 14);
		panel.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("Rs. 2500/-");
		lblNewLabel_5_2.setForeground(Color.BLUE);
		lblNewLabel_5_2.setBounds(420, 177, 64, 14);
		panel.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("Rs. 1000/-");
		lblNewLabel_5_3.setBounds(609, 177, 64, 14);
		panel.add(lblNewLabel_5_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(0, 267, 728, 187);
		contentPane.add(panel_1);
		
		JLabel lblTshirts = new JLabel("");		//T shirt
		ImageIcon ic3 = new ImageIcon(this.getClass().getResource("/men_t-shirt.jpg"));
		lblTshirts.setIcon(ic3);
		lblTshirts.setForeground(Color.RED);
		lblTshirts.setBackground(Color.BLUE);
		lblTshirts.setBounds(10, 11, 129, 98);
		panel_1.add(lblTshirts);
		
		JLabel lblTshirts_1 = new JLabel(""); //coat
		ImageIcon ic5 = new ImageIcon(this.getClass().getResource("/men_coat.jpg"));
		lblTshirts_1.setIcon(ic5);
//		lblTshirts_1.setForeground(Color.YELLOW);
//		lblTshirts_1.setBackground(Color.BLUE);
		lblTshirts_1.setBounds(199, 11, 129, 98);
		panel_1.add(lblTshirts_1);
		
		JLabel lblShirts_2_1 = new JLabel("");
		ImageIcon ic6 = new ImageIcon(this.getClass().getResource("/men_sweater.jpg"));
		lblShirts_2_1.setIcon(ic6);
//		lblShirts_2_1.setForeground(Color.CYAN);
//		lblShirts_2_1.setBackground(Color.BLUE);
		lblShirts_2_1.setBounds(387, 11, 129, 98);
		panel_1.add(lblShirts_2_1);
		
		JLabel lblShirts_3_1 = new JLabel("");
		ImageIcon ic8 = new ImageIcon(this.getClass().getResource("/men_watch.jpg"));
		lblShirts_3_1.setIcon(ic8);
//		lblShirts_3_1.setForeground(Color.MAGENTA);
//		lblShirts_3_1.setBackground(Color.BLUE);
		lblShirts_3_1.setBounds(560, 11, 129, 98);
		panel_1.add(lblShirts_3_1);
		
		JRadioButton t_shirt_S_size = new JRadioButton("S");
		t_shirt_S_size.setBounds(20, 116, 35, 20);
		panel_1.add(t_shirt_S_size);
		
		JRadioButton t_shirt_M_size = new JRadioButton("M");
		t_shirt_M_size.setBounds(59, 116, 40, 20);
		panel_1.add(t_shirt_M_size);
		
		JRadioButton t_shirt_L_size = new JRadioButton("L");
		t_shirt_L_size.setBounds(104, 116, 35, 20);
		panel_1.add(t_shirt_L_size);
		
		JButton addToCart_tShirt = new JButton("Add to cart");
		addToCart_tShirt.setBounds(30, 143, 101, 23);
		panel_1.add(addToCart_tShirt);
		
		addToCart_tShirt.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
//		         Retrieve the item data
		        String itemName = "T-Shirt";
		        double itemPrice = 1500;
		        String size_tShirt ="";
		        
		        if (t_shirt_S_size.isSelected()) {
		        	size_tShirt = "S";
                } else if (t_shirt_M_size.isSelected()) {
                	size_tShirt = "M";
                } else if (t_shirt_L_size.isSelected()) {
                	size_tShirt = "L";
                }
		        

		        try {
					Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_ecommerce", "root", "admin");
					
					 String query = "INSERT INTO cart_items values('" + itemName + "','"+
							 itemPrice + "','" + size_tShirt + "')";
				
					 Statement sta = connection.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(addToCart_btn_shirt, "This item alredy exist");
	                    } else {
	                        JOptionPane.showMessageDialog(addToCart_btn_shirt,
	                            "The " + itemName + " is added to cart!");
	                    }
	                    
				}
				catch (Exception exception) {
					exception.printStackTrace();
				}
		        

		        //Cart_Items cart_shirt = new Cart_Items();
		        cartItemsFrame.addItemToCart(itemName, itemPrice, size_tShirt);
		        cartItemsFrame.setVisible(true);
		    }
		});		
		
		JRadioButton coat_S_size = new JRadioButton("S");
		coat_S_size.setBounds(209, 116, 35, 20);
		panel_1.add(coat_S_size);
		
		JRadioButton coat_M_size = new JRadioButton("M");
		coat_M_size.setBounds(248, 116, 40, 20);
		panel_1.add(coat_M_size);
		
		JRadioButton coat_L_size = new JRadioButton("L");
		coat_L_size.setBounds(293, 116, 35, 20);
		panel_1.add(coat_L_size);
		
		JButton addToCart_Coat = new JButton("Add to cart");
		addToCart_Coat.setBounds(209, 143, 101, 23);
		panel_1.add(addToCart_Coat);
		
		addToCart_Coat.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
//		         Retrieve the item data
		        String itemName = "Coat";
		        double itemPrice = 2500;
		        String size_Coat ="";
		        
		        if (coat_S_size.isSelected()) {
		        	size_Coat = "S";
                } else if (coat_M_size.isSelected()) {
                	size_Coat = "M";
                } else if (coat_L_size.isSelected()) {
                	size_Coat = "L";
                }

		        try {
					Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_ecommerce", "root", "admin");
					
					 String query = "INSERT INTO cart_items values('" + itemName + "','"+
							 itemPrice + "','" + size_Coat + "')";
				
					 Statement sta = connection.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(addToCart_btn_shirt, "This item alredy exist");
	                    } else {
	                        JOptionPane.showMessageDialog(addToCart_btn_shirt,
	                            "The " + itemName + " is added to cart!");
	                    }
	                    
				}
				catch (Exception exception) {
					exception.printStackTrace();
				}
		        

		        //Cart_Items cart_shirt = new Cart_Items();
		        cartItemsFrame.addItemToCart(itemName, itemPrice, size_Coat);
		        cartItemsFrame.setVisible(true);
		    }
		});		
		
		
		JRadioButton sweater_S_size = new JRadioButton("S");
		sweater_S_size.setBounds(387, 116, 35, 20);
		panel_1.add(sweater_S_size);
		
		JRadioButton sweater_M_size = new JRadioButton("M");
		sweater_M_size.setBounds(426, 116, 40, 20);
		panel_1.add(sweater_M_size);
		
		JRadioButton sweater_L_size = new JRadioButton("L");
		sweater_L_size.setBounds(471, 116, 35, 20);
		panel_1.add(sweater_L_size);
		
		JButton addToCart_Sweater = new JButton("Add to cart");
		addToCart_Sweater.setBounds(387, 143, 101, 23);
		panel_1.add(addToCart_Sweater);
		
		addToCart_Sweater.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
//		         Retrieve the item data
		        String itemName = "Sweater";
		        double itemPrice = 2500;
		        String size_Sweater ="";
		        
		        if (sweater_S_size.isSelected()) {
		        	size_Sweater = "S";
                } else if (sweater_M_size.isSelected()) {
                	size_Sweater = "M";
                } else if (sweater_L_size.isSelected()) {
                	size_Sweater = "L";
                }

		        try {
					Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_ecommerce", "root", "admin");
					
					 String query = "INSERT INTO cart_items values('" + itemName + "','"+
							 itemPrice + "','" + size_Sweater + "')";
				
					 Statement sta = connection.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(addToCart_btn_shirt, "This item alredy exist");
	                    } else {
	                        JOptionPane.showMessageDialog(addToCart_btn_shirt,
	                            "The " + itemName + " is added to cart!");
	                    }
	                    
				}
				catch (Exception exception) {
					exception.printStackTrace();
				}
		        

		        //Cart_Items cart_shirt = new Cart_Items();
		        cartItemsFrame.addItemToCart(itemName, itemPrice, size_Sweater);
		        cartItemsFrame.setVisible(true);
		    }
		});	
		
		
		
		JButton addToCart_Watch = new JButton("Add to cart");
		addToCart_Watch.setBounds(560, 135, 101, 23);
		panel_1.add(addToCart_Watch);
		
		addToCart_Watch.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
//		         Retrieve the item data
		        String itemName = "Watch";
		        double itemPrice = 3500;
		        String size_Watch ="Standard";
		        
		        try {
					Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_ecommerce", "root", "admin");
					
					 String query = "INSERT INTO cart_items values('" + itemName + "','"+
							 itemPrice + "','" + size_Watch + "')";
				
					 Statement sta = connection.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(addToCart_btn_shirt, "This item alredy exist");
	                    } else {
	                        JOptionPane.showMessageDialog(addToCart_btn_shirt,
	                            "The " + itemName + " is added to cart!");
	                    }
	                    
				}
				catch (Exception exception) {
					exception.printStackTrace();
				}
		        

		        //Cart_Items cart_shirt = new Cart_Items();
		        cartItemsFrame.addItemToCart(itemName, itemPrice, size_Watch);
		        cartItemsFrame.setVisible(true);
		    }
		});

		
		
		
		
		
		
		JLabel lblNewLabel_5_4 = new JLabel("Rs. 1500/-");
		lblNewLabel_5_4.setForeground(Color.CYAN);
		lblNewLabel_5_4.setBounds(48, 169, 64, 14);
		panel_1.add(lblNewLabel_5_4);
		
		JLabel lblNewLabel_5_5 = new JLabel("Rs. 3000/-");
		lblNewLabel_5_5.setForeground(Color.CYAN);
		lblNewLabel_5_5.setBounds(233, 169, 64, 14);
		panel_1.add(lblNewLabel_5_5);
		
		JLabel lblNewLabel_5_6 = new JLabel("Rs. 2500/-");
		lblNewLabel_5_6.setForeground(Color.CYAN);
		lblNewLabel_5_6.setBounds(410, 169, 64, 14);
		panel_1.add(lblNewLabel_5_6);
		
		JLabel lblNewLabel_5_7 = new JLabel("Rs. 3500/-");
		lblNewLabel_5_7.setForeground(Color.CYAN);
		lblNewLabel_5_7.setBounds(581, 169, 64, 14);
		panel_1.add(lblNewLabel_5_7);
		
		JLabel lblNewLabel_1 = new JLabel("Shirts/T-shirt");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(37, 26, 116, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Jackets/Coats");
		lblNewLabel_2.setForeground(Color.YELLOW);
		lblNewLabel_2.setBounds(215, 26, 90, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sweatshirts/Sweater");
		lblNewLabel_3.setForeground(Color.CYAN);
		lblNewLabel_3.setBounds(390, 26, 128, 14);
		contentPane.add(lblNewLabel_3);
		
//		JLabel lblNewLabel_6 = new JLabel("");
//		ImageIcon ic9 = new ImageIcon(this.getClass().getResource("/bag.png"));
//		lblNewLabel_6.setIcon(ic9);
////		lblNewLabel_6.setBackground(Color.WHITE);
//		lblNewLabel_6.setBounds(675, 11, 53, 45);
//		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_4 = new JLabel("Accessories");
		lblNewLabel_4.setForeground(Color.MAGENTA);
		lblNewLabel_4.setBounds(565, 26, 82, 14);
		contentPane.add(lblNewLabel_4);
		
		
	}
}
