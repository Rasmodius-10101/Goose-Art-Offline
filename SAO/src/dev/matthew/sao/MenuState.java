package dev.matthew.sao;

import dev.matthew.sao.display.Display;
import dev.matthew.sao.gfx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;

public class MenuState extends State{
    private Graphics g;
    private BufferedImage GAO, RClick;


    public MenuState(Handler handler){
        super(handler);
        GAO = ImageLoader.loadImage("/Menus/GOOSE.png");


    }

    @Override
    public void tick() {
        if(handler.getMouseManager().isLeftPressed()){
            State.setState(handler.getGame().gameState);
        }
    }

    @Override
    public void render(Graphics g) {


        g.drawImage(GAO, 0,0 , null);

        g.setColor(Color.red);
        g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 25,25);
    }
}
