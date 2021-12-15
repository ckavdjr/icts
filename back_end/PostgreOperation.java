/**
 * @author Aravind Haridas
 */

package back_end;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreOperation {

	Connection c = null;
	Statement stmt = null;
	ResultSet rs = null;
	String sql = null;
	PreparedStatement ps = null;

	public PostgreOperation() {
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/icts", "postgres", "12345");
			stmt = c.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	/*
	 * For Customer
	 */
	public String getName(String user_id) {
		String fname = "", lname = "";
		try {
			sql = "SELECT fname, lname FROM users WHERE user_id = ?;";
			ps = c.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(user_id));
			rs = ps.executeQuery();
			while (rs.next()) {
				fname = rs.getString("fname");
				lname = rs.getString("lname");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (fname + " " + lname);
	}

	public int getCount(String sql) {
		int count = 0;
		try {
			ps = c.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int getCount(String sql, String cust_id) {
		int count = 0;
		try {
			ps = c.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(cust_id));
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return count;
	}

	public String getCustID(String user_id) {
		String cust_id = "";
		try {
			sql = "SELECT cust_id FROM customer WHERE user_id = ?";
			ps = c.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(user_id));
			rs = ps.executeQuery();
			while (rs.next()) {
				cust_id = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cust_id;
	}
	
	public String getHodID(String user_id) {
		String hod_id = "";
		try {
			sql = "SELECT hod_id FROM hod WHERE user_id = ?";
			ps = c.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(user_id));
			rs = ps.executeQuery();
			while (rs.next()) {
				hod_id = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hod_id;
	}
	
	public String getEmpID(String user_id) {
		String emp_id = "";
		try {
			sql = "SELECT emp_id FROM employee WHERE user_id = ?";
			ps = c.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(user_id));
			rs = ps.executeQuery();
			while (rs.next()) {
				emp_id = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp_id;
	}
	

	public String getServiceID(int i) {
		String serv_id = "";
		try {
			sql = "SELECT serv_id FROM services WHERE serv_id = ?";
			ps = c.prepareStatement(sql);
			ps.setInt(1, i + 1);
			rs = ps.executeQuery();
			while (rs.next()) {
				serv_id = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return serv_id;
	}

	public String getServiceName(String serv_id) {
		String name = "";
		try {
			sql = "SELECT name FROM services WHERE serv_id = ?;";
			ps = c.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(serv_id));
			rs = ps.executeQuery();
			while (rs.next()) {
				name = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}

	public String getPrice(String serv_id) {
		String price = "";
		try {
			sql = "SELECT price FROM services WHERE serv_id = ?;";
			ps = c.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(serv_id));
			rs = ps.executeQuery();
			while (rs.next()) {
				price = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return price;
	}

	public void addRequest(String serv_id, String cust_id) {
		int n = getCount("SELECT count(*) FROM request;");
		try {
			sql = "INSERT INTO request VALUES (?, ?, ?, 'Pending');";
			ps = c.prepareStatement(sql);
			ps.setInt(1, n + 1);
			ps.setInt(2, Integer.parseInt(serv_id));
			ps.setInt(3, Integer.parseInt(cust_id));
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public String[][] getServiceHistoryLabels(String cust_id, int n) {
		String[][] arr = new String[n][3];
		try {
			sql = "SELECT services.name, request.status, assignment.date FROM request INNER JOIN services ON request.serv_id = services.serv_id FULL JOIN assignment ON request.req_id = assignment.req_id WHERE cust_id = ? ORDER BY request.req_id;";
			ps = c.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(cust_id));
			rs = ps.executeQuery();
			int i = 0;
			while (rs.next()) {
				arr[i][0] = rs.getString(1);
				arr[i][1] = rs.getString(2);
				arr[i][2] = rs.getString(3);
				i++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}


	/*
	 * For Employee
	 */

	/*
	 * For Hod
	 */

}
