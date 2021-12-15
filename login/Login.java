/**
 * @author Sidharth PV
 * @author Aravind Haridas
 */

package login;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import back_end.Component;
import back_end.PostgreOperation;

public class Login extends JFrame{
	
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

		JLabel title = new JLabel("ICTS");
		title.setBounds(77, 15, 60, 34);
		title.setFont(new Font("Tahoma", Font.PLAIN, 22));
		title.setForeground(Color.red);
		getContentPane().add(title);

		JTextField username = new JTextField();
		username.setBounds(10, 60, 190, 36);
		getContentPane().add(username);
		username.setText("Username");

		JPasswordField password = new JPasswordField();
		password.setBounds(10, 100, 190, 36);
		getContentPane().add(password);
		password.setText("password");

		JButton btn_submit = new JButton("Login");
		btn_submit.setBounds(10, 150, 190, 36);
		getContentPane().add(btn_submit);

		JButton btn_register = new JButton("Create new account");
		btn_register.setBounds(10, 190, 190, 34);
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