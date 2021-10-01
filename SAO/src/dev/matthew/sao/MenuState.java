package dev.matthew.sao;

import dev.matthew.sao.display.Display;
import dev.matthew.sao.gfx.Assets;
import dev.matthew.sao.gfx.ImageLoader;
import dev.matthew.sao.ui.ClickListener;
import dev.matthew.sao.ui.UIImageButton;
import dev.matthew.sao.ui.UIManager;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;

public class MenuState extends State{

    private Graphics g;
    private BufferedImage GAO, RClick;
    private UIManager uiManager;

    public MenuState(Handler handler){
        super(handler);
        GAO = ImageLoader.loadImage("/Menus/GOOSE.png");
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        uiManager.addObject(new UIImageButton(250, 250, 128, 64, Assets.buttonStart, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(handler.getGame().gameState);
            }
        }));
    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(GAO, 0,0 , null);
        uiManager.render(g);
    }
}
