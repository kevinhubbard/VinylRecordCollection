import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String name;
		String artist;
		ArrayList<Album> collection = new ArrayList<Album>();
		
		System.out.println("how many albums do you want to add today?");
		int numOfAlbums = s.nextInt();

		for (int i = 0; i<numOfAlbums; i++) {
			Scanner d = new Scanner(System.in);
			System.out.print("enter an album name: ");
			name = d.nextLine();
			
			System.out.print("Artist Name: ");
			artist = d.nextLine();
			System.out.print("\n");
			Record r = new Record(name, artist);
			collection.add(r);
		}


		System.out.println("Your collection has " + collection.size() + " albums.");

		for (Album album : collection) {
			System.out.println(album.albumName + " by " + album.albumArtist);
		}

	}
}