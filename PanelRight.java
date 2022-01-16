import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class PanelRight extends JPanel {
	String name[] = {"Kevin", "Brian", "Eric"};
	JList jlist = new JList(name);
	public PanelRight() {
		setBackground(Color.GRAY);
		JLabel topAlbum = new JLabel("TOP ALBUMS:");

		JScrollPane listScroller = new JScrollPane(jlist);
		listScroller.setPreferredSize(new Dimension(150, 250));
		listScroller.setAlignmentX(LEFT_ALIGNMENT);

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(topAlbum);
		add(listScroller);
		setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

/*		JPanel btnPane = new JPanel();
		JButton addRemove = new JButton("Add/Remove");
		btnPane.setLayout(new BoxLayout(btnPane, BoxLayout.LINE_AXIS));
		btnPane.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
		btnPane.add(Box.createHorizontalGlue());
		btnPane.add(addRemove);
		add(btnPane);*/
	}
}