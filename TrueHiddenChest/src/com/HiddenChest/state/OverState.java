package com.HiddenChest.state;

import com.HiddenChest.Handler;
import com.HiddenChest.graphic.ImageLoader;

import java.awt.*;
/*
        คลาสเกมโอเวอร์
 */
public class OverState extends GameState{
    public OverState(Handler handler) {
        super(handler);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(ImageLoader.loadImage("C:\\Users\\mon_9_vv4cmmb\\OneDrive\\เอกสาร\\TrueHiddenChest\\Resourcse\\textures\\overstate.png"),0,0,1024,700,null);
    }
}
