/**
 * @author Harichand Manoj
 */
package hod;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import back_end.PostgreOperation;
import login.Login;
import javax.swing.JButton;
import java.sql.Connection;

public class Hod extends JFrame {

	private static String user_id;
	private static String hod_id;
	Connection c = null;
	Statement stmt = null;
	ResultSet rs = null;
	String sql = null;
	PreparedStatement ps = null;
	
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
	 * Initialize the contents of the UI
	 */
	private void initialize() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setBounds(22, 21, 66, 27);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(210, 77, 214, 173);
		getContentPane().add(panel);

		JButton btnNewButton = new JButton("View Requests");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent f) {
				try {
					Class.forName("org.postgresql.Driver");
					c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/icts", "postgres", "root");
					stmt = c.createStatement();

				} catch (Exception e) {
					e.printStackTrace();
					System.err.println(e.getClass().getName() + ": " + e.getMessage());
					System.exit(0);
				}
				try {
					sql = "select* from request";
					ps = c.prepareStatement(sql);
					rs = ps.executeQuery();
					String[][] col = new String[5][6];
					String[] colm= {"Req ID","Serv ID","Cust ID","Status"};
					int i=0;
					while (rs.next()) {
						col[i][0]=rs.getString("req_id");
						col[i][1]=rs.getString("serv_id");
						col[i][2]=rs.getString("cust_id");
						col[i][3]=rs.getString("status");
						i++;
					}
					DefaultTableModel model1 = new DefaultTableModel(col,colm);
				    JTable table1 = new JTable(model1);
				    JScrollPane pane1 = new JScrollPane(table1);
					table1.setShowGrid(true);
				    table1.setShowVerticalLines(true);
					JFrame x1 = new JFrame("Requests Details");
					panel.add(pane1);
					x1.add(panel);
					x1.setSize(500, 250);
				    x1.setVisible(true);

				} catch (SQLException e) {
					e.printStackTrace();
				}
				dispose();
				Approval.main(null);
			}
		});
		btnNewButton.setBounds(10, 77, 190, 35);
		getContentPane().add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("View Employee Details");
		btnNewButton_1.setBounds(10, 123, 190, 36);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent f) {
				try {
					Class.forName("org.postgresql.Driver");
					c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/icts", "postgres", "root");
					stmt = c.createStatement();

				} catch (Exception e) {
					e.printStackTrace();
					System.err.println(e.getClass().getName() + ": " + e.getMessage());
					System.exit(0);
				}
					try {
						sql = "select* from users where user_id=4 or user_id=5";
						ps = c.prepareStatement(sql);
						rs = ps.executeQuery();
						String[][] col = new String[5][6];
						String[] colm= {"fName","lname","email","Address","Contact"};
						int i=0;
						while (rs.next()) {
							col[i][0]=rs.getString("fname");
							col[i][1]=rs.getString("lname");
							col[i][2]=rs.getString("email");
							col[i][3]=rs.getString("adress");
							col[i][4]=rs.getString("contact");
							i++;
						}
						DefaultTableModel model = new DefaultTableModel(col,colm);
					    JTable table = new JTable(model);
					    JScrollPane pane = new JScrollPane(table);
						table.setShowGrid(true);
					    table.setShowVerticalLines(true);
						JFrame x = new JFrame("Employee Details");
						panel.add(pane);
						x.add(panel);
						x.setSize(500, 250);
					    x.setVisible(true);

					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		});
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View Customer Details");
		btnNewButton_2.setBounds(10, 170, 190, 34);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent f) {
				try {
					Class.forName("org.postgresql.Driver");
					c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/icts", "postgres", "root");
					stmt = c.createStatement();

				} catch (Exception e) {
					e.printStackTrace();
					System.err.println(e.getClass().getName() + ": " + e.getMessage());
					System.exit(0);
				}
					try {
						sql = "select* from users where user_id=1 or user_id=2";
						ps = c.prepareStatement(sql);
						rs = ps.executeQuery();
						String[][] col = new String[5][6];
						String[] colm= {"fName","lname","email","Address","Contact"};
						int i=0;
						while (rs.next()) {
							col[i][0]=rs.getString("fname");
							col[i][1]=rs.getString("lname");
							col[i][2]=rs.getString("email");
							col[i][3]=rs.getString("adress");
							col[i][4]=rs.getString("contact");
							i++;
						}
						DefaultTableModel model = new DefaultTableModel(col,colm);
					    JTable table = new JTable(model);
						JScrollPane pane = new JScrollPane(table);
						table.setShowGrid(true);
					    table.setShowVerticalLines(true);
						JFrame x = new JFrame("Customer Details");
						panel.add(pane);
						x.add(panel);
						x.setSize(500, 250);
					    x.setVisible(true);

					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		});
		getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Assign Hod");
		btnNewButton_3.setBounds(10, 215, 190, 35);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Assignment.main(null);
			}
		});
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