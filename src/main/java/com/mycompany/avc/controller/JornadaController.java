package com.mycompany.avc;

import java.io.IOException;
import javafx.fxml.FXML;

public class JornadaController {

    @FXML
    private void switchToJornada() throws IOException {
        App.setRoot("primary");
    }
}