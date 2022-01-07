import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class PanelMain extends JPanel {
	ArrayList<Record> collection = new ArrayList<Record>();
	JTextField artField, albField, lenField;
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

		JButton save = new JButton("Save");
		JButton load = new JButton("Load");
		JButton update = new JButton("update collection");
		JButton clear = new JButton("clear");

		add(save);
		add(load);
		//add(update);
		//add(clear);

		//clear.addActionListener(new ClearListener());
		save.addActionListener(new SaveListener());
		load.addActionListener(new LoadListener());
		//update.addActionListener(new UpdateListener());
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
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
			return;
		} catch (Exception ex) {
			ex.printStackTrace();
			return;
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

/*	public class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			clearScreen();
		}
	}

	public class UpdateListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			saveAlbumCollection();
		}
	}*/
}