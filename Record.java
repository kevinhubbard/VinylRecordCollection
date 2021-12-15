public class Record extends Album {

	public Record(String n, String a) {
		albumName = n;
		albumArtist = a;
	}
	public String getAlbumInfo() {
		return albumName + " by " + albumArtist;
	}
}