import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class PanelMain extends JPanel {
	ArrayList<Album> collection = new ArrayList<Album>();
	ArrayList<Album> topTen = new ArrayList<Album>();
	JTextField artField, albField, genreField;
	JCheckBox top;
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
		JLabel genreLabel = new JLabel("Genre:");
		genreField = new JTextField(20);
		top = new JCheckBox("Top 10?");

		add(vinylBtn);
		add(cdBtn);
		add(artLabel);
		add(artField);
		add(albLabel);
		add(albField);
		add(genreLabel);
		add(genreField);
		add(top);

		JButton btn = new JButton("Random Album");
		JButton save = new JButton("Save");
		JButton load = new JButton("Load");

		add(save);
		add(load);
		add(btn);
		add(ranAl);
		

		setLayout(new GridLayout(7,2));
		btn.addActionListener(new RandomAlbumListener());
		save.addActionListener(new SaveListener());
		load.addActionListener(new LoadListener());
	}

	private void getAlbumCollection() {
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
			collection = (ArrayList) is.readObject();
			System.out.println("\nYour collection has loaded and has " + collection.size() + " albums.");
			is.close();
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist.");
		} catch (Exception ex) {ex.printStackTrace();}

	}

	private void saveAlbumCollection() {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
			os.writeObject(collection);
			System.out.println("Collection was serialized and has " + collection.size() + " albums.");
		} catch (IOException ex) {ex.printStackTrace();}
	}

	private void clearScreen() {
		artField.setText("");
		albField.setText("");
		genreField.setText("");
		top.setSelected(false);
		artField.requestFocus();
	}

	private boolean checkUserInput() {
		boolean pass = false;
		String alCheck = albField.getText().trim();
		String arCheck = artField.getText().trim();

		if (alCheck.length() == 0 || arCheck.length() == 0) {
			System.out.println("There was a problem with the user input");
		} else {
			pass = true;
		}
		return pass;
	} 


	//INNER CLASSES

	public class SaveListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {

			if (checkUserInput()) {
				if((radioBtnGroup.getSelection().getActionCommand()).equals("vinyl")) {
					System.out.println("\nA new vinyl Album was created.");
					Vinyl rec = new Vinyl(albField.getText().trim(), artField.getText().trim(), genreField.getText(), top.isSelected());
					collection.add(rec);
				} else {
					System.out.println("\nA new cd Album was created.");
					Cd cd = new Cd(albField.getText().trim(), artField.getText().trim(), genreField.getText(), top.isSelected());
					collection.add(cd);
				}
				saveAlbumCollection();
			} else {
				System.out.println("Something was entered wrong");
			}

			clearScreen();
		}
	}

	public class LoadListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			getAlbumCollection();
			for (Album r : collection) {
				if (r.topAlbumCheck() == true) {
					topTen.add(r);
				} else {
					System.out.println("idk");
				}
			}

			System.out.println("Top 10 Size: " + topTen.size());
			System.out.println("Collection size: " + collection.size());
		}
	}

	public class RandomAlbumListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			int index = (int) (Math.random() * collection.size());
			ranAl.setText((collection.get(index).getAlbumInfo()));
		}
	}
}