package dev.matthew.sao.inventory;

import dev.matthew.sao.*;
import dev.matthew.sao.gfx.Assets;
import dev.matthew.sao.items.Item;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Inventory {

    private Handler handler;
    private boolean active = false;
    private ArrayList<Item> inventoryItems;
    private final int invX = 0, invY = 0,
            InvWidth = 640, InvHeight = 360, ;

    public Inventory(Handler handler){
        this.handler = handler;
        inventoryItems = new ArrayList<Item>();

        addItem(Item.rockItem.createNew(5));
        addItem(Item.woodItem.createNew(5));
    }

    public void tick(){
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_E)){
            active = !active;
        }
        if (!active){
            return;
        }

    }

    public void render(Graphics g){
        if (!active){
            return;
        }

        g.drawImage(Assets.inventoryScreen, invX, invY, InvWidth, InvHeight, null);
    }

    //inventory methods
    public void addItem(Item item){
        for (Item i : inventoryItems){
            if (i.getId() == item.getId()){
                i.setCount(i.getCount() + item.getCount());
                return;
            }
        }
        inventoryItems.add(item);
    }

    //getter & setters
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
