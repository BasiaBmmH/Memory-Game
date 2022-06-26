import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HighScore extends Group {
    public HighScore(){

        Text text = new Text();
        text.setText(" ~ High Score ~");
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("Verdana",50));
        text.setFill(Color.AQUAMARINE);

        getChildren().add(text);

    String [] arr = {"a", "b", "c"};

    ListView<String> list = new ListView<String>();
        ObservableList<String> items = FXCollections.observableArrayList(arr);
        list.setItems(items);




    }

}
