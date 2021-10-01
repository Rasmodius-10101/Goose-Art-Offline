package dev.matthew.sao.entites.statics;

import dev.matthew.sao.Handler;
import dev.matthew.sao.gfx.Assets;
import dev.matthew.sao.tiles.Tile;

import java.awt.*;

public class Tree extends StaticEntity{

    public Tree (Handler handler, float x, float y){
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT*2);

        bounds.x = 20;
        bounds.y = -62;
        bounds.width = 19;
        bounds.height = 18;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

        //g.fillRect((int) (x+ bounds.x - handler.getGameCamera().getxOffSet()),(int) (y+ bounds.y - handler.getGameCamera().getyOffSet()),
        //       bounds.width, bounds.height);
        g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffSet()), (int) (y - handler.getGameCamera().getyOffSet()), width, height , null);
    }

    @Override
    public void die() {

    }
}
