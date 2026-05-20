package controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.event.ActionEvent;
public class MenuController {

    @FXML
public void switchToJornada(ActionEvent event) {
    System.out.println("Botão Jornada clicado");
}

    @FXML
    private ImageView bgImage;

    @FXML
    private StackPane rootPane;

@FXML
public void initialize() {

    Image image = new Image(
        getClass()
        .getResourceAsStream(
            "/AVC/src/main/resources/imagens/camp_bg.png"
        )
    );

    bgImage.setImage(image);

    bgImage.setFitWidth(1280);
    bgImage.setFitHeight(720);
}
}

