import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyMenuBar extends JMenuBar {

	JMenuItem save, exit, help;
	JMenu file, about;


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
			JOptionPane.showMessageDialog(getParent(), 
				"This program was made by Kevin Hubbard\n"+ 
				"An album collection program written in Java,\n"+
				"using inheritance, polymorphism, and data structures.");
		}
	}
}