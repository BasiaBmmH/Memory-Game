package GameFiles;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

import java.util.LinkedList;
import java.util.List;


public class HighScore extends GridPane {
    public HighScore() {
        super();
        setAlignment(Pos.CENTER);
        setPadding(new Insets(16));
        setVgap(16);

        List<String> ss = new LinkedList<>();
        for (Score s : NewGame.scores) ss.add(s.name + " " + s.score);

        ListView<String> list = new ListView<String>();
        ObservableList<String> items = FXCollections.observableArrayList(ss);
        list.setItems(items);

        add(list, 0, 0);

        Button b = new Button("Menu");
        setHalignment(b, HPos.CENTER);
        add(b, 0, 1);

        b.setOnAction(e -> Main.scene.setRoot(new Menu()));
    }
}