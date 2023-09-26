package com.HiddenChest.state;
import com.HiddenChest.Handler;
import com.HiddenChest.Panel;
import java.awt.*;
/*
    แม่แบบของแต่ละสเตท
 */
public abstract class GameState {
    private static GameState currentState=null;
    public static void setState(GameState state){
        currentState=state;
    }
    public static GameState getState(){
        return currentState;
    }


    //Class
    protected Handler handler;
    public GameState(Handler handler){
        this.handler=handler;
    }
    public abstract void update();
    public abstract void render(Graphics g);
}
