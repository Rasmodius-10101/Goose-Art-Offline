package dev.matthew.sao.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 32, height = 31;
    public static BufferedImage dirt, grass, stone, lava, tree;
    public static BufferedImage wood, boulder;
    public static BufferedImage[] player_down, player_left,player_right,player_up;
    public static BufferedImage[] buttonStart;

    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/SpriteSheet2.png"));
        SpriteSheet menuSheet = new SpriteSheet(ImageLoader.loadImage("/Menus/StartButton.png"));

        //player
        player_down = new BufferedImage[2];
        player_up = new BufferedImage[2];
        player_left = new BufferedImage[2];
        player_right = new BufferedImage[2];

        buttonStart = new BufferedImage[2];
        buttonStart[0] = menuSheet.crop(1, 126, 249, 124);
        buttonStart[1] = menuSheet.crop(0, 0, 250, 125);

        player_down[0]= sheet.crop(0,height*2+2, width, height);
        player_down[1]= sheet.crop(width,height*2+2, width, height);

        player_up[0]= sheet.crop(width*2,height*2+2, width, height);
        player_up[1]= sheet.crop(width*3,height*2+2, width, height);

        player_left[0]= sheet.crop(width*2,(height+1)*3, width, height);
        player_left[1]= sheet.crop(width*3,(height+1)*3, width, height);

        player_right[0]= sheet.crop(0,(height+1)*3, width, height);
        player_right[1]= sheet.crop(width,(height+1)*3, width, height);

        //tiles
        grass = sheet.crop(width,1, width, height);
        dirt = sheet.crop(width*2,0, width, height);
        stone = sheet.crop(width*3,0, width, height);
        lava = sheet.crop(0,height +1, width, height);

        //entities
        tree = sheet.crop(0,0, width, height);
        wood = sheet.crop(width, height + 1, width , height);
        boulder = sheet.crop(width*2, height + 1, width , height);

    }
}
