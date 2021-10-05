package dev.matthew.sao.inventory;

import dev.matthew.sao.*;
import dev.matthew.sao.gfx.Assets;
import dev.matthew.sao.gfx.Text;
import dev.matthew.sao.items.Item;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Inventory {

    private Handler handler;
    private boolean active = false;
    private ArrayList<Item> inventoryItems;
    private int invX = 0, invY = 0,
            InvWidth = 640, InvHeight = 360,
            XCenter =invX + 95, YCenter = invY + 175, invListingSpacing =60;
    private int invImageX =197, invImageY = 50, invImageWidth = 64, invImageHeight= 64;
    private int invCountX = 230, invCountY = 137;

    private int selectedItem = 0;

    public Inventory(Handler handler){
        this.handler = handler;
        inventoryItems = new ArrayList<Item>();
        
    }

    public void tick(){
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_E)){
            active = !active;
        }
        if (!active){
            return;
        }


        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_W)){
            selectedItem--;
        }
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_S)){
            selectedItem++;
        }

        if(selectedItem < 0){
            selectedItem = inventoryItems.size()-1;
        }else if (selectedItem >= inventoryItems.size()){
            selectedItem = 0;
        }
    }

    public void render(Graphics g){
        if (!active){
            return;
        }

        g.drawImage(Assets.inventoryScreen, invX, invY, InvWidth, InvHeight, null);

        int len = inventoryItems.size();
        if(len == 0){
            return;
        }

        for (int i = -5; i < 6;i++){
            if (selectedItem + i < 0 || selectedItem + i >= len){
                continue;
            }
            if(i == 0) {
                Text.drawString(g,"> "+ inventoryItems.get(selectedItem + i).getName() + " <",
                        XCenter, YCenter + i * invListingSpacing, true, Color.WHITE, Assets.font28);
            }else {
                Text.drawString(g,inventoryItems.get(selectedItem + i).getName(),
                        XCenter, YCenter + i * invListingSpacing, true, Color.WHITE, Assets.font28);
            }
        }

        Item item = inventoryItems.get(selectedItem);
        g.drawImage(item.getTexture(), invImageX, invImageY,invImageWidth, invImageHeight,null);
        Text.drawString(g, Integer.toString(item.getCount()), invCountX, invCountY, true, Color.WHITE,  Assets.font28);
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
