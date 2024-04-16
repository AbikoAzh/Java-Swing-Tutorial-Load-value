import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;

public class HelloWorld {

	private JFrame frame;
	private JList list;
	private JLabel lblClock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelloWorld window = new HelloWorld();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	// this method used to display the date and time of the computer in frame
	public void clock(){
		
		Thread clock = new Thread(){
			public void run(){
				try {
					
					for(;;){
						
						Calendar cal = new GregorianCalendar();
						int day = cal.get(Calendar.DAY_OF_MONTH);
						int month = cal.get(Calendar.MONTH);
						int year = cal.get(Calendar.YEAR);
						
						int second = cal.get(Calendar.SECOND);
						int minute = cal.get(Calendar.MINUTE);
						int hour = cal.get(Calendar.HOUR);
						
						lblClock.setText("Time :   "+hour+": "+minute+":"+second+"   Date : "+year+" /"+month+"/"+day);
						
						sleep(1000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		clock.start();
		
		
	}
	/**
	 * Create the application.
	 */
	public HelloWorld() {
		initialize();
		clock();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 624, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("How Add JList");
		frame.getContentPane().setLayout(null);
		
		list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Abubaker", "Ali"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(412, 11, 186, 130);
		frame.getContentPane().add(list);
		
		JButton btnLoadValue = new JButton("Load Value");
		btnLoadValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// this is used for JList we add value and send it to jlist
				DefaultListModel dl = new DefaultListModel();
				dl.addElement("Mark");
				dl.addElement("July");
				dl.addElement("John");
				dl.addElement("Markus");
				dl.addElement("Peter");
				
				list.setModel(dl);
			}
		});
		btnLoadValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLoadValue.setBounds(236, 36, 109, 23);
		frame.getContentPane().add(btnLoadValue);
		
		lblClock = new JLabel("Clock");
		lblClock.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblClock.setBounds(10, 190, 588, 150);
		frame.getContentPane().add(lblClock);
	}
}
