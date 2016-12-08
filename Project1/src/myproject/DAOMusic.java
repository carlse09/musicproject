package myproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sydney Carl
 */
public class DAOMusic {

    private final String fileName = "musicdata.txt";
    private List<Music> myList;

    public DAOMusic() {
        myList = new ArrayList();
        try {
            Files.createFile(Paths.get(fileName));
        } catch (FileAlreadyExistsException fae) {
            ;
        } catch (IOException ex) {
            Logger.getLogger(DAOMusic.class.getName()).log(Level.SEVERE, null, ex);
        }
        readList();

    }

    public void create(Music music) {
        myList.add(music);
        writeList();
    }

    public Music retrieve(int id) {
        for (Music m : myList) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    public void update(Music music) {
        for (Music m : myList) {
            if (m.getId() == music.getId()) {
                m.setSong(music.getSong());
                m.setArtist(music.getArtist());
                m.setAlbum(music.getAlbum());
                m.setLength(music.getLength());
                break;
            }
        }
    }

    public void delete(int id) {
        Music myMusic = null;
        for (Music m : myList) {
            if (m.getId() == id) {
                myMusic = m;
                break;
            }

            myList.remove(myMusic);
        }
        writeList();
    }

    public String orderById() {
           myList.sort(Comparator.comparing(Music::getId));
           return this.toString();
    }
    
    public String orderBySong() {
           myList.sort(Comparator.comparing(Music::getSong));
           return this.toString();
    }
    
    public String orderByArtist() {
           myList.sort(Comparator.comparing(Music::getArtist));
           return this.toString();
    }
    
    public String orderByAlbum() {
           myList.sort(Comparator.comparing(Music::getAlbum));
           return this.toString();
    }
    
    public String orderByLengthAscending() {
           myList.sort(Comparator.comparing(Music::getLength));
           return this.toString();
    }
    
    public String orderByLengthDescending() {
           myList.sort(Comparator.comparing(Music::getLength).reversed());
           return this.toString();
    }
    
    public String orderByArtistAlbumSong() {
           myList.sort(Comparator.comparing(Music::getArtist).thenComparing(Music::getAlbum).thenComparing(Music::getSong));
           return this.toString();
    }

    private void readList() {
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String song = data[1];
                String artist = data[2];
                String album = data[3];
                double length = Double.parseDouble(data[4]);
                Music mymusic = new Music(id, song, artist, album, length);
                myList.add(mymusic);
            }
        } catch (IOException ex) {
            Logger.getLogger(DAOMusic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void writeList() {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (Music music : myList) {
                writer.write(String.format("%d,%s,%s,%s,%.2f\n",
                        music.getId(),
                        music.getSong(),
                        music.getArtist(),
                        music.getAlbum(),
                        music.getLength()));
            }
        } catch (IOException ex) {
            Logger.getLogger(DAOMusic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (Music music : myList) {
            sb.append(music).append("\n");
        }
        return sb.toString();
    }

}
