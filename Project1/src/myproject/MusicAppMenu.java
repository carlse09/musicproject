package myproject;

import java.util.Scanner;
import utilities.Prompt;


/**
 *
 * @author Sydney Carl
 */
public class MusicAppMenu {

    Scanner sc = new Scanner(System.in);
    DAOMusic data = new DAOMusic();

    public MusicAppMenu() {
        menuLoop();
    }

    private void menuLoop() {
        int choice = 1;
        int id;
        String song;
        String artist;
        String album;
        double length;

        while (choice != 0) {
            System.out.println("\nMusic App");
            System.out.println("0 = Quit");
            System.out.println("1 = Retrieve All Records");
            System.out.println("2 = Create New Record");
            System.out.println("3 = Retrieve Single Record");
            System.out.println("4 = Update");
            System.out.println("5 = Delete");
            System.out.println("6 = Retrieve All: Order by Id");
            System.out.println("7 = Retrieve All: Order by Song");
            System.out.println("8 = Retrieve All: Order by Artist");
            System.out.println("9 = Retrieve All: Order by Album");
            System.out.println("10 = Retrieve All: Order by Length (ascending)");
            System.out.println("11 = Retrieve All: Order by Length (descending)");
            System.out.println("12 = Retrieve All: Order by Album/Artist/Song");
            System.out.println("13 = Statistics");
            choice = Prompt.getInt("Number of choice: ", 0, 12);

            if (choice == 1) {
                System.out.println(data.toString());
            } else if (choice == 2) {
                id = Prompt.getInt("Enter music id: ");
                song = Prompt.getLine("Enter song: ");
                artist = Prompt.getLine("Enter artist: ");
                album = Prompt.getLine("Enter album: ");
                length = Prompt.getDouble("Enter length: ");
                Music music = new Music(id, song, artist, album, length);
                data.create(music);
            } else if (choice == 3) {
                id = Prompt.getInt("Enter music id: ");
                System.out.println(data.retrieve(id));
            } else if (choice == 4) {
                ;
            } else if (choice == 5) {
                id = Prompt.getInt("Enter music id: ");
                data.delete(id);
            } else if (choice == 6) {
                System.out.println(data.orderById());
            } else if (choice == 7) {
                System.out.println(data.orderBySong());
            } else if (choice == 8) {
                System.out.println(data.orderByArtist());
            } else if (choice == 9) {
                System.out.println(data.orderByAlbum());
            } else if (choice == 10) {
                System.out.println(data.orderByLengthAscending());
            }    else if (choice == 11) {
                System.out.println(data.orderByLengthDescending());
            } else if (choice == 12) {
                System.out.println(data.orderByArtistAlbumSong());
            } else if (choice == 13) {
                ;
            } else if (choice == 0) {
                ;
            }
        }
    }

    public static void main(String[] args) {
        new MusicAppMenu();
    }
}
