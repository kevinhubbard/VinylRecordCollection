import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class PanelMain extends JPanel {
	ArrayList<Record> collection = new ArrayList<Record>();
	JTextField artField, albField, lenField;

	public PanelMain() {
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
		add(update);
		add(clear);

		clear.addActionListener(new ClearListener());
		save.addActionListener(new SaveListener());
		load.addActionListener(new LoadListener());
		update.addActionListener(new UpdateListener());
	}

	public void getAlbumCollection(){
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("collection.ser"));
			Object object = is.readObject();

			while(object != null){
				collection.add((Record) object);
			}
		} catch (Exception es) {
			es.printStackTrace();
		}
	}

	public void saveAlbumCollection() {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("collection.ser"));
			os.writeObject(collection);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		System.out.println("collection saved successfully.");
	}

	public void clearScreen() {
		artField.setText("");
		albField.setText("");
		lenField.setText("");
		artField.requestFocus();
	}

	//INNER CLASSES

	public class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			clearScreen();
		}
	}

	public class SaveListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			Record rec = new Record(albField.getText(), artField.getText(), lenField.getText());
			collection.add(rec);	
			clearScreen();
		}
	}

	public class LoadListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			if(collection.isEmpty()) {
				System.out.println("Collection is empty.");
			} else {
				System.out.println(collection.size());
			}
		}
	}

	public class UpdateListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			saveAlbumCollection();
		}
	}
}