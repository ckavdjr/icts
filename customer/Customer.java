package customer;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Font;

import back_end.Component;
import back_end.PostgreOperation;

public class Customer extends JFrame {

	private JLabel[] service;
	private JLabel[] price;
	private static String user_id;

	PostgreOperation pg = new PostgreOperation();

	/**
	 * Create the application.
	 */
	public Customer(String user_id) {
		Customer.user_id = user_id;

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Customer");
		setBounds(0, 0, 1000, 618);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		String msg = "Welcome, " + pg.getName(user_id);
		;
		JLabel lbl_welcome = new JLabel(msg);
		lbl_welcome.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lbl_welcome.setBounds(122, 27, 431, 61);
		getContentPane().add(lbl_welcome);

		JButton btn_logout = new JButton("Logout");
		btn_logout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_logout.addActionListener(new ActionListener() { // TODO: Logout button
			public void actionPerformed(ActionEvent e) {
				// System.out.println("Logged out");
			}
		});
		btn_logout.setBounds(765, 41, 130, 44);
		getContentPane().add(btn_logout);

		JButton btn_service_history = new JButton("Service History");
		btn_service_history.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_service_history.addActionListener(new ActionListener() { // TODO: Service history button
			public void actionPerformed(ActionEvent e) {
				// System.out.println("Service History");
			}
		});
		btn_service_history.setBounds(384, 494, 237, 61);
		getContentPane().add(btn_service_history);

		JLabel lbl_services = new JLabel("Services");
		lbl_services.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lbl_services.setBounds(63, 121, 209, 61);
		getContentPane().add(lbl_services);

		int n = pg.getCount("SELECT COUNT(*) FROM services;"); // Number of records in DB
		service = new JLabel[n];
		price = new JLabel[n];

		JPanel panel = new JPanel();
		panel.setBounds(24, 193, 937, 269);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(n, 3, 0, 10));
		panel.getComponentOrientation();

		for (int i = 0; i < n; i++) {
			String serv_id = pg.getServiceID(i);
			/*
			 * service[i] = new JLabel("Service " + i); service[i].setFont(new
			 * Font("Tahoma", Font.BOLD, 21)); panel.add(service[i]); price[i] = new
			 * JLabel("Price " + i); price[i].setFont(new Font("Tahoma", Font.BOLD, 21));
			 * panel.add(price[i]);
			 */
			Component.createServiceLabel(serv_id, panel);
			Component.createPriceLabel(serv_id, panel);
			Component.createRequestButton(user_id, i, panel);
		}

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer window = new Customer("1");
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}