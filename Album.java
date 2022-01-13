public abstract class Album {
	String albumName, albumArtist, genre;
	boolean isTopAlbum;
	int topNumber;

	public abstract String getAlbumInfo();
	public abstract boolean topAlbumCheck();
}