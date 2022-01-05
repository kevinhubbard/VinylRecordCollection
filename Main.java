import java.awt.*;
import javax.swing.*;

public class Main {

	public Main() {
		JFrame frame = new JFrame("Music Collection");
		PanelTop pt = new PanelTop();
		PanelMain pm = new PanelMain();
		PanelBottom pb = new PanelBottom();

		frame.getContentPane().add(BorderLayout.NORTH, pt);
		frame.getContentPane().add(BorderLayout.CENTER, pm);
		frame.getContentPane().add(BorderLayout.SOUTH, pb);

		frame.setSize(750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}
}