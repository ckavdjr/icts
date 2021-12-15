/**
 * @author Harichand Manoj
 */

package hod;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import back_end.PostgreOperation;
import customer.Customer;
import login.Login;

import javax.swing.JButton;

public class Hod extends JFrame {

	private static String user_id;
	private static String hod_id;
	
	PostgreOperation pg = new PostgreOperation();

	/**
	 * Create the application.
	 */
	public Hod(String user_id) {
		Hod.user_id = user_id;
		Hod.hod_id = pg.getHodID(user_id);
		
		initialize();
	}

	/**
	 * Initialize the contents of the 
	 */
	private void initialize() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setBounds(22, 21, 66, 27);
		getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("View Requests");
		btnNewButton.setBounds(10, 77, 190, 35);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("View Employee Details");
		btnNewButton_1.setBounds(10, 123, 190, 36);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("View Customer Details");
		btnNewButton_2.setBounds(10, 170, 190, 34);
		getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Assign Hod");
		btnNewButton_3.setBounds(10, 215, 190, 35);
		getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Log Out");
		btnNewButton_4.setBounds(323, 11, 89, 23);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login.main(null);
			}
		});
		getContentPane().add(btnNewButton_4);
	}
	
	public static void openFrame(String user_id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hod window = new Hod(user_id);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hod window = new Hod("1");  // Login with first user
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
