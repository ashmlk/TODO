/**
* @author Arshia Malekahmadi 2019
*
*/

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EventWindow extends JFrame {

	/**
	 * Keep track of times each field or area has been cleared for user to type own data
	 * @param cTED, initial times the textEventDate field has been clicked
	 * @param cTEP, initial times the textEventPriority field has been clicked
	 * @param cTENa, initial times the textEventName area has been clicked
	 * @param cTENo, initial times the textEventNote area has been clicked
	 */
	private static final long serialVersionUID = -8450001613560937852L;
	private JPanel contentPane;
	private JTextField txtEventDate;
	private JTextField txtEventPriority;
	int cTED = 0;
	int cTEP = 0;
	int cTENa = 0;
	int cTENo = 0;
	int xx, xy;
	/**
	 * Launch the application.
	 */
	public void NewWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventWindow frame = new EventWindow();
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
	public EventWindow() {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 304, 404);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
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
				EventWindow.this.setLocation( x - xx, y - xy);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(SystemColor.activeCaptionBorder);
		panel.setBounds(0, 0, 298, 378);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Event: ");
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 75, 41);
		panel.add(lblNewLabel);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setForeground(SystemColor.textHighlightText);
		lblDate.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblDate.setBounds(10, 63, 75, 41);
		panel.add(lblDate);
		
		JLabel lblNotes = new JLabel("Notes:");
		lblNotes.setForeground(SystemColor.textHighlightText);
		lblNotes.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNotes.setBounds(10, 167, 75, 41);
		panel.add(lblNotes);
		
		JTextArea txtEventNote = new JTextArea();
		txtEventNote.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(cTENo == 0) {
					txtEventNote.setText("");
					cTENo++;
				}
			}
		});
		txtEventNote.setText("Add Additional Notes");
		txtEventNote.setForeground(SystemColor.controlShadow);
		txtEventNote.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		txtEventNote.setBackground(SystemColor.control);
		txtEventNote.setBounds(20, 223, 258, 89);
		panel.add(txtEventNote);
		
		JButton btnSaveAndClose = new JButton("Save and Close");
		btnSaveAndClose.setFocusPainted(false);
		btnSaveAndClose.setBackground(SystemColor.controlShadow);
		btnSaveAndClose.setForeground(SystemColor.text);
		btnSaveAndClose.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnSaveAndClose.setBounds(10, 323, 123, 23);
		panel.add(btnSaveAndClose);
		
		txtEventDate = new JTextField();
		txtEventDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(cTED == 0) {
				 txtEventDate.setText("");
				 cTED++;
				}
			}
		});
		txtEventDate.setForeground(SystemColor.controlShadow);
		txtEventDate.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		txtEventDate.setText("MM/DD/YY");
		txtEventDate.setBounds(68, 78, 129, 20);
		panel.add(txtEventDate);
		txtEventDate.setColumns(10);
		
		JTextArea txtEventName = new JTextArea();
		txtEventName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(cTENa == 0) {
					txtEventName.setText("");
					cTENa++;
				}
			}
		});
		txtEventName.setForeground(SystemColor.controlShadow);
		txtEventName.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		txtEventName.setText("Add Event Name");
		txtEventName.setRows(2);
		txtEventName.setBounds(68, 23, 210, 23);
		panel.add(txtEventName);
		
		JLabel lblPriority = new JLabel("Priority: ");
		lblPriority.setForeground(Color.WHITE);
		lblPriority.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblPriority.setBounds(10, 115, 75, 41);
		panel.add(lblPriority);
		
		txtEventPriority = new JTextField();
		txtEventPriority.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(cTEP == 0) {
					txtEventPriority.setText("");
					cTEP++;
				}
			}
		});
		txtEventPriority.setText("Priority(*, **, ***)");
		txtEventPriority.setForeground(SystemColor.controlShadow);
		txtEventPriority.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		txtEventPriority.setColumns(10);
		txtEventPriority.setBounds(82, 130, 129, 20);
		panel.add(txtEventPriority);
		
		btnSaveAndClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				String name = txtEventName.getText();
				String date = txtEventDate.getText();
				String note = txtEventNote.getText();
				int priority = getPriorityNumber(txtEventPriority.getText());
				EventLabel event_label = new EventLabel(name,date,priority,note);
				event_label.buildLabel();
				//add new event to ArrayList of Event's labels
				event_label.refresh();
				//close frame after button is clicked
				dispose();
			}
		});
	}
	
	/*
	 * Converts priority from String of asterisks to integers ranging from 1 to 3
	 */
	public int getPriorityNumber(String p) {
		if(p.equals("*")){
			return 1;
		}
		else if(p.equals("**")) {
			return 2;
		}
		else if(p.equals("***")) {
			return 3;
		}
		return -1;
	}

}
