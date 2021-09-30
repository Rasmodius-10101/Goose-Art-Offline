package dev.matthew.sao.worlds;

import dev.matthew.sao.Handler;
import dev.matthew.sao.entites.Creature.player.Player;
import dev.matthew.sao.entites.EntityManager;
import dev.matthew.sao.entites.statics.Tree;
import dev.matthew.sao.tiles.Tile;
import dev.matthew.sao.utils.Utils;
import java.awt.*;

public class World {

    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;
    //Entities
    private EntityManager entityManager;

    //consturtor
    public World(Handler handler, String path){
        this.handler = handler;
        entityManager = new EntityManager(handler, new Player(handler, 100, 100));
        entityManager.addEntity(new Tree(handler, 100, 200));

        loadWorld(path);

        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
    }

    //tick
    public void tick(){
        entityManager.tick();
    }

    //render
    public void render(Graphics g){
        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffSet() / Tile.TILE_WIDTH);
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffSet() + handler.getWidth())/ Tile.TILE_WIDTH + 1);
        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffSet() / Tile.TILE_HEIGHT);
        int yEnd = (int) Math.min(width, (handler.getGameCamera().getyOffSet() + handler.getHeight())/ Tile.TILE_HEIGHT + 1);

        for (int y = yStart; y < yEnd;y++){
            for (int x = xStart; x < xEnd;x++){
                getTile(x,y).render(g, (int)(x*Tile.TILE_WIDTH - handler.getGameCamera().getxOffSet()),
                        (int)( y*Tile.TILE_HEIGHT - handler.getGameCamera().getyOffSet()));
            }
        }
        entityManager.render(g);
    }

    //gets tile
    public Tile getTile(int x, int y){
        if(x < 0 || y < 0 || x>= width|| y >= height){
            return Tile.grassTile;
        }

        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null){
            return Tile.dirtTile;
        }
        return t;
    }

    //loads world
    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for (int y = 0; y< height; y++){
            for (int x = 0; x < width; x++){
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width)+4]);

            }
        }
    }

    //getter setter
    public int getWidth() {
        return width;
    }
    public int getHeight(){
        return height;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
