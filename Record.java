import java.io.*;

public class Record extends Album implements Serializable {
	String albumName, albumArtist, length;

	public Record(String n, String a, String l) {
		albumName = n;
		albumArtist = a;
		length = l;
	}
	public String getAlbumInfo() {
		return albumName + " by " + albumArtist;
	}
}