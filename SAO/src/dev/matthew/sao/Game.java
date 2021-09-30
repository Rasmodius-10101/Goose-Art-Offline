package dev.matthew.sao;

import dev.matthew.sao.display.Display;
import dev.matthew.sao.gfx.Assets;
import dev.matthew.sao.gfx.GameCamera;
import dev.matthew.sao.input.KeyManager;
import dev.matthew.sao.input.MouseManager;

import java.awt.*;
import java.awt.image.BufferStrategy;


public class Game implements Runnable {

    private Display display;
    private int width, height;
    public String title;
    private Thread thread;
    private boolean running = false;
    private BufferStrategy bs;
    private Graphics g;

    //States
    public State gameState;
    public State menuState;
    public State settingsState;

    //input
    private KeyManager keyManager;
    private MouseManager mouseManager;

    //camera
    private GameCamera gameCamera;

    //Handler
    private Handler handler;

    //constructor
    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }

    private void init(){
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();

        handler = new Handler(this);
        gameCamera = new GameCamera(handler, 0,0);

        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        settingsState = new SettingsState(handler);
        State.setState(menuState);

    }

    //tick
    private void tick(){
        keyManager.tick();

        if(State.getState() != null){
            State.getState().tick();
        }

    }

    //renders
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        //clear Screen
        g.clearRect(0, 0, width, height);

        //draw here

        if(State.getState() != null){
            State.getState().render(g);
        }

        //end drawing
        bs.show();
        g.dispose();
    }

    //runnable
    public void run(){

        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;


            if(delta >=1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if (timer >= 1000000000){
                System.out.println("ticks and frames :: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }


    //input getters
    public KeyManager getKeyManager(){
        return keyManager;
    }
    public MouseManager getMouseManager(){
        return mouseManager;
    }

    //getters
    public GameCamera getGameCamera(){
        return gameCamera;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    //thread start
    public synchronized void start(){
        //just in case
        if(running) return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }
    //thread stop
    public synchronized void stop(){

        if(!running) return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
