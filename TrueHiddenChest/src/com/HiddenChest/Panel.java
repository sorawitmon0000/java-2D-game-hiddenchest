package com.HiddenChest;

import com.HiddenChest.graphic.Assets;
import com.HiddenChest.graphic.GameCamera;
import com.HiddenChest.graphic.ImageLoader;
import com.HiddenChest.graphic.SpriteSheet;
import com.HiddenChest.key.KeyManager;
import com.HiddenChest.key.MouseManager;
import com.HiddenChest.state.*;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Panel implements Runnable { //อิมพลิเม้นเพื่องให้ใช้ thread ได้
    //ตัวแปรสำหรับสร้างหน้าจอ
    private Window window;
    private int width,height;
    public String title;
    //ตัวแปรระบบตอนรันเกม
    private Thread thread;
    private boolean running=false;
    //ตัวแปรกราฟฟิก
    private BufferStrategy bs;
    private Graphics g;
    //ตัวแปรสเตท
    public GameState menuState;
    public GameState playState;
    public GameState overState;
    public GameState winState;

    //input
    private KeyManager keyManager;
    private MouseManager mouseManager;
    //camera
    private GameCamera gameCamera;
    //handler
    private Handler handler;

    public Panel(String title,int width,int height){ //constructer รับค่าการสร้างหน้าจอ
        this.width=width;
        this.height=height;
        this.title=title;
        keyManager=new KeyManager();
        mouseManager=new MouseManager();
    }
    private void inti(){ //ฟังชั่นค่าเริ่มต้นต่างๆ
        window=new Window(title,width,height);
        window.getFrame().addKeyListener(keyManager);
        window.getFrame().addMouseListener(mouseManager);
        window.getFrame().addMouseMotionListener(mouseManager);
        window.getCanvas().addMouseListener(mouseManager);
        window.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();

        handler=new Handler(this);
        gameCamera = new GameCamera(handler,0,0);

        playState = new PlayState(handler);
        menuState = new MenuState(handler);
        overState = new OverState(handler);
        winState = new WinState(handler);

        GameState.setState(menuState);

    }
    public void run(){
        inti();
        int fps=60;
        double timePerTick=1000000000/fps;
        double delta = 0;
        long now;
        long lastTime=System.nanoTime();
        long timer=0;
        int ticks=0;
        while(running){
            now = System.nanoTime();
            delta+=(now-lastTime)/timePerTick;
            timer+=now-lastTime;
            lastTime=now;
            if(delta>=1){
                update();
                render();
                ticks++;
                delta--;
            }
            if(timer>=1000000000){
                //System.out.println("Tick and Frame: " + ticks);
                ticks=0;
                timer=0;
            }
        }
        stop();
    }

    private void update(){  //อัพเดทวัตถุรวมถึงการกระทำและตัวแปรในแต่ละฉาก
        keyManager.update();
        if(GameState.getState()!=null){
            GameState.getState().update();
        }
    }
    private void render(){  //วาดทุกอย่างที่อยู่บนหน้าจอในขณะอัพเดท
        bs=window.getCanvas().getBufferStrategy();
        if (bs==null){
            window.getCanvas().createBufferStrategy(3);
            return;
        }
        g= bs.getDrawGraphics();
        // Clear Screen
        g.clearRect(0,0,width,height);
        // Draw
        if(GameState.getState()!=null){
            GameState.getState().render(g);
        }
        // End Draw
        bs.show();
        g.dispose();
    }
    public KeyManager getKeyManager(){
        return keyManager;
    }
    public MouseManager getMouseManager(){
        return mouseManager;
    }
    public GameCamera getGameCamera(){
        return gameCamera;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public synchronized void start(){ //ฟังชั่นตัวเริ่มเกม
        if(running)
            return;
        running=true;
        thread=new Thread(this);
        thread.start();
    }
    public synchronized void stop(){
        if(running)
            return;
        running=false;
        try {
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
