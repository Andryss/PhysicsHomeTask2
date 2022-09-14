import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Optional;

public class Toolkit {

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
        confirmWindow.setHeaderText(null);
        warningWindow.setHeaderText(null);
        errorWindow.setHeaderText(null);
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

}
