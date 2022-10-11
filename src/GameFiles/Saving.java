package GameFiles;

import java.io.*;
import java.util.List;

public class Saving implements Serializable {
    private List<Score> scores;

    public Saving(List<Score> scores) {
        this.scores = scores;
    }

    public static void save() {
        try {
            FileOutputStream stream = new FileOutputStream("save.txt");
            ObjectOutputStream stream2 = new ObjectOutputStream(stream);
            stream2.writeObject(new Saving(NewGame.scores));
            stream2.flush();
            stream2.close();
        } catch (IOException e) {
            System.out.println("saving didn't work ?");
        }
    }

    public static void load() {
        try {
            FileInputStream stream = new FileInputStream("save.txt");
            ObjectInputStream stream2 = new ObjectInputStream(stream);
            Saving saveData = (Saving) stream2.readObject();
            stream2.close();
            NewGame.scores.clear();
            NewGame.scores = saveData.scores;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("File not found ?");
        }
    }
}
