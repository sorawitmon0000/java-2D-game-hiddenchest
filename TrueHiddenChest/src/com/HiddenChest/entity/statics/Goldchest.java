package com.HiddenChest.entity.statics;

import com.HiddenChest.Handler;
import com.HiddenChest.graphic.Assets;
import com.HiddenChest.item.Item;
import com.HiddenChest.tile.Tile;

import java.awt.*;

public class Goldchest extends StaticEntity{
    public Goldchest(Handler handler, float x, float y){
        super(handler,x,y, Tile.tilewidth,Tile.tileheight);

        bounds.x=15;       // ตำแหน่งฮิตบ็อกคกน x
        bounds.y=15;       // ตำแหน่งฮิตบ็อคแกน y
        bounds.width=32;   // ความกว้างฮิตบ็อค
        bounds.height=32;  // ความสูงฮิตบ็อค


    }
    public void die(){
        System.out.println("Attacked");

        handler.getMap().getItemManager().addItem(Item.goldApple.createNew((int) x+30,(int) y+50));
        System.out.println(health);


    }
    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.goldchest, (int) (x-handler.getGameCamera().getxOffset()),(int) (y-handler.getGameCamera().getyOffset()),width,height,null);
    }
}
