/**
 * @author Aravind Haridas
 */

package login;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import static javax.swing.JOptionPane.showMessageDialog;
import back_end.PostgreOperation;
import customer.Customer;
import hod.Hod;
import employee.Employee;

public class Login extends JFrame {

	private String username;
	private String password;

	PostgreOperation pg = new PostgreOperation();

	/**
	 * Create the application.
	 */
	public Login() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Login");
		setBounds(100, 100, 222, 290);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lbl_title = new JLabel("ICTS");
		lbl_title.setBounds(77, 15, 60, 34);
		lbl_title.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_title.setForeground(Color.red);
		getContentPane().add(lbl_title);

		JTextField tf_username = new JTextField();
		tf_username.setBounds(10, 60, 190, 36);
		getContentPane().add(tf_username);
		tf_username.setText("Username");

		JPasswordField pw_password = new JPasswordField();
		pw_password.setBounds(10, 100, 190, 36);
		getContentPane().add(pw_password);
		pw_password.setText("Password");

		JButton btn_submit = new JButton("Login");
		btn_submit.setBounds(10, 150, 190, 36);
		btn_submit.setMnemonic(KeyEvent.VK_B);
		getContentPane().add(btn_submit);
		btn_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username = tf_username.getText();
				password = String.valueOf(pw_password.getPassword());
				if (pg.userExists(username, password)) {
					String user_id = pg.getUserID(username);

					if (!"".equals(pg.getCustID(user_id))) {
						dispose();
						Customer.openFrame(user_id);
					}

					if (!"".equals(pg.getEmpID(user_id))) {
						dispose();
						Employee.openFrame(user_id);
					}

					if (!"".equals(pg.getHodID(user_id))) {
						dispose();
						Hod.openFrame(user_id);
					}

				} else {
					showMessageDialog(null, "Username or password is invalid!");
				}

			}
		});

		JButton btn_register = new JButton("Create new account");
		btn_register.setBounds(10, 190, 190, 34);
		btn_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Register.openFrame();
			}
		});
		getContentPane().add(btn_register);

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}