package io.hayjw916.sao.worldeditor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WorldEditor extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(WorldEditor.class.getResource("WorldEditor.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        primaryStage.setTitle("GAO - World Editor");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
