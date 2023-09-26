package com.HiddenChest.UI;

import com.HiddenChest.Handler;
import com.HiddenChest.graphic.ImageLoader;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
/*
        คลาสจัดการปุ่ม
 */

public class UIManager {
    private Handler handler;
    private ArrayList<UIobject> objects;

    public UIManager(Handler handler){
        this.handler = handler;
        objects = new ArrayList<UIobject>();
    }
    public void update(){
        for(UIobject o : objects)
            o.update();
    }
    public void render(Graphics g){
        for(UIobject o : objects)
            o.render(g);

    }
    public void onMouseMove(MouseEvent e){
        for(UIobject o : objects)
            o.onMouseMove(e);
    }
    public void onMouseRelease(MouseEvent e){
        for(UIobject o : objects)
            o.onMouseRelease(e);
    }
    public void addObject(UIobject o){
        objects.add(o);
    }
    public void removeObject(UIobject o){
        objects.remove(o);
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<UIobject> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<UIobject> objects) {
        this.objects = objects;
    }
}
