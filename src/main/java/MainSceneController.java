import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.util.StringConverter;

public class MainSceneController {

    @FXML private Canvas canvas3;
    @FXML private TextField rTextField3;
    @FXML private ComboBox<Length> rFactorComboBox3;
    @FXML private Label rErrorLabel3;
    @FXML private TextField aTextField3;
    @FXML private ComboBox<Number> aFactorComboBox3;
    @FXML private Label aErrorLabel3;
    @FXML private TextField qTextField3;
    @FXML private ComboBox<Charge> qFactorComboBox3;

    @FXML private Canvas canvas4;
    @FXML private TextField lambdaTextField4;
    @FXML private ComboBox<LinearChargeDensity> lambdaFactorComboBox4;
    @FXML private Label lambdaErrorLabel4;
    @FXML private TextField rTextField4;
    @FXML private ComboBox<Length> rFactorComboBox4;
    @FXML private Label rErrorLabel4;
    @FXML private TextField eTextField4;
    @FXML private ComboBox<ElectricField> eFactorComboBox4;

    @FXML
    private void initialize() {
        GraphicsContext context = canvas3.getGraphicsContext2D();
        context.setStroke(Color.BLACK);
        context.setLineWidth(3);
        context.strokeOval(20, 20, 160, 160);
        context.beginPath();
        context.moveTo(100, 0);
        context.lineTo(100, 200);
        context.stroke();
        context.beginPath();
        context.moveTo(100, 100);
        context.lineTo(48, 48);
        context.lineTo(48 + 7, 48 + 2);
        context.lineTo(48 + 1, 48 + 8);
        context.lineTo(48 - 1, 48);
        context.stroke();
        context.setFont(Font.font("Comic Sans MS", 20));
        context.fillText("Q", 110, 130);
        context.fillText("R", 50, 80);


        context = canvas4.getGraphicsContext2D();
        context.setStroke(Color.BLACK);
        context.setLineWidth(3);
        context.strokeArc(20, 20, 160, 160, 0, 90, ArcType.OPEN);
        context.beginPath();
        context.moveTo(100, 100);
        context.lineTo(50, 150);
        context.lineTo(50 + 7, 150 - 2);
        context.lineTo(50 + 1, 150 - 8);
        context.lineTo(50 - 1, 150);
        context.stroke();
        context.beginPath();
        context.moveTo(100, 100);
        context.lineTo(175, 90);
        context.lineTo(175 - 8, 90 - 2);
        context.lineTo(175 - 6, 90 + 4);
        context.lineTo(175, 90);
        context.stroke();
        context.setFont(Font.font("Comic Sans MS", 20));
        context.fillText("λ", 160, 40);
        context.fillText("R", 160, 120);
        context.fillText("E", 50, 170);


        aFactorComboBox3.getItems().setAll(Number.values());
        aFactorComboBox3.setConverter(new StringConverter<Number>() {
            @Override
            public String toString(Number number) {
                return (number == null ? null : number.getLabel());
            }

            @Override
            public Number fromString(String s) {
                return null;
            }
        });
        aFactorComboBox3.valueProperty().addListener((obs, o, n) -> submit3());

        rFactorComboBox3.getItems().setAll(Length.values());
        rFactorComboBox3.setConverter(new StringConverter<Length>() {
            @Override
            public String toString(Length length) {
                return (length == null ? null : length.getLabel());
            }

            @Override
            public Length fromString(String s) {
                return null;
            }
        });
        rFactorComboBox3.valueProperty().addListener((obs, o, n) -> submit3());

        qFactorComboBox3.getItems().setAll(Charge.values());
        qFactorComboBox3.setConverter(new StringConverter<Charge>() {
            @Override
            public String toString(Charge charge) {
                return (charge == null ? null : charge.getLabel());
            }

            @Override
            public Charge fromString(String s) {
                return null;
            }
        });
        qFactorComboBox3.getSelectionModel().select(0);
        qFactorComboBox3.valueProperty().addListener((obs, o, n) -> submit3());


        lambdaFactorComboBox4.getItems().setAll(LinearChargeDensity.values());
        lambdaFactorComboBox4.setConverter(new StringConverter<LinearChargeDensity>() {
            @Override
            public String toString(LinearChargeDensity linearChargeDensity) {
                return (linearChargeDensity == null ? null : linearChargeDensity.getLabel());
            }

            @Override
            public LinearChargeDensity fromString(String s) {
                return null;
            }
        });
        lambdaFactorComboBox4.valueProperty().addListener((obs, o, n) -> submit4());

        rFactorComboBox4.getItems().setAll(Length.values());
        rFactorComboBox4.setConverter(new StringConverter<Length>() {
            @Override
            public String toString(Length length) {
                return (length == null ? null : length.getLabel());
            }

            @Override
            public Length fromString(String s) {
                return null;
            }
        });
        rFactorComboBox4.valueProperty().addListener((obs, o, n) -> submit4());

        eFactorComboBox4.getItems().setAll(ElectricField.values());
        eFactorComboBox4.setConverter(new StringConverter<ElectricField>() {
            @Override
            public String toString(ElectricField electricField) {
                return (electricField == null ? null : electricField.getLabel());
            }

            @Override
            public ElectricField fromString(String s) {
                return null;
            }
        });
        eFactorComboBox4.getSelectionModel().select(0);
        eFactorComboBox4.valueProperty().addListener((obs, o, n) -> submit4());


        rTextField3.textProperty().addListener((obs, o, n) -> submit3());
        aTextField3.textProperty().addListener((obs, o, n) -> submit3());
        qTextField3.textProperty().addListener((obs, o, n) -> submit3());

        rTextField4.textProperty().addListener((obs, o, n) -> submit4());
        lambdaTextField4.textProperty().addListener((obs, o, n) -> submit4());
        eTextField4.textProperty().addListener((obs, o, n) -> submit4());
    }


