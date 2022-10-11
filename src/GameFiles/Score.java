package GameFiles;

import java.io.Serializable;

class Score implements Serializable {
    String name;
    int score;

    public Score(String name, int score) {
        this.name = name;
        this.score = score;
    }
}