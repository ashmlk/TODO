import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.JComboBox;

public class Home extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private  JPanel panel_event;
	private JComboBox<String> comboBox;
	//Construct ArrayList to Keep all Events(tasks)added by user
	public static ArrayList<JLabel> EventList = new ArrayList<JLabel>();
	public static ArrayList<EventLabel> EventLabelList = new ArrayList<EventLabel>();
	public  static JLabel label;
	int xx, xy;
	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setBackground(SystemColor.control);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 571);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
				xy = e.getY();
			}
		});
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				Home.this.setLocation( x - xx, y - xy);
			}
		});
		
		JPanel panel_header = new JPanel();
		panel_header.setBackground(SystemColor.controlShadow);
		panel_header.setBounds(0, 0, 434, 82);
		contentPane.add(panel_header);
		panel_header.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TO-DO List");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 35));
		lblNewLabel.setBounds(10, 11, 320, 55);
		panel_header.add(lblNewLabel);
		
		JButton addButton = new JButton("+");
		addButton.setFocusPainted(false);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventWindow frame = new EventWindow();
				frame.NewWindow();
			}
		});
		addButton.setForeground(Color.WHITE);
		addButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		addButton.setBackground(SystemColor.controlShadow);
		addButton.setBounds(383, 0, 41, 23);
		panel_header.add(addButton);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBackground(SystemColor.controlShadow);
		btnRefresh.setFocusPainted(false);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(EventList.size() > 0) {
				for(JLabel l : EventList) {
					panel_event.add(l);
					}
				} else {
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame, "Please enter a task before refreshing the list");
				}
				panel_event.revalidate();	
			}
		});
		btnRefresh.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		btnRefresh.setForeground(Color.WHITE);
		btnRefresh.setBounds(290, 0, 89, 23);
		panel_header.add(btnRefresh);
		
		comboBox = new JComboBox<String>();
		comboBox.setForeground(SystemColor.textHighlightText);
		comboBox.setBackground(SystemColor.controlShadow);
		comboBox.addItem("Sort By");
		comboBox.addItem("Date");
		comboBox.addItem("Name");
		comboBox.addItem("Priority");
		comboBox.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		comboBox.setBounds(290, 34, 89, 22);
		panel_header.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String s = (String)comboBox.getSelectedItem();
				
				switch (s) {
				case "Date":
					Collections.sort(EventLabelList, EventLabel.SortByDate);
					EventList.clear();
					break;
				case "Name":
					Collections.sort(EventLabelList, EventLabel.SortByName);
					EventList.clear();
					break;
				case "Priority":
					Collections.sort(EventLabelList, EventLabel.SortByPriority);
					EventList.clear();
					break;
				}
				
				Iterator<EventLabel> iter = EventLabelList.iterator();
				while(iter.hasNext()) {
					EventLabel event = iter.next();
					event.buildLabel();
					event.refresh();
				}
			}
		});

		
		panel_event = new JPanel();
		panel_event.setBackground(Color.GRAY);
		panel_event.setBounds(0, 93, 434, 452);
		contentPane.add(panel_event);
		panel_event.setLayout((LayoutManager) new BoxLayout(panel_event, BoxLayout.Y_AXIS));
	}
	
}
