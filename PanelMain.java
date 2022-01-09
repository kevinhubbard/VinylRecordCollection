import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class PanelMain extends JPanel {
	ArrayList<Record> collection = new ArrayList<Record>();
	JTextField artField, albField, lenField;
	JLabel ranAl = new JLabel("");
	File file = new File("collection.ser");

	public PanelMain() {
		getAlbumCollection();
		JLabel artLabel = new JLabel("Artist:");
		artField = new JTextField(20);
		JLabel albLabel = new JLabel("Album:");
		albField = new JTextField(20);
		JLabel lenLabel = new JLabel("Length:");
		lenField = new JTextField(10);
		
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

		setLayout(new GridLayout(5,2));
		btn.addActionListener(new RandomAlbumListener());
		save.addActionListener(new SaveListener());
		load.addActionListener(new LoadListener());
	}

	private void getAlbumCollection() {
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
			collection = (ArrayList) is.readObject();

			System.out.println("Your collection has " + collection.size() + " albums.");
			is.close();
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist.");
			//add file here if you can.
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		for (Record rec : collection) {
			System.out.println(rec.getAlbumInfo());
		}
	}

	private void saveAlbumCollection() {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
			os.writeObject(collection);
			System.out.println("Collection is " + collection.size() + " albums big.");
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
			Record rec = new Record(albField.getText(), artField.getText(), lenField.getText());
			collection.add(rec);
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