/**
 * @author Harichand Manoj
 */
package hod;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import back_end.PostgreOperation;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Approval {

	private JFrame frame;
	Connection c = null;
	Statement stmt = null;
	ResultSet rs = null;
	String sql = null;
	PreparedStatement ps = null;
	PostgreOperation pg = new PostgreOperation();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Approval window = new Approval();
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
	public Approval() {
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

		JLabel lblNewLabel_1 = new JLabel("Approve Pending Requests");
		lblNewLabel_1.setBounds(10, 29, 179, 37);
		frame.getContentPane().add(lblNewLabel_1);

		String names[] = pg.getPending();
		JComboBox comboBox = new JComboBox(names);
		comboBox.setBounds(97, 83, 116, 22);
		frame.getContentPane().add(comboBox);

		JButton btnNewButton = new JButton("Approve");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Approved");
			}
		});
		btnNewButton.setBounds(261, 134, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
