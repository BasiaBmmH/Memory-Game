package Old;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Siatka extends Group {

    public Siatka() {

        Text text = new Text();
        text.setText(" Choose size of the board:");
        text.setX(22);
        text.setY(22);
        text.setFont(Font.font("Verdana",25));
        text.setFill(Color.AQUAMARINE);

        getChildren().add(text);

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 6, 0, 2);
        Spinner<Integer> spinner = new Spinner<>();
        spinner.setLayoutX(150);
        spinner.setLayoutY(150);
        spinner.setValueFactory(valueFactory);
        getChildren().add(spinner);

        Button b1 = new Button("Accept");
        b1.setLayoutX(260);
        b1.setLayoutY(235);
        getChildren().add(b1);
        b1.setOnAction(e -> Main.scene.setRoot(new NewGame(spinner.getValue())));
    }
}
