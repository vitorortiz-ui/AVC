package controller;
 
import com.mycompany.avc.App;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.event.ActionEvent;
import java.io.File;
import java.io.IOException;
 import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
public class MenuController {
 
  @FXML
private void switchToJornada(ActionEvent event) throws IOException {

    FXMLLoader loader = new FXMLLoader(
        App.class.getResource("/com/mycompany/avc/Jornada.fxml")
    );

    Parent root = loader.load();

    Stage stage = (Stage) ((Node) event.getSource())
            .getScene()
            .getWindow();

    stage.setScene(new Scene(root));

    stage.show();

    System.out.println("TELA TROCADA");
}

@FXML
private void switchToSkills(ActionEvent event) throws IOException {

    FXMLLoader loader = new FXMLLoader(
        App.class.getResource("/com/mycompany/avc/Skills.fxml")
    );

    Parent root = loader.load();

    Stage stage = (Stage) ((Node) event.getSource())
            .getScene()
            .getWindow();

    stage.setScene(new Scene(root));

    stage.show();

    System.out.println("TELA TROCADA");
}
 
 @FXML
private void switchToRanking(ActionEvent event) throws IOException {

    FXMLLoader loader = new FXMLLoader(
        App.class.getResource("/com/mycompany/avc/Skills.fxml")
    );

    Parent root = loader.load();

    Stage stage = (Stage) ((Node) event.getSource())
            .getScene()
            .getWindow();

    stage.setScene(new Scene(root));

    stage.show();

    System.out.println("TELA TROCADA");
}

@FXML
private void switchToCreditos(ActionEvent event) throws IOException {

    FXMLLoader loader = new FXMLLoader(
        App.class.getResource("/com/mycompany/avc/Skills.fxml")
    );

    Parent root = loader.load();

    Stage stage = (Stage) ((Node) event.getSource())
            .getScene()
            .getWindow();

    stage.setScene(new Scene(root));

    stage.show();

    System.out.println("TELA TROCADA");
}
    
 @FXML
private void sairDoJogo() {
    System.exit(0);
}
    @FXML
    private ImageView bgImage;
 
    @FXML
    private StackPane rootPane;
 
    @FXML
    public void initialize() {
        // Tenta pelo classpath primeiro
        var url = getClass().getResource("/imagens/camp_bg.png");
        System.out.println("Classpath URL: " + url);
 
        if (url != null) {
            bgImage.setImage(new Image(url.toExternalForm()));
        } else {
            // Fallback: caminho absoluto no disco
            File f = new File("src/main/resources/imagens/camp_bg.png");
            System.out.println("Arquivo existe? " + f.exists() + " | Path: " + f.getAbsolutePath());
            if (f.exists()) {
                bgImage.setImage(new Image(f.toURI().toString()));
            } else {
                System.out.println("❌ Imagem não encontrada em lugar nenhum!");
                return;
            }
        }
 
        bgImage.setFitWidth(1280);
        bgImage.setFitHeight(720);
        bgImage.setPreserveRatio(false);
        bgImage.toBack();
    }
}
