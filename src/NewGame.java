import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Collections;

public class NewGame extends Group {
    public NewGame() {
        Button b = new Button("Go to menu");

        b.setLayoutX(0);
        b.setLayoutY(0);

        b.setOnAction(e -> {
            Main.scene.setRoot(new Menu());
        });

        getChildren().add(b);


        Text text = new Text();
        text.setText("Time: 0s");
        text.setX(400);
        text.setY(10);
        text.setFont(Font.font("Verdana", 11));
        text.setFill(Color.AQUAMARINE);

        getChildren().add(text);

        Thread contTime = new Thread(() -> {
            int i = 0;
            while (!Thread.interrupted()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
                i++;
                text.setText("Time: " + i + "s");
            }
        });
        contTime.start();


        Card.cards.clear();
        for (int i = 0; i < 8; i++) {
            Card.cards.add(new Card(i));
            Card.cards.add(new Card(i));
        }
        Collections.shuffle(Card.cards);


        for (int i = 0, k = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++, k++) {
                Card card = Card.cards.get(k);
                card.setLayoutX(100 * j + 30);
                card.setLayoutY(100 * i + 30);
                getChildren().add(card);
            }
        }
    }

    public static void win() {
        TextInputDialog td = new TextInputDialog("enter your name");
        td.setHeaderText("! ! !   YOU WON   ! ! !");
        td.showAndWait();
        System.out.println(td.getEditor().getText());
        Main.scene.setRoot(new Menu());
    }
}
