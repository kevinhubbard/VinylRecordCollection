import java.io.*;

public class Cd extends Album implements Serializable {
	String albumName, albumArtist, genre;
	boolean scratched, topAlbum;
	int topNumber;

	public Cd(String n, String a, String g, boolean t) {
		albumName = n;
		albumArtist = a;
		genre = g;
		scratched = false;
		topAlbum = t;
	}

	public String getAlbumInfo() {
		return this.getClass() + ": " + albumName + " by " + albumArtist;
	}
}