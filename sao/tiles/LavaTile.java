package dev.matthew.sao.tiles;

import dev.matthew.sao.gfx.Assets;

public class LavaTile extends Tile{
    public LavaTile( int id) {
        super(Assets.lava, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }

}