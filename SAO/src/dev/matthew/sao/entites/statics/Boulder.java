package dev.matthew.sao.entites.statics;

import dev.matthew.sao.Handler;
import dev.matthew.sao.gfx.Assets;
import dev.matthew.sao.items.Item;
import dev.matthew.sao.tiles.Tile;

import java.awt.*;

public class Boulder extends StaticEntity{

    public Boulder(Handler handler, float x, float y){
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);

        bounds.x = 20;
        bounds.y = 0;
        bounds.width = 25;
        bounds.height = 5;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

        //g.fillRect((int) (x+ bounds.x - handler.getGameCamera().getxOffSet()),(int) (y+ bounds.y - handler.getGameCamera().getyOffSet()),
               //bounds.width, bounds.height);
        g.drawImage(Assets.boulder, (int) (x - handler.getGameCamera().getxOffSet()), (int) (y - handler.getGameCamera().getyOffSet()), width, height , null);
    }

    @Override
    public void die() {
        handler.getWorld().getItemManager().addItem(Item.rockItem.createNew((int) x,(int) y));
    }
}
