package Login_Sys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Travelling {

	private JFrame frame;
	private JTextField txtTax;
	private JTextField txtSubTotal;
	private JTextField txtTotal;
	private JTextField txtClass;
	private JTextField txtTicket;
	private JTextField txtAdult;
	private JTextField txtChild;
	private JTextField txtFrom;
	private JTextField txtTo;
	private JTextField txtDate;
	private JTextField txtTime;
	private JTextField txtTicketNo;
	private JTextField txtPrice;
	private JTextField txtRoute;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Travelling window = new Travelling();
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
	public Travelling() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		// Set the size
		frame.setBounds(0, 0, 1370, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(46, 53, 586, 54);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Travelling Tickting Systems");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 34));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ticket Type");
		lblNewLabel_1.setBounds(46, 128, 142, 35);
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		frame.getContentPane().add(lblNewLabel_1);
		
		JRadioButton rdbtnStandard = new JRadioButton("Standard");
		rdbtnStandard.setBounds(45, 186, 121, 23);
		frame.getContentPane().add(rdbtnStandard);
		
		JRadioButton rdbtnEconomy = new JRadioButton("Economy");
		rdbtnEconomy.setBounds(46, 242, 121, 23);
		frame.getContentPane().add(rdbtnEconomy);
		
		JRadioButton rdbtnFirstClass = new JRadioButton("First Class");
		rdbtnFirstClass.setBounds(46, 299, 121, 23);
		frame.getContentPane().add(rdbtnFirstClass);
		
		JRadioButton rdbtnReturnTickets = new JRadioButton("Return Ticket");
		rdbtnReturnTickets.setBounds(236, 186, 121, 23);
		frame.getContentPane().add(rdbtnReturnTickets);
		
		JRadioButton rdbtnSingleTicket = new JRadioButton("Single Ticket");
		rdbtnSingleTicket.setBounds(236, 242, 121, 23);
		frame.getContentPane().add(rdbtnSingleTicket);
		
		JRadioButton rdbtnAdult = new JRadioButton("Adult");
		rdbtnAdult.setBounds(446, 186, 121, 23);
		frame.getContentPane().add(rdbtnAdult);
		
		JRadioButton rdbtnChild = new JRadioButton("Child");
		rdbtnChild.setBounds(446, 242, 121, 23);
		frame.getContentPane().add(rdbtnChild);
		
		JComboBox cmbDestination = new JComboBox();
		cmbDestination.setBounds(286, 290, 174, 35);
		cmbDestination.setModel(new DefaultComboBoxModel(new String[] {"Destination", "Hangzhou", "Paris", "Amsterdam", "Shanghai"}));
		cmbDestination.setFont(new Font("幼圆", Font.BOLD, 24));
		cmbDestination.setToolTipText("Destination");
		frame.getContentPane().add(cmbDestination);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(34, 117, 518, 10);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(34, 345, 518, 10);
		frame.getContentPane().add(separator_1);
		
		JLabel lblTax = new JLabel("Tax");
		lblTax.setBounds(46, 394, 54, 15);
		frame.getContentPane().add(lblTax);
		
		JLabel lblSubtotal = new JLabel("SubTotal");
		lblSubtotal.setBounds(46, 445, 54, 15);
		frame.getContentPane().add(lblSubtotal);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(46, 501, 54, 15);
		frame.getContentPane().add(lblTotal);
		
		txtTax = new JTextField();
		txtTax.setBounds(185, 391, 66, 21);
		frame.getContentPane().add(txtTax);
		txtTax.setColumns(10);
		
		txtSubTotal = new JTextField();
		txtSubTotal.setBounds(185, 442, 66, 21);
		frame.getContentPane().add(txtSubTotal);
		txtSubTotal.setColumns(10);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(185, 498, 66, 21);
		frame.getContentPane().add(txtTotal);
		txtTotal.setColumns(10);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.setBounds(182, 570, 93, 23);
		btnNewButton.setToolTipText("Reset System");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTax.setText(null);
				txtSubTotal.setText(null);
				txtTotal.setText(null);
				txtAdult.setText(null);
				txtChild.setText(null);
				txtClass.setText(null);
				txtDate.setText(null);
				txtFrom.setText(null);
				txtPrice.setText(null);
				txtRoute.setText(null);
				txtTax.setText(null);
				txtTicket.setText(null);
				txtTicketNo.setText(null);
				txtTime.setText(null);
				txtTo.setText(null);
				rdbtnAdult.setSelected(false);
				rdbtnChild.setSelected(false);
				rdbtnStandard.setSelected(false);
				rdbtnEconomy.setSelected(false);
				rdbtnFirstClass.setSelected(false);
				rdbtnSingleTicket.setSelected(false);
				rdbtnReturnTickets.setSelected(false);
				cmbDestination.setSelectedItem("Destination");
				
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setBounds(335, 570, 93, 23);
		btnNewButton_1.setToolTipText("Exit System");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Login Systems", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Total");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double tax = 19.50;
				
				double MilesK8 = 25.78;
				double MilesK12 = 25.10;
				double MilesK20 = 45.23;
				double MilesK30 = 55.98;
				double totalCost, eco = 3.85, fclass = 5.60;
				
				if(cmbDestination.getSelectedItem().equals("Paris")) {
					totalCost = tax * MilesK8 / 100;
					String sTaxString = String.format("€%.2f", totalCost);
					txtTax.setText(sTaxString);
					double sum = MilesK8;
					
					if(rdbtnStandard.isSelected())
						txtClass.setText("Standard");
					else if (rdbtnEconomy.isSelected()) {
						sum += eco;
						txtClass.setText("Economy");
					}else if (rdbtnStandard.isSelected()) {
						sum += fclass;
						txtClass.setText("First class");
					}
					
					if(rdbtnSingleTicket.isSelected())
						txtTicket.setText("One Way");
					else {
						sum *= 2;
						txtTicket.setText("Two Ways");						
					}
					if(rdbtnAdult.isSelected()) {
						txtAdult.setText("One");
						txtChild.setText("None");
					}else {
						sum *= 0.8;
						txtAdult.setText("None");
						txtChild.setText("One");
					}
					String subTString = String.format("€%.2f", sum);
					txtSubTotal.setText(subTString);
					String totalString = String.format("€%.2f", sum + totalCost);
					txtTotal.setText(totalString);
					txtPrice.setText(totalString);
				}else if(cmbDestination.getSelectedItem().equals("Hangzhou")) {
					totalCost = tax * MilesK20 / 100;
					String sTaxString = String.format("€%.2f", totalCost);
					txtTax.setText(sTaxString);
					double sum = MilesK20;
					
					if(rdbtnStandard.isSelected())
						txtClass.setText("Standard");
					else if (rdbtnEconomy.isSelected()) {
						sum += eco;
						txtClass.setText("Economy");
					}else if (rdbtnStandard.isSelected()) {
						sum += fclass;
						txtClass.setText("First class");
					}
					
					if(rdbtnSingleTicket.isSelected())
						txtTicket.setText("One Way");
					else {
						sum *= 2;
						txtTicket.setText("Two Ways");						
					}
					if(rdbtnAdult.isSelected()) {
						txtAdult.setText("One");
						txtChild.setText("None");
					}else {
						sum *= 0.8;
						txtAdult.setText("None");
						txtChild.setText("One");
					}
					String subTString = String.format("€%.2f", sum);
					txtSubTotal.setText(subTString);
					String totalString = String.format("€%.2f", sum + totalCost);
					txtTotal.setText(totalString);
					txtPrice.setText(totalString);
				}else if(cmbDestination.getSelectedItem().equals("Shanghai")) {
					totalCost = tax * MilesK30 / 100;
					String sTaxString = String.format("€%.2f", totalCost);
					txtTax.setText(sTaxString);
					double sum = MilesK30;
					
					if(rdbtnStandard.isSelected())
						txtClass.setText("Standard");
					else if (rdbtnEconomy.isSelected()) {
						sum += eco;
						txtClass.setText("Economy");
					}else if (rdbtnStandard.isSelected()) {
						sum += fclass;
						txtClass.setText("First class");
					}
					
					if(rdbtnSingleTicket.isSelected())
						txtTicket.setText("One Way");
					else {
						sum *= 2;
						txtTicket.setText("Two Ways");						
					}
					if(rdbtnAdult.isSelected()) {
						txtAdult.setText("One");
						txtChild.setText("None");
					}else {
						sum *= 0.8;
						txtAdult.setText("None");
						txtChild.setText("One");
					}
					String subTString = String.format("€%.2f", sum);
					txtSubTotal.setText(subTString);
					String totalString = String.format("€%.2f", sum + totalCost);
					txtTotal.setText(totalString);
					txtPrice.setText(totalString);
				}else if(cmbDestination.getSelectedItem().equals("Amsterdam")) {
					totalCost = tax * MilesK12 / 100;
					String sTaxString = String.format("€%.2f", totalCost);
					txtTax.setText(sTaxString);
					double sum = MilesK12;
					
					if(rdbtnStandard.isSelected())
						txtClass.setText("Standard");
					else if (rdbtnEconomy.isSelected()) {
						sum += eco;
						txtClass.setText("Economy");
					}else if (rdbtnStandard.isSelected()) {
						sum += fclass;
						txtClass.setText("First class");
					}
					
					if(rdbtnSingleTicket.isSelected())
						txtTicket.setText("One Way");
					else {
						sum *= 2;
						txtTicket.setText("Two Ways");						
					}
					if(rdbtnAdult.isSelected()) {
						txtAdult.setText("One");
						txtChild.setText("None");
					}else {
						sum *= 0.8;
						txtAdult.setText("None");
						txtChild.setText("One");
					}
					String subTString = String.format("€%.2f", sum);
					txtSubTotal.setText(subTString);
					String totalString = String.format("€%.2f", sum + totalCost);
					txtTotal.setText(totalString);
					txtPrice.setText(totalString);
				}
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Time
				Calendar timer = Calendar.getInstance();
				timer.getTime();
				SimpleDateFormat tTime = new SimpleDateFormat("hh : mm: ss");
				txtTime.setText(tTime.format(timer.getTime()));
				
				// Date
				SimpleDateFormat tDateFormat = new SimpleDateFormat("dd-mm-yyyy");
				txtDate.setText(tDateFormat.format(timer.getTime()));
				txtFrom.setText("Berlin");
				txtTo.setText((String) cmbDestination.getSelectedItem());
				
				// Random Number Generator for ticket number
				int num;
				String qString = "";
				num = 1325 + (int)(Math.random() * 4238);
				qString += (num + 1325);
				txtTicketNo.setText(qString);
				
				txtRoute.setText("Any");
			}
		});
		btnNewButton_2.setBounds(34, 570, 93, 23);
		btnNewButton_2.setToolTipText("Total cost of Tickets");
		frame.getContentPane().add(btnNewButton_2);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(34, 536, 518, 10);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(651, 53, 9, 584);
		separator_3.setOrientation(SwingConstants.VERTICAL);
		frame.getContentPane().add(separator_3);
		
		JLabel lblNewLabel_2 = new JLabel("Class");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblNewLabel_2.setBounds(681, 31, 131, 43);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblTicket = new JLabel("Ticket");
		lblTicket.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblTicket.setHorizontalAlignment(SwingConstants.CENTER);
		lblTicket.setBounds(836, 31, 131, 43);
		frame.getContentPane().add(lblTicket);
		
		JLabel lblAdult = new JLabel("Adult");
		lblAdult.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblAdult.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdult.setBounds(977, 31, 131, 43);
		frame.getContentPane().add(lblAdult);
		
		JLabel lblChild = new JLabel("Child");
		lblChild.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblChild.setHorizontalAlignment(SwingConstants.CENTER);
		lblChild.setBounds(1153, 31, 131, 43);
		frame.getContentPane().add(lblChild);
		
		txtClass = new JTextField();
		txtClass.setColumns(10);
		txtClass.setBounds(699, 87, 101, 40);
		frame.getContentPane().add(txtClass);
		
		txtTicket = new JTextField();
		txtTicket.setColumns(10);
		txtTicket.setBounds(850, 87, 101, 40);
		frame.getContentPane().add(txtTicket);
		
		txtAdult = new JTextField();
		txtAdult.setColumns(10);
		txtAdult.setBounds(999, 87, 101, 40);
		frame.getContentPane().add(txtAdult);
		
		txtChild = new JTextField();
		txtChild.setColumns(10);
		txtChild.setBounds(1163, 87, 101, 40);
		frame.getContentPane().add(txtChild);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(691, 72, 593, 10);
		frame.getContentPane().add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(681, 137, 603, 10);
		frame.getContentPane().add(separator_5);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrom.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblFrom.setBounds(670, 222, 131, 43);
		frame.getContentPane().add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblTo.setBounds(657, 299, 131, 43);
		frame.getContentPane().add(lblTo);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblDate.setBounds(670, 377, 131, 43);
		frame.getContentPane().add(lblDate);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblTime.setBounds(670, 445, 131, 43);
		frame.getContentPane().add(lblTime);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setBounds(1099, 137, 9, 514);
		frame.getContentPane().add(separator_6);
		
		txtFrom = new JTextField();
		txtFrom.setColumns(10);
		txtFrom.setBounds(861, 222, 161, 40);
		frame.getContentPane().add(txtFrom);
		
		txtTo = new JTextField();
		txtTo.setColumns(10);
		txtTo.setBounds(861, 299, 161, 40);
		frame.getContentPane().add(txtTo);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(861, 377, 161, 40);
		frame.getContentPane().add(txtDate);
		
		txtTime = new JTextField();
		txtTime.setColumns(10);
		txtTime.setBounds(861, 442, 161, 40);
		frame.getContentPane().add(txtTime);
		
		txtTicketNo = new JTextField();
		txtTicketNo.setColumns(10);
		txtTicketNo.setBounds(1153, 276, 161, 40);
		frame.getContentPane().add(txtTicketNo);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(1153, 408, 161, 40);
		frame.getContentPane().add(txtPrice);
		
		txtRoute = new JTextField();
		txtRoute.setColumns(10);
		txtRoute.setBounds(1153, 533, 161, 40);
		frame.getContentPane().add(txtRoute);
		
		JLabel lblTicketNo = new JLabel("Ticket No.");
		lblTicketNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTicketNo.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblTicketNo.setBounds(1153, 204, 131, 43);
		frame.getContentPane().add(lblTicketNo);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblPrice.setBounds(1163, 345, 131, 43);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblRoute = new JLabel("Route");
		lblRoute.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoute.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblRoute.setBounds(1163, 468, 131, 43);
		frame.getContentPane().add(lblRoute);
	}
}
