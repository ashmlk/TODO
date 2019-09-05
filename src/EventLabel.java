import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Comparator;

import javax.swing.JLabel;

public class EventLabel extends Home {
	
	private static final long serialVersionUID = 2189180039176631599L;
	private String name;
	private String date;
	private int priority;
	private String note;
	
	/*
	 * Constructs EventLabel to hold an events data.
	 */
	public EventLabel(String name2, String date2, int priority2, String note2) {
		super();
		this.name = name2;
		this.date = date2;
		this.priority = priority2;
		this.note = note2;
	}
	
	/*
	 * Builds new JLabel from Class Home, to be added to Home.panel_event
	 */
	public void buildLabel() {
		label = new JLabel(this.getName());
		label.setBounds(10, 11, 403, 34);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		EventDetailFrame detailFrame = new EventDetailFrame();
		detailFrame.settextFieldNameD(this.getName());
		detailFrame.settextFieldDateD(this.getDate());
		detailFrame.settextFieldPriorityD(getPriorityString(this.getPriority()));
		detailFrame.settextAreaNoteD(this.getNote());
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				detailFrame.open();
			}
		});
		EventLabelList.add(this);
	}
	public void refresh(){

		EventList.add(label);
	}
	
	/*
	 * Returns priority of event as a String (* or ** or ***) based on priority number.
	 */
	public String getPriorityString(int p) {
		if(p == 1){
			return "*";
		}
		else if(p == 2) {
			return "**";
		}
		else if(p == 3) {
			return "***";
		}
		return "error";
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public int getPriority() {
		return this.priority;
	}
	
	public String getNote() {
		return this.note;
	}
	
	public static Comparator<EventLabel> SortByName = new Comparator<EventLabel>() {
		public int compare(EventLabel l1, EventLabel l2) {
			return (l1.getName().toUpperCase().compareTo(l1.getName().toUpperCase()));
		}
	};
	
	public static Comparator<EventLabel> SortByDate = new Comparator<EventLabel>() {
		public int compare(EventLabel l1, EventLabel l2) {
			int d1 = Integer.parseInt(l1.getDate().replaceAll("[a-zA-Z/]", ""));
			int d2 = Integer.parseInt(l2.getDate().replaceAll("[a-zA-Z/]", ""));
			return d2 - d1;
		}
	};
	
	public static Comparator<EventLabel> SortByPriority = new Comparator<EventLabel>() {
		public int compare(EventLabel l1, EventLabel l2) {
			return (l2.getPriority() - l1.getPriority());
		}
	};
}
