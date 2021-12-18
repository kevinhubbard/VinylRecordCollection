import java.io.Serializable;

public class Record extends Album implements Serializable {

	public Record(String n, String a) {
		albumName = n;
		albumArtist = a;
	}
	public String getAlbumInfo() {
		return albumName + " by " + albumArtist;
	}
}