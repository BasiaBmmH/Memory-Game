package Old;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ChooseImage extends Group {

    public static int number;

    public ChooseImage() {

        Text text = new Text();
        text.setText(" Choose wisely:");
        text.setX(120);
        text.setY(30);
        text.setFont(Font.font("Verdana", 30));
        text.setFill(Color.AQUAMARINE);

        getChildren().add(text);

        Button b1 = new Button("Lord of the Rings");
        Button b2 = new Button("Prince of Percia 2008");
        Button b3 = new Button("Assassin creed");
        Button b4 = new Button("Cats");
        Button b5 = new Button("Dazai");


        b1.setLayoutX(260);
        b1.setLayoutY(130);

        b2.setLayoutX(260);
        b2.setLayoutY(160);

        b3.setLayoutX(260);
        b3.setLayoutY(190);

        b4.setLayoutX(260);
        b4.setLayoutY(220);

        b5.setLayoutX(260);
        b5.setLayoutY(250);


        getChildren().add(b1);
        getChildren().add(b2);
        getChildren().add(b3);
        getChildren().add(b4);
        getChildren().add(b5);

        Image image;
        int i = 0;

        b1.setOnAction((e) -> {
            Main.scene.setRoot(new Siatka());
            Card.image = new Image("Images\\LOTR\\lotr" + i + ".jpg");
        });

        b2.setOnAction((e) -> {
            Main.scene.setRoot(new Siatka());
            Card.image = new Image("Images\\PrinceOfPercia\\pop" + i + ".jpg");
        });

        b3.setOnAction((e) -> {
            Main.scene.setRoot(new Siatka());
            Card.image = new Image("Images\\Assassin\\as" + i + ".jpg");
        });

        b4.setOnAction((e) -> {
            Main.scene.setRoot(new Siatka());
            Card.image = new Image("Images\\Cats\\cf" + i + ".jpg");
        });

        b5.setOnAction((e) -> {
            Main.scene.setRoot(new Siatka());
            Card.image = new Image("Images\\Daz\\Daz" + i + ".jpg");
        });


        Button b = new Button("Go to menu");

        b.setLayoutX(0);
        b.setLayoutY(0);

        b.setOnAction(e -> Main.scene.setRoot(new Menu()));

        getChildren().add(b);

    }

}
