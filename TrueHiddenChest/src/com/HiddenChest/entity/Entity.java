package com.HiddenChest.entity;

import com.HiddenChest.Handler;
import com.HiddenChest.Panel;

import java.awt.*;
/*
    คลาสแม่แบบวัตถุบนแมพ
 */
public abstract class Entity {
    protected float x,y;
    protected int width,height;
    protected int health;
    public static final int Default_health=1;      // เลือด
    protected Handler handler;
    protected Rectangle bounds;
    public boolean active= true; //ถ้า ฟ คือหายจากแมพ
    public Entity(Handler handler,float x,float y,int width,int height){
        this.handler=handler;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        bounds=new Rectangle(0,0,width,height);
        health=Default_health;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }
    public abstract void update();
    public abstract void render(Graphics g);

    public abstract void die();
    public void hurt(int amt){
        health-=amt;
        if(health <= 0)
            active=false;
        die();
    }

    public boolean checkEntityCollision(float xOffset,float yOffset){
        for(Entity e : handler.getMap().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0f,0f).intersects(getCollisionBounds(xOffset, yOffset)))
                return true;
        }
        return false;
    }

    public Rectangle getCollisionBounds(float xOffset,float yOffset){
        return new Rectangle((int) (x+bounds.x+xOffset),(int) (y+bounds.y+yOffset),bounds.width,bounds.height);
    }



    //getter setter
    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health += health;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public static int getDefault_health(int hp) {
        return Default_health+hp;
    }
}
