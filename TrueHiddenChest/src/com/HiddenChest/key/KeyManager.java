/*
    คลาสสำหรับสร้างการรับค่าจากคีย์บอร์ด
 */
package com.HiddenChest.key;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
    private boolean[] keys , justPressed , cantPassed;
    public boolean up,down,left,right;
    public boolean attackUp,attackDown,attackLeft,attackRight;
    public KeyManager(){
        keys=new boolean[300];
        justPressed = new boolean[keys.length];
        cantPassed = new boolean[keys.length];
    }
    public void update(){
        for(int i=0;i<keys.length;i++){
            if(cantPassed[i] && !keys[i]){
                cantPassed[i] = false;
            }
            else if(justPressed[i]){
                cantPassed[i]=true;
                justPressed[i]=false;
            }
            if(!cantPassed[i] && keys[i]){
                justPressed[i]=true;
            }
        }

        up=keys[KeyEvent.VK_W];
        down=keys[KeyEvent.VK_S];
        left=keys[KeyEvent.VK_A];
        right=keys[KeyEvent.VK_D];

        attackUp=keys[KeyEvent.VK_UP];
        attackDown=keys[KeyEvent.VK_DOWN];
        attackLeft=keys[KeyEvent.VK_LEFT];
        attackRight=keys[KeyEvent.VK_RIGHT];
    }
    public boolean keyJustPressed(int keyCode){
        if(keyCode < 0 || keyCode >= keys.length)
            return false;
        return justPressed[keyCode];
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
            return;
        keys[e.getKeyCode()]=true;
        //System.out.println("Pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
            return;
        keys[e.getKeyCode()]=false;
    }
}
