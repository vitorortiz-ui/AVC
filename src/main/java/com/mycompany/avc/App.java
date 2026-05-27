package com.mycompany.avc;


import controller.SplashController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader =
                new FXMLLoader(App.class.getResource(
                        "/com/mycompany/avc/SplashScreen.fxml"
                ));

        Parent root = loader.load();

        scene = new Scene(root);
        scene.setFill(javafx.scene.paint.Color.BLACK);

        SplashController controller = loader.getController();
        controller.setPrimaryStage(stage);

        stage.setScene(scene);
        stage.setTitle("AVC - An Average Campaign");
        stage.show();

        controller.startAnimation();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {

    String caminho = "/com/mycompany/avc/" + fxml + ".fxml";

    System.out.println("Tentando carregar: " + caminho);

    var url = App.class.getResource(caminho);

    System.out.println("URL encontrada: " + url);

    FXMLLoader fxmlLoader = new FXMLLoader(url);

    return fxmlLoader.load();
}

    public static void main(String[] args) {
        launch();
    }
}