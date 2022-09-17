package application;

import generator.JokeGenerator;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

public class Toolkit {

    private static final Alert infoWindow = new Alert(Alert.AlertType.INFORMATION);
    public static void showInfoWindow(String title, String contextText) {
        infoWindow.setTitle(title);
        infoWindow.setContentText(contextText);
        infoWindow.show();
    }

    private static final Alert confirmWindow = new Alert(Alert.AlertType.CONFIRMATION);
    public static Optional<ButtonType> showConfirmWindow(String title, String contextText) {
        confirmWindow.setTitle(title);
        confirmWindow.setContentText(contextText);
        confirmWindow.resultProperty().set(null);
        return confirmWindow.showAndWait();
    }

    private static final Alert warningWindow = new Alert(Alert.AlertType.WARNING);
    public static void showWarningWindow(String title, String contextText) {
        warningWindow.setTitle(title);
        warningWindow.setContentText(contextText);
        warningWindow.show();
    }

    private static final Alert errorWindow = new Alert(Alert.AlertType.ERROR);
    public static void showErrorWindow(String title, String contextText) {
        errorWindow.setTitle(title);
        errorWindow.setContentText(contextText);
        errorWindow.show();
    }

    static {
        for (Alert alert: List.of(infoWindow, confirmWindow, warningWindow, errorWindow)) {
            alert.setHeaderText(null);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        }
    }

    private static final DateFormat formatter = new SimpleDateFormat("-yyyy-MM-dd-HH-mm-ss-SSS");
    public static void showUserError(Throwable throwable) {
        showErrorWindow(
                "Ошибка",
                "Упс... Видимо, злые гоблины обрезали какие-то провода... Попробуйте снова позже"
        );
        try {
            File file = new File("errStackTrace" + formatter.format(System.currentTimeMillis()));
            if (file.createNewFile()) {
                try (PrintStream stream = new PrintStream(file)) {
                    // And now we can send stackTrace to the server
                    // COMING SOON ... (no, I'm lazy)
                    // Let's just print stackTrace into a file
                    throwable.printStackTrace(stream);
                }
            } // Else sadness :(
        } catch (IOException e) {
            // Also, sadness :(
        }
    }

    public static void showUserJoke() {
        showInfoWindow("Анекдот", JokeGenerator.Companion.getInstance().generate());
    }

}
