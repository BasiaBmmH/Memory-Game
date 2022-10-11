package GameFiles;

import javafx.animation.FadeTransition;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;


public class Card extends Button {
    int id;
    boolean isSelected = false;
    static String path;
    Image image;
    public static List<Card> cards = new ArrayList<>();
    public static Card oldSelected = null;

    FadeTransition fade;

    public Card(int i) {
        super();
        id = i;

        image = new Image("Images\\" + path + i + ".jpg");
        ImageView view = new ImageView(image);
        view.setFitHeight(70);
        view.setFitWidth(70);

        setPrefSize(90, 90);

        view.setOpacity(0);
        setGraphic(view);

        //region fade out
        fade = new FadeTransition();
        fade.setDuration(Duration.seconds(1));
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.setNode(view);
        //endregion


        setOnAction(e -> {
            fade.pause();
            if (isSelected) {
                view.setOpacity(0);
                oldSelected = null;
            } else {
                view.setOpacity(1);
                if (oldSelected == null) oldSelected = this;
                else {
                    if (oldSelected.id == id) {
                        NewGame.addPoints();
                        setDisable(true);
                        oldSelected.setDisable(true);
                    } else {
                        fade.playFromStart();
                        oldSelected.fade.playFromStart();
                        isSelected = !isSelected;
                        oldSelected.isSelected = false;
                    }
                    oldSelected = null;
                }
            }
            isSelected = !isSelected;
        });
    }
}