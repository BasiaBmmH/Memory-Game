import javafx.animation.FadeTransition;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class Card extends Button {
    int id;
    boolean isSelected =false;
    Image image;
    public static List<Card> cards = new ArrayList<>();
    public static Card oldSelected = null;
    public static int points = 0;

    FadeTransition fade;

    public Card(int i){
        super();
        id = i;

        image = new Image("Images\\Daz\\Daz" + i + ".jpg");
        ImageView view = new ImageView(image);
        view.setFitHeight(70);
        view.setFitWidth(70);

        setPrefSize(90,90);

        view.setOpacity(0);
        setGraphic(view);
        //region fade out
        fade = new FadeTransition();
        fade.setDuration(Duration.seconds(1));
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.setNode(view);
        //endregion


        setOnAction(e->{
            fade.pause();
            if(isSelected) {
                view.setOpacity(0);
                oldSelected = null;
            }
            else {
                //setGraphic(view);
                view.setOpacity(1);
                if(oldSelected == null) oldSelected = this;
                else {
                    if(oldSelected.id == id){
                        points++;
                        setDisable(true);
                        oldSelected.setDisable(true);

                        if(points >= 1) NewGame.win();
                    }
                    else {
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
