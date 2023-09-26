package com.HiddenChest;

import com.HiddenChest.graphic.GameCamera;
import com.HiddenChest.key.KeyManager;
import com.HiddenChest.key.MouseManager;
import com.HiddenChest.map.Map;
/*
    คลาสเอาไว้เรียกใช้ method จากคลาสต่างๆ โดยประกาศ type เป็น handler สามารถเรียกใช้ทุกคลาสได้เลย (เพื่อความสะดวก)
 */

public class Handler {
    private Panel game;
    private Map map;
    public Handler(Panel game){
        this.game=game;
    }
    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }
    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }
    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }
    public int getWidth(){
        return game.getWidth();
    }
    public int getHeight(){
        return game.getHeight();
    }
    public Panel getGame() {
        return game;
    }

    public void setGame(Panel game) {
        this.game = game;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
