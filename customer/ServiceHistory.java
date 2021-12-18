/**
 * @author Aravind Haridas
 */
package customer;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Font;
import back_end.Component;
import back_end.PostgreOperation;

public class ServiceHistory extends JFrame {

	private static String cust_id;

	PostgreOperation pg = new PostgreOperation();

	/**
	 * Create the application.
	 */
	public ServiceHistory(String cust_id) {
		ServiceHistory.cust_id = cust_id;

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("ServiceHistory");
		setBounds(0, 0, 700, 433);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lbl_title = new JLabel("Service History");
		lbl_title.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lbl_title.setBounds(63, 21, 259, 42);
		getContentPane().add(lbl_title);

		int n = pg.getCount("SELECT COUNT(*) FROM request WHERE cust_id = ?;", cust_id);
		JPanel panel = new JPanel();
		panel.setBounds(40, 87, 620, 285);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(n, 3, 0, 10));

		Component.createServiceHistoryLabels(cust_id, panel, n);

	}

	static void openFrame(String cust_id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServiceHistory window = new ServiceHistory(cust_id);
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
					ServiceHistory window = new ServiceHistory("1"); // Login with first user
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
