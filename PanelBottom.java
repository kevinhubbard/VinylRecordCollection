import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

import java.awt.Desktop;
import java.io.*;

public class PanelBottom extends JPanel{


		Desktop desktop = java.awt.Desktop.getDesktop();

	public PanelBottom() {


		JLabel end = new JLabel("KevinJr.net");
		setBackground(Color.GRAY);
		end.addMouseListener(new OpenLink());
		add(end);
	}


	public class OpenLink implements MouseListener {
		public void mouseClicked(MouseEvent ev) {
			try {
				URI uri = new URI("http://www.kevinjr.net");
				desktop.browse(uri);
			} catch (Exception e) {e.printStackTrace();}
		}
		public void mouseEntered(MouseEvent ev) {
			setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		public void mouseExited(MouseEvent ev) {
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
		public void mousePressed(MouseEvent ev) {}
		public void mouseReleased(MouseEvent ev) {}
	}
}