package dev.matthew.sao.entites.Creature.player;

import dev.matthew.sao.Handler;
import dev.matthew.sao.entites.Creature.Creature;
import dev.matthew.sao.gfx.Animation;
import dev.matthew.sao.gfx.Assets;

import javax.swing.event.AncestorEvent;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {

    //animation
    private Animation animDown, animUp, animLeft,animRight;


    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 14;
        bounds.y = 22;
        bounds.width = 32;
        bounds.height =40;

        //animation
        animDown = new Animation(500, Assets.player_down);
        animUp = new Animation(500, Assets.player_up);
        animLeft = new Animation(500, Assets.player_left);
        animRight = new Animation(500, Assets.player_right);
    }

    @Override
    public void tick() {
        //animation
        animDown.tick();
        animUp.tick();
        animLeft.tick();
        animRight.tick();
        //movement
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up){
            yMove = -speed;
        }
        if(handler.getKeyManager().down){
            yMove = speed;
        }
        if(handler.getKeyManager().left){
            xMove = -speed;
        }
        if(handler.getKeyManager().right){
            xMove = speed;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffSet()), (int) (y - handler.getGameCamera().getyOffSet()), width, height, null);

        g.setColor(Color.red);
        //g.fillRect((int) (x+ bounds.x - handler.getGameCamera().getxOffSet()),(int) (y+ bounds.y - handler.getGameCamera().getyOffSet()),
         //       bounds.width, bounds.height);

    }

    private BufferedImage getCurrentAnimationFrame(){
        if (xMove < 0){
            return animLeft.getCurrentFrame();
        }else if (xMove > 0){
            return animRight.getCurrentFrame();
        }else if (yMove < 0 ){
            return animUp.getCurrentFrame();
        }else if (yMove > 0){
            return animDown.getCurrentFrame();
        }else {
            return animLeft.getCurrentFrame();
        }
    }
}