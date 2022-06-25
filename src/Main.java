import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    public static Scene scene;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {

        Group root = new Menu();

        stage.setResizable(false);
//        stage.setFullScreen(true);
//        stage.setFullScreenExitHint("if u want to escape press q");
//        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));
        stage.getIcons().setAll(new Image("Images\\Daz\\Daz1.jpg"));
        stage.setTitle("Memory");

        scene =  new Scene(root, 500, 500);
        scene.setFill(Color.BURLYWOOD);
        stage.setScene(scene);
        stage.show();
    }
}
