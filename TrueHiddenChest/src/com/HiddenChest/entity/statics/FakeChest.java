package com.HiddenChest.entity.statics;

import com.HiddenChest.Handler;
import com.HiddenChest.graphic.Assets;
import com.HiddenChest.item.Item;
import com.HiddenChest.tile.Tile;

import java.awt.*;

public class FakeChest extends StaticEntity {
    public FakeChest(Handler handler, float x, float y){
        super(handler,x,y, Tile.tilewidth,Tile.tileheight);

        bounds.x=15;       // ตำแหน่งฮิตบ็อกคกน x
        bounds.y=15;       // ตำแหน่งฮิตบ็อคแกน y
        bounds.width=32;   // ความกว้างฮิตบ็อค
        bounds.height=32;  // ความสูงฮิตบ็อค

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
        g.drawImage(Assets.fakechest, (int) (x-handler.getGameCamera().getxOffset()),(int) (y-handler.getGameCamera().getyOffset()),width,height,null);
    }
}
