package com.HiddenChest.inventory;

import com.HiddenChest.Handler;
import com.HiddenChest.entity.creatures.Player;
import com.HiddenChest.item.Item;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
/*
    คลาสเก็บไอเทมที่ดรอป
 */

public class Inventory {

    private Handler handler;
    private boolean active = false;
    private ArrayList<Item> inventoryItems;

    public Inventory(Handler handler){
        this.handler=handler;
        inventoryItems = new ArrayList<Item>();
    }
    public void update(){
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
            active = !active;
        if(!active)
            return;
        System.out.println("Invent");
        for(Item i : inventoryItems){
            System.out.println(i.getName() + " " + i.getCount());
        }

    }
    public void render(Graphics g){
        if(!active)
            return;
    }
    // inventory method

    public void addItem(Item item){
        for(Item i : inventoryItems){
            if(i.getId() == item.getId()){
                i.setCount(i.getCount() + item.getCount());
                return;
            }
        }
        inventoryItems.add(item);
    }

    // getter setter

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<Item> getInventoryItems() {
        return inventoryItems;
    }


}
