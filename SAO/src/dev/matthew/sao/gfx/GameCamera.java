package dev.matthew.sao.gfx;

import dev.matthew.sao.Handler;
import dev.matthew.sao.entites.Entity;
import dev.matthew.sao.tiles.Tile;

public class GameCamera {

        private Handler handler;
    private float xOffSet, yOffSet;

    public GameCamera(Handler handler, float xOffSet, float yOffSet){
        this.handler= handler;
        this.xOffSet = xOffSet;
        this.yOffSet = yOffSet;
    }

    public void checkBlankSpace(){
        if(xOffSet < 0){
            xOffSet = 0;
        }else if (xOffSet> handler.getWorld().getWidth()* Tile.TILE_WIDTH- handler.getWidth()){
            xOffSet = handler.getWorld().getWidth()* Tile.TILE_WIDTH- handler.getWidth();
        }
        if(yOffSet < 0){
            yOffSet = 0;
        }else if(yOffSet>handler.getWorld().getHeight()* Tile.TILE_HEIGHT- handler.getHeight()){
            yOffSet = handler.getWorld().getHeight()* Tile.TILE_HEIGHT- handler.getHeight();
        }

    }

    public void centerOnEntity(Entity e){
        xOffSet = e.getX() - handler.getWidth() / 2 + e.getWidth()/2;
        yOffSet = e.getY() - handler.getHeight() / 2 + e.getHeight()/2;
        checkBlankSpace();
    }

    public void move(float xAmt, float yAmt){
        xOffSet += xAmt;
        yOffSet += yAmt;
        checkBlankSpace();
    }

    //getters and setters
    public float getxOffSet(){
        return xOffSet;
    }
    public void setxOffSet(int xOffSet){
        this.xOffSet = xOffSet;
    }
    public float getyOffSet(){
        return yOffSet;
    }
    public void setyOffSet(float yOffSet){
        this.yOffSet = yOffSet;
    }
}
