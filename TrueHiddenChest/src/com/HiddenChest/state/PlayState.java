package com.HiddenChest.state;

import com.HiddenChest.Handler;
import com.HiddenChest.Panel;
import com.HiddenChest.entity.creatures.Player;
import com.HiddenChest.entity.statics.Tree;
import com.HiddenChest.graphic.Assets;
import com.HiddenChest.map.Map;
import com.HiddenChest.tile.Tile;

import java.awt.*;
/*
    คลาสฉากเล่น
 */

public class PlayState extends GameState{

    private Map map;

    public PlayState(Handler handler){
        super(handler);
        map=new Map(handler,"C:\\Users\\mon_9_vv4cmmb\\OneDrive\\เอกสาร\\TrueHiddenChest\\Resourcse\\map\\TrueMapGame.txt");
        handler.setMap(map);

    }
    @Override
    public void update() {
        map.update();


    }
    @Override
    public void render(Graphics g) {
        map.render(g);


        //g.drawImage(Assets.water,0,0,null);
        //Tile.tiles[1].render(g,0,0);
    }
}
