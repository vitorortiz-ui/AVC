package controller;

import com.mycompany.avc.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class SkillsController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
