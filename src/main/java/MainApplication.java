import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class MainApplication extends Application {

    public void start(Stage stage) {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScene.fxml"));

        try {
            Scene scene = new Scene(loader.load());

            stage.setScene(scene);

            stage.setTitle("Мой дорогой дневник");
            stage.setResizable(false);

            try (InputStream stream = getClass().getResourceAsStream("icon.png")){
                if (stream != null) {
                    stage.getIcons().add(new Image(stream));
                }
            }

            stage.show();
        } catch (IOException e) {
            Toolkit.showUserError(e);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
