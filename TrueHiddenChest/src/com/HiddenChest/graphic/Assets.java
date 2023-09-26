
package com.HiddenChest.graphic;

import java.awt.image.BufferedImage;
/*
      คลาสเซ็ทรูปที่ crop มา
 */

public class Assets {
    private static final int width=32;
    private static final int height=32;
    public static BufferedImage glass,stone,water,sand,woodplate,woodwater,bluebrick,redbrick,lava,watersand,
                                    staircaseRight,headstaircaseRight,staircaseLeft,headstaircaseLeft,upstaircaseRight,upstaircaseLeft,headupstaircaseRight,headupstaircaseLeft;
    public static BufferedImage tree1,tree2,tree3,rock1,rock2,rock3,pop,goldchest,fakechest,bombchest,truechest;
    public static BufferedImage[] player_up ,  player_down ,  player_left ,  player_right , player_nothing;
    public static BufferedImage[] bt_start;
    public static void init(){

        SpriteSheet MapSheet = new SpriteSheet(ImageLoader.loadImage("C:\\Users\\mon_9_vv4cmmb\\OneDrive\\เอกสาร\\TrueHiddenChest\\Resourcse\\textures\\HiddenChestMap.png"));
        SpriteSheet entitySheet = new SpriteSheet(ImageLoader.loadImage("C:\\Users\\mon_9_vv4cmmb\\OneDrive\\เอกสาร\\TrueHiddenChest\\Resourcse\\textures\\TrueEntitySheet.png"));

        // button
        bt_start = new BufferedImage[2];
        bt_start[0]=entitySheet.crop(width*2,height*7,width*6,height*2);
        bt_start[1]=entitySheet.crop(width*8,height*7,width*6,height*2);

        // player
        player_up = new BufferedImage[4];
        player_down = new BufferedImage[4];
        player_left = new BufferedImage[4];
        player_right = new BufferedImage[4];
        player_nothing = new BufferedImage[1];
        player_nothing[0] = entitySheet.crop(width*8,0,width*2,height*2);
        player_up[0] = entitySheet.crop(0,0,width*2,height*2);
        player_up[1] = entitySheet.crop(width*2,0,width*2,height*2);
        player_up[2] = entitySheet.crop(width*4,0,width*2,height*2);
        player_up[3] = entitySheet.crop(width*6,0,width*2,height*2);
        player_down[0] = entitySheet.crop(width*8,0,width*2,height*2);
        player_down[1] = entitySheet.crop(width*10,0,width*2,height*2);
        player_down[2] = entitySheet.crop(width*12,0,width*2,height*2);
        player_down[3] = entitySheet.crop(0,height*2,width*2,height*2);
        player_left[0] = entitySheet.crop(width*8,0,width*2,height*2);
        player_left[1] = entitySheet.crop(width*10,0,width*2,height*2);
        player_left[2] = entitySheet.crop(width*12,0,width*2,height*2);
        player_left[3] = entitySheet.crop(0,height*2,width*2,height*2);
        player_right[0] = entitySheet.crop(0,0,width*2,height*2);
        player_right[1] = entitySheet.crop(width*2,0,width*2,height*2);
        player_right[2] = entitySheet.crop(width*4,0,width*2,height*2);
        player_right[3] = entitySheet.crop(width*6,0,width*2,height*2);

        // entity
        tree1=entitySheet.crop(0,height*5,width*2,height*2);
        tree2=entitySheet.crop(width*2,height*5,width*2,height*2);
        tree3=entitySheet.crop(width*4,height*5,width*2,height*2);
        rock1=entitySheet.crop(width*6,height*5,width*2,height*2);
        rock2=entitySheet.crop(width*8,height*5,width*2,height*2);
        rock3=entitySheet.crop(width*10,height*5,width*2,height*2);
        pop=entitySheet.crop(0,height*7,width*2,height*2);
        goldchest=entitySheet.crop(width*2,height*9,width*2,height*2);
        fakechest=entitySheet.crop(0,height*9,width*2,height*2);
        bombchest=entitySheet.crop(0,height*9,width*2,height*2);
        truechest=entitySheet.crop(0,height*9,width*2,height*2);

        // tileMap
        glass=MapSheet.crop(0,0,width,height);
        stone=MapSheet.crop(width,0,width,height);
        water=MapSheet.crop(width*2,0,width,height);
        sand=MapSheet.crop(0,width,width,height);
        woodplate=MapSheet.crop(width,height,width,height);
        woodwater=MapSheet.crop(width*2,height,width,height);
        bluebrick=MapSheet.crop(width*8,height,width,height);
        redbrick=MapSheet.crop(width*8,0,width,height);
        lava=MapSheet.crop(width*10,0,width,height);
        staircaseRight=MapSheet.crop(width*9,height,width,height);
        headstaircaseRight=MapSheet.crop(width*9,0,width,height);
        staircaseLeft=MapSheet.crop(width*7,height,width,height);
        headstaircaseLeft=MapSheet.crop(width*7,0,width,height);
        upstaircaseRight=MapSheet.crop(width*6,height,width,height);
        upstaircaseLeft=MapSheet.crop(width*5,height,width,height);
        headupstaircaseRight=MapSheet.crop(width*6,0,width,height);
        headupstaircaseLeft=MapSheet.crop(width*5,0,width,height);
    }
}
