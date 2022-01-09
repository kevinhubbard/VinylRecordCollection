import java.io.*;

public class Cd extends Album implements Serializable {
	String albumName, albumArtist, length;

	public Cd(String n, String a, String l) {
		albumName = n;
		albumArtist = a;
		length = l;
	}
	public String getAlbumInfo() {
		return albumName + " by " + albumArtist;
	}
}