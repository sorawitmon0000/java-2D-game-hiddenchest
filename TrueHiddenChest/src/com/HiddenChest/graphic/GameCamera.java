package com.HiddenChest.graphic;

import com.HiddenChest.Handler;
import com.HiddenChest.Panel;
import com.HiddenChest.entity.Entity;
import com.HiddenChest.tile.Tile;
/*
    คลาสจับภาพบริเวณหน้าจอ
 */
public class GameCamera {
    private Handler handler;
    private float xOffset , yOffset;
    public GameCamera(Handler handler,float xOffset, float yOffset){
        this.handler=handler;
        this.xOffset=xOffset;
        this.yOffset=yOffset;
    }
    // ลบพื้นที่สีขาว
    public void checkBlankspace(){
        if(xOffset < 0){
            xOffset=0;
        }
        else if(xOffset > handler.getMap().getWidth() * Tile.tilewidth - handler.getWidth()){
            xOffset = handler.getMap().getWidth() * Tile.tilewidth - handler.getWidth();
        }
        if(yOffset < 0){
            yOffset=0;
        }
        else if(yOffset > handler.getMap().getHeight() * Tile.tileheight - handler.getHeight()){
            yOffset = handler.getMap().getHeight() * Tile.tileheight - handler.getHeight();
        }
    }
    public void centerOnEntity(Entity e){
        xOffset=e.getX()-handler.getWidth()/2 + e.getWidth()/2;
        yOffset=e.getY()-handler.getHeight()/2 + e.getHeight()/2;
        checkBlankspace();
    }
    public void move(float xamount,float yamount){
        xOffset += xamount;
        yOffset += yamount;
        checkBlankspace();
    }
    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }

    public float getxOffset() {
        return xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }
}
