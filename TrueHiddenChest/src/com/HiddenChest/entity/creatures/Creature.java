package com.HiddenChest.entity.creatures;

import com.HiddenChest.Handler;
import com.HiddenChest.Panel;
import com.HiddenChest.entity.Entity;
import com.HiddenChest.tile.Tile;
/*
    คลาสที่ควบคุม การเดินไปตามแกน เช็คcollision
 */

public abstract class Creature extends Entity {

    protected float speed;
    protected float xMove , yMove;


    public static final float Default_speed=4.0f;   // ความเร็วตอนเดิน

    public static final int Default_width=64;   // ความกว้างของตัวละครเอาไปใช้ต่อใน player
    public static final int Default_height=64;  // ความสูงของตัวละครไปใช้ต่อใน player

    public Creature(Handler handler, float x, float y, int width, int height){
        super(handler,x,y,width,height);
        speed=Default_speed;
        xMove=0;
        yMove=0;
    }
    // การเคลื่อนที่เอา 2 method ล่างมาใช้
    public void move(){
       if (!checkEntityCollision(xMove,0f))
            moveX();
       if(!checkEntityCollision(0f,yMove))
            moveY();

    }
    // เคลื่อนที่ตามแกน x
    public void moveX(){
        if(xMove > 0){ // เดินขวา + เช็ค collision
            int tx= (int) ( x + xMove + bounds.x + bounds.width )/ Tile.tilewidth;
            if(!collision( tx , (int) (y+bounds.y) / Tile.tileheight ) &&
                    !collision(tx, (int) (y + bounds.y+ bounds.height)/Tile.tileheight)){
                x+=xMove;
            }
        }
        else if(xMove < 0){ // เดินซ้าย + เช็ค collision
            int tx= (int) ( x + xMove + bounds.x  )/ Tile.tilewidth;
            if(!collision( tx , (int) (y+bounds.y) / Tile.tileheight ) &&
                    !collision(tx, (int) (y + bounds.y+ bounds.height)/Tile.tileheight)){
                x+=xMove;
            }
        }
    }
    // เคลื่อนที่ตามแกน y
    public void moveY(){
        if(yMove < 0 ){ // เดินขึ้น + เช็ค collision
            int ty=(int) (y + yMove + bounds.y) / Tile.tileheight;
            if(!collision((int) (x + bounds.x) / Tile.tilewidth,ty) &&
                    !collision((int) (x + bounds.x + bounds.width) / Tile.tilewidth,ty) ){
                y+=yMove;
            }
        }
        else if(yMove > 0){ // เดินลง + เช็ค collision
            int ty=(int) (y + yMove + bounds.y + bounds.height) / Tile.tileheight;
            if(!collision((int) (x + bounds.x) / Tile.tilewidth,ty) &&
                    !collision((int) (x + bounds.x + bounds.width) / Tile.tilewidth,ty) ){
                y+=yMove;
            }
        }
    }
    // ตัวเช็ค collision
    protected boolean collision(int x ,int y){
        return handler.getMap().getTile(x,y).isSolid();
    }

    // -------------------------------------------------------------------------------------------------

     // getter setter
    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
