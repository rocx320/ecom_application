package clothManufacturer;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;

public class Men_Women extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Men_Women frame = new Men_Women();
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
	public Men_Women() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("For whom are you shopping for?");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(261, 30, 201, 31);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(10, 70, 345, 384);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel menShopping = new JLabel("");
		ImageIcon ic1 = new ImageIcon(this.getClass().getResource("/men_style.jpg"));
		menShopping.setIcon(ic1);
		menShopping.setBounds(10, 11, 325, 362);
		panel.add(menShopping);
		
		menShopping.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)  
		    {  
		       // you can open a new frame here as
		       // i have assumed you have declared "frame" as instance variable
		       MenTopWear mtw = new MenTopWear();
		       mtw.setVisible(true);
		    }  
		});
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 51, 204));
		panel_1.setBounds(365, 70, 363, 384);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel womenShopping = new JLabel("");
		ImageIcon ic2 = new ImageIcon(this.getClass().getResource("/women_style.jpg"));
		womenShopping.setIcon(ic2);
		womenShopping.setBounds(10, 11, 343, 362);
		panel_1.add(womenShopping);
		
		womenShopping.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)  
		    {  
		       // you can open a new frame here as
		       // i have assumed you have declared "frame" as instance variable
		       FemaleWear FW = new FemaleWear();
		       FW.setVisible(true);
		    }  
		});
		
		
		
		
	}
}
