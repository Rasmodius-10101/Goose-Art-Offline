package io.hayjw916.sao.worldeditor;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MainView extends VBox {

    private MenuBar menuBar;
    private Menu file;

    private Canvas canvas;

    public MainView() {
        this.canvas = new Canvas(650, 800);
        file = new Menu("File");
        menuBar = new MenuBar(file);

        this.getChildren().addAll(menuBar, canvas);
    }

    public void draw() {
        GraphicsContext g = canvas.getGraphicsContext2D();

        g.setFill(Color.LIGHTGRAY);
        g.fillRect(0,0,650,800);

    }
}
