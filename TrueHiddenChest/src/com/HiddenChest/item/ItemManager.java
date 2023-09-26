package com.HiddenChest.item;

import com.HiddenChest.Handler;
import com.HiddenChest.entity.creatures.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
/*
    คลาสจัดการไอเทม
 */
public class ItemManager {
    private Handler handler;
    private ArrayList<Item> items;

    public ItemManager(Handler handler){
        this.handler=handler;
        items = new ArrayList<Item>();
    }

    public void update(){
        Iterator<Item> it = items.iterator();
        while (it.hasNext()){
            Item i = it.next();
            i.update();
            if(i.isPickUp())
                it.remove();

        }


    }
    public void render(Graphics g){
        for(Item i : items)
            i.render(g);
    }
    public void addItem(Item i){
        i.setHandler(handler);
        items.add(i);
    }
    //getter setter
    public Handler getHandler() {
        return handler;
    }
    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
