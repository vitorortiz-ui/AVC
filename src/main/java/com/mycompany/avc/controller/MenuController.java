package com.mycompany.avc.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class MenuController {
  

    @FXML private ImageView bgImage;
    @FXML private StackPane rootPane;
  @FXML
    private void switchToJornada(ActionEvent event) {
        System.out.println("Botão Jornada clicado");
    }

  

    
@FXML
public void initialize() {

    // BACKGROUND
    var stream = getClass().getResourceAsStream(
            "/com/mycompany/avc/imagens/camp_bg.png"
    );

    System.out.println("BG = " + stream);

    if (stream != null) {
        bgImage.setImage(new Image(stream));
    }

    // CSS
    var css = getClass().getResource(
            "/com/mycompany/avc/estilo.css"
    );

    System.out.println("CSS = " + css);

    if (css != null) {
        rootPane.getStylesheets().add(css.toExternalForm());
    }
}
}