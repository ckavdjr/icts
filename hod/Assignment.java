/**
 * @author Harichand Manoj
 */
package hod;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Assignment {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Assignment window = new Assignment();
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
	public Assignment() {
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
		
		JLabel lblNewLabel = new JLabel("Assign Hod");
		lblNewLabel.setBounds(20, 33, 98, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Employee:");
		lblNewLabel_1.setBounds(20, 93, 98, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(88, 97, 180, 22);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Assign");
		btnNewButton.setBounds(232, 153, 98, 30);
		frame.getContentPane().add(btnNewButton);
	}
}
