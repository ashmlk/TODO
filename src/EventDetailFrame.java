/**
* @author Arshia Malekahmadi 2019
*
*/

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;

/*
 * This class shows each events details and can change each event detail when click in main panel of listed events(tasks TO-DO)
 */

public class EventDetailFrame extends JFrame {
	
	private static final long serialVersionUID = 1581619894692961118L;
	private JPanel contentPane;
	private JTextField textFieldPriorityD;
	private JTextField textFieldDateD;
	private JTextField textFieldNameD;
	private JTextArea  textAreaNoteD;
	int xx,xy;
	/**
	 * Open the frame of Event's details.
	 */
	public void open() {
				try {
					this.setVisible(true);
					this.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the frame.
	 */
	public EventDetailFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 361, 376);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
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
				EventDetailFrame.this.setLocation( x - xx, y - xy);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Name: ");
		lblNewLabel.setForeground(SystemColor.windowBorder);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 27, 81, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblDate = new JLabel("Date: ");
		lblDate.setForeground(SystemColor.windowBorder);
		lblDate.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		lblDate.setBounds(10, 70, 81, 22);
		contentPane.add(lblDate);
		
		JLabel lblPriority = new JLabel("Priority: ");
		lblPriority.setForeground(SystemColor.windowBorder);
		lblPriority.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		lblPriority.setBounds(10, 116, 88, 22);
		contentPane.add(lblPriority);
		
		JLabel lblNote = new JLabel("Note:");
		lblNote.setForeground(SystemColor.windowBorder);
		lblNote.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		lblNote.setBounds(10, 161, 88, 22);
		contentPane.add(lblNote);
		
		textFieldPriorityD = new JTextField();
		textFieldPriorityD.setEditable(false);
		textFieldPriorityD.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		textFieldPriorityD.setBounds(75, 119, 96, 20);
		contentPane.add(textFieldPriorityD);
		textFieldPriorityD.setColumns(10);
		
		textFieldDateD = new JTextField();
		textFieldDateD.setEditable(false);
		textFieldDateD.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		textFieldDateD.setColumns(10);
		textFieldDateD.setBounds(75, 74, 96, 20);
		contentPane.add(textFieldDateD);
		
		textFieldNameD = new JTextField();
		textFieldNameD.setEditable(false);
		textFieldNameD.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		textFieldNameD.setColumns(10);
		textFieldNameD.setBounds(75, 31, 194, 20);
		contentPane.add(textFieldNameD);
		
		textAreaNoteD = new JTextArea();
		textAreaNoteD.setEditable(false);
		textAreaNoteD.setBounds(75, 194, 248, 98);
		contentPane.add(textAreaNoteD);
		
		JButton btnChange = new JButton("Change");
		btnChange.setFocusPainted(false);
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNameD.setText("Name cannot be changed");
				textFieldDateD.setEditable(true);
				textFieldPriorityD.setEditable(true);
				textAreaNoteD.setEditable(true);
			}
		});
		btnChange.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		btnChange.setBounds(10, 303, 89, 23);
		contentPane.add(btnChange);
		
		JButton btnSave = new JButton("Save and Close");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaNoteD.setText(textAreaNoteD.getText());
				textFieldDateD.setText(textFieldDateD.getText());
				textFieldPriorityD.setText(textFieldPriorityD.getText());
				dispose();
			}
		});
		btnSave.setFocusPainted(false);
		btnSave.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		btnSave.setBounds(109, 303, 141, 23);
		contentPane.add(btnSave);		
	}
	
	public void settextFieldNameD(String s) {
		this.textFieldNameD.setText(s);
	}
	
	public void settextFieldDateD(String s) {
		this.textFieldDateD.setText(s);
	}
	
	public void settextFieldPriorityD(String s) {
		this.textFieldPriorityD.setText(s);
	}
	
	public void settextAreaNoteD(String s) {
		this.textAreaNoteD.setText(s);
	}
}
