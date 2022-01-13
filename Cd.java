import java.io.*;

public class Cd extends Album implements Serializable {
	String albumName, albumArtist, genre;
	boolean isTopAlbum;
	int topNumber;

	public Cd(String n, String a, String g, boolean t) {
		albumName = n;
		albumArtist = a;
		genre = g;
		isTopAlbum = t;
	}

	public boolean topAlbumCheck() {
		return isTopAlbum;
	}

	public String getAlbumInfo() {
		return this.getClass() + ": " + albumName + " by " + albumArtist;
	}
}