package controller;

import java.io.IOException;
import javafx.fxml.FXML;

import com.mycompany.avc.App;

public class JornadaController {

    @FXML
    private void switchToJornada() throws IOException {
        
       App.setRoot("primary");
    }
}