package dev.matthew.sao;

import dev.matthew.sao.gfx.GameCamera;
import dev.matthew.sao.input.KeyManager;
import dev.matthew.sao.input.MouseManager;
import dev.matthew.sao.worlds.World;

public class Handler {

    private Game game;
    private World world;

    public Handler(Game game){
        this.game = game;
    }

    //getters and setters
    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }
    public int getWidth(){
        return game.getWidth();
    }
    public int getHeight(){
        return game.getHeight();
    }
    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }
    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }
    public Game getGame(){
        return game;
    }
    public void setGame(Game game){
        this.game = game;
    }
    public World getWorld(){
        return world;
    }
    public void setWorld(World world){
        this.world = world;
    }
}
