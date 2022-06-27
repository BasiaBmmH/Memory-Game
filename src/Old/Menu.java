package Old;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Menu extends Group {

    public Menu() {
        Text text = new Text();
        text.setText(" Memory Game");
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("Verdana", 50));
        text.setFill(Color.AQUAMARINE);

        getChildren().add(text);

        Button b1 = new Button("NewGame");
        Button b2 = new Button("HighScore");
        Button b3 = new Button("Exit");

        b1.setLayoutX(260);
        b1.setLayoutY(235);

        b2.setLayoutX(260);
        b2.setLayoutY(265);

        b3.setLayoutX(260);
        b3.setLayoutY(295);


        getChildren().add(b1);
        getChildren().add(b2);
        getChildren().add(b3);

        b1.setOnAction(e -> Main.scene.setRoot(new ChooseImage()));

        b2.setOnAction(e -> Main.scene.setRoot(new HighScore()));

        b3.setOnAction(e -> System.exit(0));

    }
}