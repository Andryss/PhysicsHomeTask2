package application;

import builder.SceneBuilder;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.InputStream;

public class App extends Application {

    @Override
    public void start(Stage stage) {

        stage.setScene(SceneBuilder.Companion.getInstance().getScene());

        stage.setTitle("Мой дорогой дневник");
        stage.setResizable(false);
        loadIcon(stage, "icon.png");

        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    @SuppressWarnings("SameParameterValue")
    private void loadIcon(Stage stage, String icon) {
        try (InputStream stream = getClass().getResourceAsStream(icon)){
            if (stream != null) stage.getIcons().add(new Image(stream));
        } catch (Throwable e) {
            // no icon :(
        }
    }

}
