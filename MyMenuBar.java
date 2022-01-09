import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyMenuBar extends JMenuBar {

	JMenuItem save, exit, help;
	JMenu file, about;
	Main ma = new Main();

	public MyMenuBar() {
		//JMenuBar menuBar = new JMenuBar();
		//You dont need to instantiate a new class because you extended it.

		file = new JMenu("File");
		about = new JMenu("About");

		save = new JMenuItem("Save");
		exit = new JMenuItem("Exit");
		exit.addActionListener(new ExitListener());
		help = new JMenuItem("Help");
		help.addActionListener(new HelpListener());

		file.add(save);
		file.add(exit);
		about.add(help);
		this.add(file);
		this.add(about);
	}

	public class ExitListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			System.exit(0);
		}
	}

	public class HelpListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			System.out.println("help here");
			JOptionPane.showMessageDialog(ma.frame, "You suck ya jackass..");
		}
	}
}