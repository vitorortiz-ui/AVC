package controller;

import com.mycompany.avc.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class RankinController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}