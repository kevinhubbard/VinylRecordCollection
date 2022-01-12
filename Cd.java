import java.io.*;

public class Cd extends Album implements Serializable {
	String albumName, albumArtist, genre;
	boolean scratched = false;
	int topNumber;

	public Cd(String n, String a, String g) {
		albumName = n;
		albumArtist = a;
		genre = g;
		topNumber = null;
	}

	public Cd(String n, String a, String g, int p,) {
		albumName = n;
		albumArtist = a;
		genre = g;
		topNumber = p;
	}



	public String getAlbumInfo() {
		return this.getClass() + ": " + albumName + " by " + albumArtist;
	}
}