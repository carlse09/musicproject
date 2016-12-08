package myproject;

/**
 *
 * @author Sydney Carl
 */
public class Music {
    private int id;
    private String song;
    private String artist;
    private String album;
    private double length;

    public Music() {
    }
    
    public Music(int id, String song, String artist, String album, double length) {
        this.id = id;
        this.song = song;
        this.artist = artist;
        this.album = album;
        this.length = length;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String Song) {
        this.album = Song;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        //return "Music{" + "id=" + id + ", song=" + song + ", artist=" + artist + ", album=" + album + ", length=" + length + '}';
        return String.format("%-5d %-30s %-30s %-30s %8.2f", id, song, artist, album, length);
    }
    
    
}

