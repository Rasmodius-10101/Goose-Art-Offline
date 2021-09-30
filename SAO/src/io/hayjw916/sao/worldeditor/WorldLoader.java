package io.hayjw916.sao.worldeditor;

import dev.matthew.sao.utils.Utils;
import javafx.scene.canvas.GraphicsContext;

/**The whole point of WorldLoader is to load the world using javafx libraries*/
public class WorldLoader {

    private static int width;
    private static int height;
    private static int spawnX;
    private static int spawnY;
    private static int[][] tiles;

    public static void loadWorld(String path) {
        String file = Utils.loadFileAsString(path);
        String[] token = file.split("\\s+");
        width = Integer.parseInt(token[0]);
        height = Integer.parseInt(token[1]);
        spawnX = Integer.parseInt(token[2]);
        spawnY = Integer.parseInt(token[3]);

        tiles = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = Utils.parseInt(token[(x + y * width) + 4]);
            }
        }
    }

    public static void render(GraphicsContext g) {
     //   g.drawImage(image, x, y, 64, 64);
    }

}
