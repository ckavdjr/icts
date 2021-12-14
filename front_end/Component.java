package front_end;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Component {			// TODO Replace(remove) all Font.PLAIN in all classes
	
	static PostgreOperation pg = new PostgreOperation();
	
	public static void createRequestButton(String user_id, int i, JPanel panel) {
		JButton request = new JButton("Request");
		request.setFont(new Font("Tahoma", Font.PLAIN, 21));
		
		request.addActionListener(new ActionListener() {				
			public void actionPerformed(ActionEvent e) {
				System.out.println("Service ID:" + i + "\nRequest added.\n");  // TODO: Remove tracer 
				pg.addRequest(pg.getServiceID(i), pg.getCustID(user_id));
			}
		});
		
		panel.add(request);
	}
	
	public static void createServiceLabel(String serv_id, JPanel panel)
	{
		String serv_name = pg.getServiceName(serv_id);
		JLabel service = new JLabel(serv_name);
		service.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel.add(service);
	}
	
	public static void createPriceLabel(String serv_id, JPanel panel)
	{
		String serv_price = pg.getPrice(serv_id);
		JLabel price = new JLabel("$"+serv_price);
		price.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel.add(price);
	}

}
