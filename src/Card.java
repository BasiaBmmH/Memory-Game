import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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


    public Card(int i){
        super();
        id = i;

        image = new Image("Images\\Daz\\Daz" + i + ".jpg");
        ImageView view = new ImageView(image);
        view.setFitHeight(70);
        view.setFitWidth(70);

        setPrefSize(90,90);

        setOnAction(e->{
            if(isSelected) {
                setGraphic(null);
                oldSelected = null;
            }
            else {
                setGraphic(view);
                if(oldSelected == null) oldSelected = this;
                else {
                    if(oldSelected.id == id){
                        points++;
                        setDisable(true);
                        oldSelected.setDisable(true);
                    }
                    else {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        setGraphic(null);
                        oldSelected.setGraphic(null);

                        oldSelected.isSelected = false;
                    }
                    oldSelected = null;
                }
            }
            isSelected = !isSelected;
        });
    }
}
