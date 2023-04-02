package clothManufacturer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Cart_Items extends JFrame {

    private JPanel contentPane;
    private JTable table;
    DefaultTableModel model1;
    private JLabel lblTotalPrice;
    private double totalPrice = 0.0;
    private JButton btnDelete;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Cart_Items frame = new Cart_Items();
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
    public Cart_Items() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 414, 240);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Item Name", "Price", "Size", "Quantity"
                }
        ));
        scrollPane.setViewportView(table);

        JLabel lblCartItems = new JLabel("Cart Items");
        lblCartItems.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCartItems.setBounds(10, 262, 89, 14);
        contentPane.add(lblCartItems);

        JLabel lblTotal = new JLabel("Total Price:");
        lblTotal.setBounds(286, 262, 70, 14);
        contentPane.add(lblTotal);

        lblTotalPrice = new JLabel("");
        lblTotalPrice.setBounds(356, 262, 68, 14);
        contentPane.add(lblTotalPrice);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(187, 260, 89, 23);
        contentPane.add(btnDelete);
        
        
        btnDelete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	int rowIndex = table.getSelectedRow();
        	if (rowIndex >= 0) {
        	// Retrieve the item data
        	String itemName = (String) table.getValueAt(rowIndex, 0);
        	double itemPrice = (double) table.getValueAt(rowIndex, 1);
        	String itemSize = (String) table.getValueAt(rowIndex, 2);
	        
        	try {
				Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_ecommerce", "root", "admin");
				
				 String query = "DELETE FROM cart_items WHERE itemname='" + itemName + "' AND itemprice='" + itemPrice + "' AND itemsize='" + itemSize + "'";
			
				 Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnDelete, "Failed to delete item from the cart!");
                    } else {
                        JOptionPane.showMessageDialog(btnDelete, "The " + itemName + " is deleted from the cart!");
                        model1.removeRow(rowIndex);
                        totalPrice -= itemPrice;
                        lblTotalPrice.setText(String.format("%.2f", totalPrice));
                    }
                    
			}
			catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}
}); 

        
        
        
        
//
//        // ActionListener for the Delete button
//        btnDelete.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                int rowIndex = table.getSelectedRow();
//                if (rowIndex >= 0) {
//                    double deletedItemPrice = (double) table.getValueAt(rowIndex, 1);
//                    model1.removeRow(rowIndex);
//                    totalPrice -= deletedItemPrice;
//                    lblTotalPrice.setText(String.format("%.2f", totalPrice));
//                }
//            }
//        });
        
        JButton btnPurchase = new JButton("Purchase");
        btnPurchase.setBounds(94, 260, 89, 23);
        contentPane.add(btnPurchase);

        btnPurchase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder summary = new StringBuilder();
                summary.append("Items in cart:\n");
                for (int i = 0; i < model1.getRowCount(); i++) {
                    String itemName = (String) model1.getValueAt(i, 0);
                    double itemPrice = (double) model1.getValueAt(i, 1);
                    String size = (String) model1.getValueAt(i, 2);
                    summary.append("- ")
                           .append(itemName)
                           .append(" (Size: ")
                           .append(size)
                           .append(") - Rs ")
                           .append(String.format("%.2f", itemPrice))
                           .append("\n");
                }
                summary.append("Total Price: Rs ")
                       .append(String.format("%.2f", totalPrice));
                JOptionPane.showMessageDialog(contentPane, summary.toString(), "Purchase Summary", JOptionPane.INFORMATION_MESSAGE);
                
                if (JOptionPane.OK_OPTION == JOptionPane.YES_OPTION) {
                    DeliveryDetails DD = new DeliveryDetails();
                    DD.setVisible(true);
                }
            }
        });

        
        
    }

    /**
     * Add a row to the cart items table with the given data
     *
     * @param itemName  the name of the item
     * @param itemPrice the price of the item
     */
    public void addItemToCart(String itemName, double itemPrice,String size) {
		model1 = (DefaultTableModel) table.getModel();
		model1.addRow(new Object[]{itemName, itemPrice, size});
		totalPrice += itemPrice;
		lblTotalPrice.setText(String.format("%.2f", totalPrice));
	}
}


































//package clothManufacturer;
//
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JLabel;
//import java.awt.Font;
//
//public class Cart_Items extends JFrame {
//
//	private JPanel contentPane;
//	private JTable table;
//	DefaultTableModel model1;
//	private JLabel lblTotalPrice;
//	private double totalPrice = 0.0;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Cart_Items frame = new Cart_Items();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public Cart_Items() {
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBounds(100, 100, 450, 350);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(10, 11, 414, 240);
//		contentPane.add(scrollPane);
//		
//		table = new JTable();
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//				"Item Name", "Price", "Size"
//			}
//		));
//		scrollPane.setViewportView(table);
//		
//		JLabel lblCartItems = new JLabel("Cart Items");
//		lblCartItems.setFont(new Font("Tahoma", Font.BOLD, 14));
//		lblCartItems.setBounds(10, 262, 89, 14);
//		contentPane.add(lblCartItems);
//		
//		JLabel lblTotal = new JLabel("Total Price:");
//		lblTotal.setBounds(286, 262, 70, 14);
//		contentPane.add(lblTotal);
//		
//		lblTotalPrice = new JLabel("");
//		lblTotalPrice.setBounds(356, 262, 68, 14);
//		contentPane.add(lblTotalPrice);
//	}
//	
//	/**
//	 * Add a row to the cart items table with the given data
//	 * @param itemName the name of the item
//	 * @param itemPrice the price of the item
//	 */
//	public void addItemToCart(String itemName, double itemPrice,String size) {
//		model1 = (DefaultTableModel) table.getModel();
//		model1.addRow(new Object[]{itemName, itemPrice, size});
//		totalPrice += itemPrice;
//		lblTotalPrice.setText(String.format("%.2f", totalPrice));
//	}
//}




















//----------------------------------------------------------------------------------------------------


//package clothManufacturer;
//
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//
//public class Cart_Items extends JFrame {
//
//	private JPanel contentPane;
//	private JTable table;
//	DefaultTableModel model1;
//	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Cart_Items frame = new Cart_Items();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public Cart_Items() {
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(10, 11, 414, 240);
//		contentPane.add(scrollPane);
//		
//		table = new JTable();
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//				"Item Name", "Price", "Size"
//			}
//		));
//		scrollPane.setViewportView(table);
//	}
//	
//	/**
//	 * Add a row to the cart items table with the given data
//	 * @param itemName the name of the item
//	 * @param itemPrice the price of the item
//	 */
//	public void addItemToCart(String itemName, double itemPrice,String size) {
//		 model1 = (DefaultTableModel) table.getModel();
//		model1.addRow(new Object[]{itemName, itemPrice, size});
//	}
//}


//----------------------------------------------------------------------------------------------------

//package clothManufacturer;
//
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JScrollPane;
//
//public class Cart_Items extends JFrame {
//
//	private JPanel contentPane;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Cart_Items frame = new Cart_Items();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public Cart_Items() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 750, 500);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(0, 461, 738, -455);
//		contentPane.add(scrollPane);
//	}
//}