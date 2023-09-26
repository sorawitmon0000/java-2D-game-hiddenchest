package com.HiddenChest.state;
import com.HiddenChest.Handler;
import com.HiddenChest.Panel;
import com.HiddenChest.UI.ClickListener;
import com.HiddenChest.UI.UIManager;
import com.HiddenChest.UI.UIimagebutton;
import com.HiddenChest.graphic.Assets;
import com.HiddenChest.graphic.ImageLoader;

import java.awt.*;
/*
    คลาสหน้าเริ่มเกม
 */
public class MenuState extends GameState{
    private UIManager uiManager;

    public MenuState(Handler handler){
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        uiManager.addObject(new UIimagebutton(330, 620, 350, 90, Assets.bt_start,
                new ClickListener() {
                    @Override
                    public void onClick() {
                        handler.getMouseManager().setUiManager(null);
                        GameState.setState(handler.getGame().playState);
                    }
                }));

    }
    @Override
    public void update() {
        uiManager.update();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(ImageLoader.loadImage("C:\\Users\\mon_9_vv4cmmb\\OneDrive\\เอกสาร\\TrueHiddenChest\\Resourcse\\textures\\menustate.png"),0,0,1024,700,null);
        uiManager.render(g);
    }

}
