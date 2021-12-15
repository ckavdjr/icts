/**
 * @author Dany Geo
 */

package employee;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

import back_end.PostgreOperation;
import customer.Customer;
import hod.Hod;
import login.Login;

public class Employee extends JFrame {

	private static String user_id;
	private static String emp_id;
	
	PostgreOperation pg = new PostgreOperation();

	/**
	 * Create the application.
	 */
	public Employee(String user_id) {
		Employee.user_id = user_id;
		Employee.emp_id = pg.getEmpID(user_id);

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
		lblNewLabel.setBounds(10, 21, 66, 27);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabe2 = new JLabel("Services");
		lblNewLabe2.setBounds(10, 60, 66, 27);
		getContentPane().add(lblNewLabe2);

		JLabel lblNewLabe3 = new JLabel("Service 1");
		lblNewLabe3.setBounds(10, 120, 66, 27);
		getContentPane().add(lblNewLabe3);

		JLabel lblNewLabe4 = new JLabel("Service 2");
		lblNewLabe4.setBounds(10, 160, 66, 27);
		getContentPane().add(lblNewLabe4);

		JButton btnNewButton_1 = new JButton("Complete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Service 1 completed");
			}
		});
		btnNewButton_1.setBounds(323, 120, 89, 23);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Complete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Service 2 completed");
			}
		});
		btnNewButton_2.setBounds(323, 160, 89, 23);
		getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Log Out");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login.main(null);
			}
		});
		btnNewButton_3.setBounds(323, 11, 89, 23);
		getContentPane().add(btnNewButton_3);

		JPanel panel = new JPanel();
		panel.setBounds(10, 99, 414, 119);
		getContentPane().add(panel);
	}
	
	public static void openFrame(String user_id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee window = new Employee(user_id);
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
					Employee window = new Employee("1");
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}