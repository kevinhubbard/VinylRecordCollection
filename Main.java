import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Main {

	public static void main(String[] args) {
		UIManager ui = new UIManager();
		try {
			UIManager.setLookAndFeel(ui.getSystemLookAndFeelClassName()); 
		} catch (Exception e) {e.printStackTrace();}
		new Main();
	}

	public Main() {
		JFrame frame = new JFrame("Music Collection");
		PanelTop pTop = new PanelTop();
		PanelMain pMain = new PanelMain();
		PanelBottom pBot = new PanelBottom();
		PanelRight pRight = new PanelRight();
		MyMenuBar bar = new MyMenuBar();
		frame.setJMenuBar(bar);
		frame.getContentPane().add(BorderLayout.NORTH, pTop);
		frame.getContentPane().add(BorderLayout.CENTER, pMain);
		frame.getContentPane().add(BorderLayout.SOUTH, pBot);
		frame.getContentPane().add(BorderLayout.EAST, pRight);
		frame.setSize(750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}