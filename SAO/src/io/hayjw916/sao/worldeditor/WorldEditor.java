package io.hayjw916.sao.worldeditor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class WorldEditor extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        MainView mainView = new MainView();

        Scene scene = new Scene(mainView, 650, 450); // possibly increase size
        primaryStage.setTitle("GAO - World Editor");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        mainView.draw();
    }
}
