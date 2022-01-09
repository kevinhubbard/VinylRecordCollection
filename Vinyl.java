import java.io.*;

public class Vinyl extends Album implements Serializable {
	String albumName, albumArtist, genre;
	boolean scratched = false;

	public Vinyl(String n, String a, String g) {
		albumName = n;
		albumArtist = a;
		genre = g;
	}

	public String getAlbumInfo() {
		return this.getClass() + ": " + albumName + " by " + albumArtist;
	}
}