    private Double validateR3Field() {
        Length rFactor = rFactorComboBox3.getValue();
        if (rFactor == null) {
            rErrorLabel3.setText("выберите размерность");
            return null;
        } else {
            rErrorLabel3.setText("");
        }

        String rText = rTextField3.getText();
        try {
            double rValue = Double.parseDouble(rText);
            rErrorLabel3.setText("");
            return rValue * rFactor.getFactor();
        } catch (NumberFormatException e) {
            rErrorLabel3.setText("введите число");
            return null;
        }
    }

    private Double validateA3Field() {
        Number aFactor = aFactorComboBox3.getValue();
        if (aFactor == null) {
            aErrorLabel3.setText("выберите размерность");
            return null;
        } else {
            aErrorLabel3.setText("");
        }

        String aText = aTextField3.getText();
        try {
            double aValue = Double.parseDouble(aText);
            aErrorLabel3.setText("");
            return aValue * aFactor.getFactor();
        } catch (NumberFormatException e) {
            aErrorLabel3.setText("введите число");
            return null;
        }
    }

    private void submit3() {
        Double rValue = validateR3Field();
        Double aValue = validateA3Field();
        if (rValue != null && aValue != null) {
            computeAnswer3(aValue, rValue);
        }
    }

    @FXML
    private void answerButton3MouseClicked(MouseEvent event) {
        submit3();
    }

    private static final Double k = 9e9;

    private void computeAnswer3(Double a, Double r) {
        qTextField3.setText(String.valueOf(
                ((a * r) / k) * qFactorComboBox3.getValue().getFactor()
        ));
    }

    private Double validateLambda4Field() {
        LinearChargeDensity lambdaFactor = lambdaFactorComboBox4.getValue();
        if (lambdaFactor == null) {
            lambdaErrorLabel4.setText("выберите размерность");
            return null;
        } else {
            lambdaErrorLabel4.setText("");
        }

        String lambdaText = lambdaTextField4.getText();
        try {
            double lambdaValue = Double.parseDouble(lambdaText);
            lambdaErrorLabel4.setText("");
            return lambdaValue * lambdaFactor.getFactor();
        } catch (NumberFormatException e) {
            lambdaErrorLabel4.setText("введите число");
            return null;
        }
    }

    private Double validateR4Field() {
        Length rFactor = rFactorComboBox4.getValue();
        if (rFactor == null) {
            rErrorLabel4.setText("выберите размерность");
            return null;
        } else {
            rErrorLabel4.setText("");
        }

        String rText = rTextField4.getText();
        try {
            double rValue = Double.parseDouble(rText);
            rErrorLabel4.setText("");
            return rValue * rFactor.getFactor();
        } catch (NumberFormatException e) {
            rErrorLabel4.setText("введите число");
            return null;
        }
    }

    private void submit4() {
        Double lambdaValue = validateLambda4Field();
        Double rValue = validateR4Field();
        if (lambdaValue != null && rValue != null) {
            computeAnswer4(lambdaValue, rValue);
        }
    }

    @FXML
    private void answerButton4MouseClicked(MouseEvent event) {
        submit4();
    }

    private void computeAnswer4(Double lambda, Double r) {
        eTextField4.setText(String.valueOf(
                ((Math.sqrt(2) * k * lambda) / r) * eFactorComboBox4.getValue().getFactor()
        ));
    }


}
