package dev.matthew.sao.entites.statics;

import dev.matthew.sao.Handler;
import dev.matthew.sao.entites.Entity;

public abstract class StaticEntity extends Entity {

    public StaticEntity(Handler handler , float x, float y, int width, int height){
        super(handler, x, y, width, height);
    }

}
