package dev.matthew.sao.display;

import javax.swing.JFrame;
import java.awt.*;


public class Display {

    private JFrame frame;
    private Canvas canvas;

    private String title;
    private int width, height;

    //constructor
    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
    }


    //makes dev.matthew.sao.display method
    private void createDisplay(){

        //makes Jframe
        frame = new JFrame(title);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //Makes canvas
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        //adds canvas
        frame.add(canvas);
        frame.pack();
    }

    //gets canvas
    public Canvas getCanvas(){
        return canvas;
    }

    public JFrame getFrame(){
        return frame;
    }
}
