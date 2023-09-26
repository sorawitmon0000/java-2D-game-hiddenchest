package com.HiddenChest.item;

import com.HiddenChest.Handler;
import com.HiddenChest.entity.creatures.Player;
import com.HiddenChest.graphic.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Item {
   // Handler
    public static Item[] items = new Item[256];
    public static Item goldApple = new Item(Assets.pop,"GoldApple",0);

   // Class
    public static final int itemWidth = 32 , itemHeight = 32;
    protected Handler handler;
    protected BufferedImage texture;
    protected String name;
    protected final int id;
    protected int x,y,count;
    protected Rectangle bounds;
    protected boolean pickUp = false;

    public Item(BufferedImage texture,String name,int id){
        this.texture=texture;
        this.name=name;
        this.id=id;
        count=1;
        bounds= new Rectangle(x,y,itemWidth,itemHeight);
        items[id] = this;
    }

    public void update(){
        if(handler.getMap().getEntityManager().getPlayer().getCollisionBounds(0f,0f).intersects(bounds)){
           pickUp = true;
           handler.getMap().getEntityManager().getPlayer().getInventory().addItem(this);
        }
        ///////////////////////
        if(pickUp==true){
            handler.getMap().getEntityManager().getPlayer().setHealth(5);
        }
    }
    public void render(Graphics g){
        if(handler==null)
            return;
        render(g,(int) (x - handler.getGameCamera().getxOffset()), (int) (y- handler.getGameCamera().getyOffset()));
    }
    public void render(Graphics g,int x,int y){
        g.drawImage(texture,x,y,itemWidth,itemHeight,null);
    }
    public Item createNew(int x,int y){
        Item i = new Item(texture,name,id);
        i.setPosition(x,y);
        return i;
    }
    public void setPosition(int x,int y){
        this.x=x;
        this.y=y;
        bounds.x=x;
        bounds.y=y;
    }




    // getter setter
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isPickUp() {
        return pickUp;
    }

    public void setPickUp(boolean pickUp) {
        this.pickUp = pickUp;
    }
}
