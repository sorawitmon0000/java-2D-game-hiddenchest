package com.HiddenChest.entity.statics;

import com.HiddenChest.Handler;
import com.HiddenChest.graphic.Assets;
import com.HiddenChest.tile.Tile;

import java.awt.*;

public class Rock1 extends StaticEntity {
    public Rock1(Handler handler, float x, float y){
        super(handler,x,y, Tile.tilewidth*2,Tile.tileheight*2);

        bounds.x=20;       // ตำแหน่งฮิตบ็อกคกน x
        bounds.y=20;       // ตำแหน่งฮิตบ็อคแกน y
        bounds.width=85;   // ความกว้างฮิตบ็อค
        bounds.height=70;  // ความสูงฮิตบ็อค
        this.health=10;

    }
    public void die(){
        System.out.println("Attacked");

        //handler.getMap().getItemManager().addItem(Item.woodItem.createNew((int) x+64,(int) y+100));
        System.out.println(health);

        // System.exit(0);
    }
    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.rock1, (int) (x-handler.getGameCamera().getxOffset()),(int) (y-handler.getGameCamera().getyOffset()),width,height,null);
    }
}
