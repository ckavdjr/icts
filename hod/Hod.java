/**
 * @author Harichand Manoj
 */

package hod;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Hod {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hod window = new Hod();
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
	public Hod() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setBounds(22, 21, 66, 27);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("View Requests");
		btnNewButton.setBounds(10, 77, 190, 35);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("View Employee Details");
		btnNewButton_1.setBounds(10, 123, 190, 36);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("View Customer Details");
		btnNewButton_2.setBounds(10, 170, 190, 34);
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Assign Hod");
		btnNewButton_3.setBounds(10, 215, 190, 35);
		frame.getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Log Out");
		btnNewButton_4.setBounds(323, 11, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
	}
}
