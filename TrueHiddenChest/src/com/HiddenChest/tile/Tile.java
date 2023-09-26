package com.HiddenChest.tile;

import java.awt.*;
import java.awt.image.BufferedImage;

/*
    คลาสรับรูปภาพ map และกำหนดไอดีให้แต่ละภาพ
 */

public class Tile {
    // เซ็ตไอดีของภาพ---------
    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new GrassTile(1);
    public static Tile stoneTile = new StoneTile(0);
    public static Tile waterTile = new WaterTile(2);
    public static Tile sandTile = new SandTile(3);
    public static Tile woodplateTile = new WoodPlateTile(4);
    public static Tile woodwaterTile = new WoodWaterTile(5);
    public static Tile bluebrickTile = new BlueBrickTile(6);
    public static Tile redbrickTile = new RedBrickTile(7);
    public static Tile lavaTile = new LavaTile(8);
    public static Tile staircaseRightTile = new StaircaseRightTile(10);
    public static Tile headstaircaseRightTile = new HeadStaircaseRightTile(11);
    public static Tile staircaseLeftTile = new StaircaseLeftTile(12);
    public static Tile headstaircaseLeftTile = new HeadStaircaseLeftTile(13);
    public static Tile upstaircaseRightTile = new UpStaircaseRightTile(14);
    public static Tile upstaircaseLeftTile = new UpStaircaseLeftTile(15);
    public static Tile headupstaircaseRightTile = new HeadUpStaircaseRightTile(16);
    public static Tile headupstaircaseLeftTile = new HeadUpStaircaseLeftTile(17);
    // class----------------
    protected BufferedImage texture;
    protected final int id;
    public static final int tilewidth = 64;
    public static final int tileheight = 64;
    public Tile(BufferedImage texture,int id){
        this.texture=texture;
        this.id=id;
        tiles[id]=this;
    }
    public void update(){

    }
    public void render(Graphics g,int x,int y){
        g.drawImage(texture,x,y,tilewidth,tileheight,null);
    }
    public boolean isSolid(){
        return false;
    }
    public int getId() {
        return id;
    }
}
