package dev.matthew.sao.tiles;

import dev.matthew.sao.gfx.Assets;

public class RockTile extends Tile{
    public RockTile( int id) {
        super(Assets.stone, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }

}
