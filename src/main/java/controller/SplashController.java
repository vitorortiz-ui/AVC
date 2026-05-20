package controller;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image; 
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SplashController {

    @FXML private VBox rootPane;
    @FXML private VBox logoContainer;
    @FXML private ImageView logoImage;
    @FXML private Label subtitleLabel;
    @FXML private Rectangle blackOverlay;

    private Stage primaryStage;

    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }

    @FXML
    public void initialize() {
        try {
            Image logo = new Image(getClass().getResourceAsStream("/com/mycompany/avc/imagens/logo.png"));
            logoImage.setImage(logo);
        } catch (Exception e) {
            System.err.println("Logo não encontrada: " + e.getMessage());
        }

        blackOverlay.widthProperty().bind(rootPane.widthProperty());
        blackOverlay.heightProperty().bind(rootPane.heightProperty());
    }

    public void startAnimation() {
        SequentialTransition sequence = new SequentialTransition(
            pauseFor(800),
            fadeInLogo(),
            pauseFor(400),
            fadeInSubtitle(),
            pauseFor(1800),
            pulseEffect(),
            pauseFor(600),
            fadeOutAll(),
            pauseFor(600)
        );

        sequence.setOnFinished(e -> transitionToGame());
        sequence.play();
    }

    private PauseTransition pauseFor(double millis) {
        return new PauseTransition(Duration.millis(millis));
    }

    private ParallelTransition fadeInLogo() {
        FadeTransition overlayFade = new FadeTransition(Duration.millis(1200), blackOverlay);
        overlayFade.setFromValue(1.0);
        overlayFade.setToValue(0.0);

        FadeTransition logoFade = new FadeTransition(Duration.millis(1200), logoContainer);
        logoFade.setFromValue(0.0);
        logoFade.setToValue(1.0);

        ScaleTransition logoScale = new ScaleTransition(Duration.millis(1400), logoContainer);
        logoScale.setFromX(0.85); logoScale.setFromY(0.85);
        logoScale.setToX(1.0);   logoScale.setToY(1.0);
        logoScale.setInterpolator(Interpolator.EASE_OUT);

        return new ParallelTransition(overlayFade, logoFade, logoScale);
    }

    private FadeTransition fadeInSubtitle() {
        subtitleLabel.setText("");
        FadeTransition ft = new FadeTransition(Duration.millis(900), subtitleLabel);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        return ft;
    }

    private SequentialTransition pulseEffect() {
        ScaleTransition up1 = new ScaleTransition(Duration.millis(180), logoContainer);
        up1.setToX(1.06); up1.setToY(1.06);

        ScaleTransition down1 = new ScaleTransition(Duration.millis(180), logoContainer);
        down1.setToX(1.0); down1.setToY(1.0);

        PauseTransition beat = new PauseTransition(Duration.millis(120));

        ScaleTransition up2 = new ScaleTransition(Duration.millis(140), logoContainer);
        up2.setToX(1.04); up2.setToY(1.04);

        ScaleTransition down2 = new ScaleTransition(Duration.millis(200), logoContainer);
        down2.setToX(1.0); down2.setToY(1.0);
        down2.setInterpolator(Interpolator.EASE_OUT);

        return new SequentialTransition(up1, down1, beat, up2, down2);
    }

    private ParallelTransition fadeOutAll() {
        FadeTransition overlayIn = new FadeTransition(Duration.millis(1000), blackOverlay);
        overlayIn.setFromValue(0.0);
        overlayIn.setToValue(1.0);
        overlayIn.setInterpolator(Interpolator.EASE_IN);

        FadeTransition logoOut = new FadeTransition(Duration.millis(900), logoContainer);
        logoOut.setFromValue(1.0);
        logoOut.setToValue(0.0);

        ScaleTransition logoScaleOut = new ScaleTransition(Duration.millis(1000), logoContainer);
        logoScaleOut.setToX(0.95); logoScaleOut.setToY(0.95);

        return new ParallelTransition(overlayIn, logoOut, logoScaleOut);
    }

  private void transitionToGame() {
    try {

        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("/com/mycompany/avc/Menu.fxml")
        );

        Scene gameScene = new Scene(loader.load());
        gameScene.setFill(Color.BLACK);

        StackPane root = (StackPane) gameScene.getRoot();
        root.setOpacity(0.0);

        primaryStage.setScene(gameScene);

        FadeTransition fadeIn = new FadeTransition(Duration.millis(800), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
 
    } catch (Exception e) {
        e.printStackTrace(); // ← mostra erro real
    }
}
}