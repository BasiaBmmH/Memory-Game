package Old;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static Old.ChooseImage.number;

public class Siatka extends Group {

    public Siatka() {

        Text text = new Text();
        text.setText(" Choose size of the board:");
        text.setX(100);
        text.setY(22);
        text.setFont(Font.font("Verdana", 25));
        text.setFill(Color.AQUAMARINE);

        getChildren().add(text);

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 6, 0, 2);
        Spinner<Integer> spinner = new Spinner<>();
        spinner.setLayoutX(150);
        spinner.setLayoutY(150);
        spinner.setValueFactory(valueFactory);
        getChildren().add(spinner);

        Button b1 = new Button("Accept");
        b1.setLayoutX(150);
        b1.setLayoutY(177);
        getChildren().add(b1);

        b1.setOnAction(e -> Main.scene.setRoot(new NewGame(spinner.getValue())));

        Button b = new Button("Go to menu");
        Button c = new Button("Go back to choosing");

        b.setLayoutX(0);
        b.setLayoutY(0);

        c.setLayoutX(0);
        c.setLayoutY(27);

        b.setOnAction(e -> Main.scene.setRoot(new Menu()));
        c.setOnAction(e -> Main.scene.setRoot(new ChooseImage()));

        getChildren().add(b);
        getChildren().add(c);

    }

}
