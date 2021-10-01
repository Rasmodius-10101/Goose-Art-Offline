package dev.matthew.sao;

public class Launcher {

    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true"); // Allows the game to run smoother on linux

        Game game = new Game("Goose Art Offline", 640, 360);
        game.start();
    }

}
