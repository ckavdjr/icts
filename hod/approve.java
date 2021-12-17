package hod;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;

public class approve {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					approve window = new approve();
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
	public approve() {
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
		
		JLabel lblNewLabel = new JLabel("Assign to:");
		lblNewLabel.setBounds(10, 77, 90, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Approve");
		lblNewLabel_1.setBounds(10, 29, 71, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(97, 83, 116, 22);
		frame.getContentPane().add(comboBox);
	}
}
