/**
 * @author Aravind Haridas
 */

package back_end;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Component {

	static PostgreOperation pg = new PostgreOperation();

	/*
	 * For Customer
	 */
	public static void createRequestButton(String cust_id, int i, JPanel panel) {
		JButton request = new JButton("Request");
		request.setFont(new Font("Tahoma", Font.PLAIN, 21));

		request.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pg.addRequest(pg.getServiceID(i), cust_id);
				showMessageDialog(null, "Request has been added!");
			}
		});

		panel.add(request);
	}

	public static void createServiceLabel(String serv_id, JPanel panel) {
		String serv_name = pg.getServiceName(serv_id);
		JLabel service = new JLabel(serv_name);
		service.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel.add(service);
	}

	public static void createPriceLabel(String serv_id, JPanel panel) {
		String serv_price = pg.getPrice(serv_id);
		JLabel price = new JLabel("$" + serv_price);
		price.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel.add(price);
	}

	public static void createServiceHistoryLabels(String cust_id, JPanel panel, int n) {
		String[][] arr = pg.getServiceHistoryLabels(cust_id, n);

		for (int i = 0; i < n; i++) {
			JLabel name = new JLabel(arr[i][0]);
			name.setFont(new Font("Tahoma", Font.PLAIN, 21));
			panel.add(name);

			JLabel status = new JLabel(arr[i][1]);
			status.setFont(new Font("Tahoma", Font.PLAIN, 21));
			panel.add(status);

			JLabel date = new JLabel(arr[i][2]);
			date.setFont(new Font("Tahoma", Font.PLAIN, 21));
			panel.add(date);
		}

		for (int i = 0; i < n; i++) {
			System.out.println(arr[i][0]);
			System.out.println(arr[i][1]);
			System.out.println(arr[i][2]);
			System.out.println();
		}
	}

}
