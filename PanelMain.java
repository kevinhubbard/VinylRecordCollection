import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class PanelMain extends JPanel {
	ArrayList<Album> collection = new ArrayList<Album>();
	JTextField artField, albField, lenField;
	JLabel ranAl = new JLabel("");
	ButtonGroup radioBtnGroup = new ButtonGroup();
	File file = new File("collection.ser");

	public PanelMain() {
		getAlbumCollection();
		JRadioButton vinylBtn = new JRadioButton("Vinyl", true);
		vinylBtn.setActionCommand("vinyl");
		JRadioButton cdBtn = new JRadioButton("CD");
		cdBtn.setActionCommand("cd");
		radioBtnGroup.add(vinylBtn);
		radioBtnGroup.add(cdBtn);
		JLabel artLabel = new JLabel("Artist:");
		artField = new JTextField(20);
		JLabel albLabel = new JLabel("Album:");
		albField = new JTextField(20);
		JLabel lenLabel = new JLabel("Length:");
		lenField = new JTextField(10);

		add(vinylBtn);
		add(cdBtn);
		add(artLabel);
		add(artField);
		add(albLabel);
		add(albField);
		add(lenLabel);
		add(lenField);
		

		JButton btn = new JButton("Random Album");
		JButton save = new JButton("Save");
		JButton load = new JButton("Load");

		add(save);
		add(load);
		add(btn);
		add(ranAl);

		setLayout(new GridLayout(6,2));
		btn.addActionListener(new RandomAlbumListener());
		save.addActionListener(new SaveListener());
		load.addActionListener(new LoadListener());
	}

	private void getAlbumCollection() {

		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
			collection = (ArrayList) is.readObject();

			System.out.println("Your collection has loaded and has " + collection.size() + " albums.");
			is.close();
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		for (Album r : collection) {
			System.out.println(r.getAlbumInfo());
		}
	}

	private void saveAlbumCollection() {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
			os.writeObject(collection);

			System.out.println("Collection was serialized and has " + collection.size() + " albums.\n");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private void clearScreen() {
		artField.setText("");
		albField.setText("");
		lenField.setText("");
		artField.requestFocus();
	}

	//INNER CLASSES

	public class SaveListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {

			if((radioBtnGroup.getSelection().getActionCommand()).equals("vinyl")) {
				System.out.println("A new vinyl Album was created.");
				Record rec = new Record(albField.getText(), artField.getText(), lenField.getText());
				collection.add(rec);
			} else {
				System.out.println("A new cd Album was created.");
				Cd cd = new Cd(albField.getText(), artField.getText(), lenField.getText());
				collection.add(cd);
			}
			saveAlbumCollection();
			clearScreen();
		}
	}

	public class LoadListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			getAlbumCollection();
		}
	}

	public class RandomAlbumListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			int index = (int) (Math.random() * collection.size());
			ranAl.setText((collection.get(index).getAlbumInfo()));
		}
	}
}