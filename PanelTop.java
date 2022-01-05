import java.awt.*;
import javax.swing.*;

public class PanelTop extends JPanel {
	public PanelTop() {
		setBackground(Color.GRAY);
		setPreferredSize(new Dimension(750, 50));
		add(new JLabel("My Music Collection"));
	}
}