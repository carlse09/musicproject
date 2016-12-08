package myproject;

/**
 *
 * @author Sydney Carl
 */
public class MusicApp2 {
    public static void main(String[] args) {
        DAOMusic data = new DAOMusic();
        data.create(new Music (1, "I Miss You", "Adele", "25", 5.49));
        data.create(new Music (2, "Colors", "Day6", "The Day", 4.17));
        data.create(new Music (3, "I'm Yours", "Alessia Cara", "Four Pink Walls", 3.49));
        System.out.println(data);
        
        System.out.println(data.retrieve(2));
        System.out.println(data.retrieve(-1));
        
        Music m1 = new Music(2, "Thinking Bout You", "Ariana Grande", "Dangerous Woman", 3.20);
        data.update(m1);
        System.out.println(data.retrieve(2));
        
        data.delete(3);
        System.out.println(data);
    }
    
}
