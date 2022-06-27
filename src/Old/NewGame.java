package Old;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class NewGame extends Group {
    public static List<Score> scores = new LinkedList<>();
    public static int points = 0;

    private static int size;
    private static int time = 0;

    public NewGame(int size) {
        this.size = size;
        Button b = new Button("Go to menu");

        b.setLayoutX(0);
        b.setLayoutY(0);

        b.setOnAction(e -> Main.scene.setRoot(new Menu()));

        getChildren().add(b);


        Text text = new Text();
        text.setText("Time: 0s");
        text.setX(400);
        text.setY(10);
        text.setFont(Font.font("Verdana", 11));
        text.setFill(Color.AQUAMARINE);

        getChildren().add(text);

        Thread contTime = new Thread(() -> {
            while (!Thread.interrupted()) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    return;
                }
                text.setText("Time: " + ++time + "s");
            }
        });
        contTime.start();


        Card.cards.clear();
        for (int i = 0; i < size * size / 2; i++) {

            Card.cards.add(new Card(i));
            Card.cards.add(new Card(i));
        }
        Collections.shuffle(Card.cards);


        for (int i = 0, k = 0; i < size; i++) {
            for (int j = 0; j < size; j++, k++) {
                Card card = Card.cards.get(k);
                card.setLayoutX(100 * j + 30);
                card.setLayoutY(100 * i + 30);
                getChildren().add(card);
            }
        }

        //wyjscie z gry skrotem klawiszowym
        setOnKeyPressed(event -> {
            if (new KeyCodeCombination(KeyCode.Q, KeyCombination.SHIFT_DOWN, KeyCombination.CONTROL_DOWN).match(event)) {
                Main.scene.setRoot(new Menu());
            }
        });
    }

    public static void win() {
        TextInputDialog td = new TextInputDialog("enter your name");
        td.setHeaderText("! ! !   YOU WON   ! ! !");
        td.showAndWait();
        String name = td.getEditor().getText();
        addScore(name);
        Main.scene.setRoot(new Menu());
        Saving.save();
    }

    public static void addPoints() {
        points++;
        if (points >= size * size / 2) {
            win();
        }
    }

    public static void addScore(String name) {

        scores.add(new Score(name, points));
    }
}