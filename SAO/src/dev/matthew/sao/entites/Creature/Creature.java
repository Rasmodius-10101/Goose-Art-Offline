package dev.matthew.sao.entites.Creature;

import dev.matthew.sao.Handler;
import dev.matthew.sao.entites.Entity;
import dev.matthew.sao.tiles.Tile;

public abstract class Creature extends Entity {

    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 64, DEFAULT_CREATURE_HEIGHT = 64;

    protected int health;
    protected float speed;
    protected float xMove, yMove;

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width,height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    public void move(){
        if(!checkEntityCollisions(xMove, 0f)) {
            moveX();
        }
        if(!checkEntityCollisions(0f, yMove)) {
            moveY();
        }
    }

    public void moveX(){
        if(xMove>0){

            int tx= (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
            if(!collisionWithTile(tx, (int) (y + bounds.y)/Tile.TILE_HEIGHT) &&
                    !collisionWithTile(tx, (int) (y+bounds.y+bounds.height)/Tile.TILE_HEIGHT)){
                x += xMove;
            }else {
                x = tx * Tile.TILE_WIDTH - bounds.x - bounds.width-1;

            }

        }else if(xMove<0){
            int tx= (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;
            if(!collisionWithTile(tx, (int) (y + bounds.y)/Tile.TILE_HEIGHT) &&
                    !collisionWithTile(tx, (int) (y+bounds.y+bounds.height)/Tile.TILE_HEIGHT)){
                x += xMove;
            }else {
                x = tx * Tile.TILE_WIDTH + Tile.TILE_WIDTH-bounds.x;
            }
        }

    }

    public void moveY(){

        if(yMove < 0){//up
            int ty = (int) (y + yMove + bounds.y)/ Tile.TILE_HEIGHT;

            if(!collisionWithTile((int) (x + bounds.x)/Tile.TILE_WIDTH, ty) &&
                    !collisionWithTile((int) (x + bounds.x+bounds.width)/Tile.TILE_WIDTH, ty)){
                y +=yMove;
            }else {
                y = ty * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT-bounds.y;
            }

        }else if(yMove > 0){//down
            int ty = (int) (y + yMove + bounds.y + bounds.height)/ Tile.TILE_HEIGHT;

            if(!collisionWithTile((int) (x + bounds.x)/Tile.TILE_WIDTH, ty) &&
                    !collisionWithTile((int) (x + bounds.x + bounds.width)/Tile.TILE_WIDTH, ty)){
                y +=yMove;
            }else {
                y = ty * Tile.TILE_HEIGHT - bounds.y - bounds.height - 1 ;
            }

        }

    }

    protected boolean collisionWithTile(int x, int y){
        return handler.getWorld().getTile(x,y).isSolid();
    }

    //getters and setters
    //x and y move
    public float getxMove(){
        return xMove;
    }
    public void setxMove(int health){
        this.xMove = xMove;
    }
    public float getyMove(){
        return yMove;
    }
    public void setyMove(float yMove){
        this.yMove = yMove;
    }

    //health
    public float getHealth(){
        return health;
    }
    public void setHealth(int health){
        this.health = height;
    }

    //speed
    public float getSpeed(){
        return speed;
    }
    public void setSpeed(float speed){
        this.speed = speed;
    }

}
