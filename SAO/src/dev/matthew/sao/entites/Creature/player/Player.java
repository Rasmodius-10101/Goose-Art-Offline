package dev.matthew.sao.entites.Creature.player;

import dev.matthew.sao.Handler;
import dev.matthew.sao.entites.Creature.Creature;
import dev.matthew.sao.entites.Entity;
import dev.matthew.sao.gfx.Animation;
import dev.matthew.sao.gfx.Assets;
import dev.matthew.sao.inventory.Inventory;

import javax.swing.event.AncestorEvent;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {

    //animation
    private Animation animDown, animUp, animLeft,animRight;
    // attack timer
    private long lastAttackTimer, attackCooldown= 800, attackTimer = attackCooldown;

    //inventory
    private Inventory inventory;


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

        inventory = new Inventory(handler);
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
        //attack
        checkAttacks();
        //inventory
        inventory.tick();
    }

    private void checkAttacks(){
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();

        if(attackTimer< attackCooldown){
            return;
        }

        Rectangle cb = getCollisionBounds(0,0);
        Rectangle ar = new Rectangle();
        int arSize = 20;
        ar.width = arSize;
        ar.height = arSize;

        if (handler.getKeyManager().aUp){
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y - arSize;
        } else if (handler.getKeyManager().aDown){
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height;
        }else if (handler.getKeyManager().aLeft){
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        }else if (handler.getKeyManager().aRight){
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        }else {
            return;
        }

        attackTimer = 0;

        for (Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this)){
                continue;
            }
            if (e.getCollisionBounds(0,0).intersects(ar)){
                e.hurt(1);
                return;
            }
        }

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

        //g.setColor(Color.red);
        //g.fillRect((int) (x+ bounds.x - handler.getGameCamera().getxOffSet()),(int) (y+ bounds.y - handler.getGameCamera().getyOffSet()),
         //       bounds.width, bounds.height);

    }

    public void postRender(Graphics g){
        inventory.render(g);
    }

    @Override
    public void die() {
        System.out.println("You Lose");
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

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
