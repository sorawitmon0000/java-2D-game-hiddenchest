package com.HiddenChest.map;

import com.HiddenChest.Handler;
import com.HiddenChest.Panel;
import com.HiddenChest.entity.EntityManager;
import com.HiddenChest.entity.creatures.Player;
import com.HiddenChest.entity.statics.*;
import com.HiddenChest.item.ItemManager;
import com.HiddenChest.tile.Tile;
import com.HiddenChest.utils.Utils;

import java.awt.*;

public class Map {
    private Handler handler;
    private int width,height;
    private int[][] tiles;
    private int spawnX,spawnY;
    // Entity
    private EntityManager entityManager;
    // item
    private ItemManager itemManager;

    public Map(Handler handler, String path){
        this.handler=handler;
        entityManager = new EntityManager(handler,new Player(handler,500,600));
        itemManager = new ItemManager(handler);

        // วาง entity
        // tree
        entityManager.addEntity(new Tree(handler,65,64*54));
        entityManager.addEntity(new Tree(handler,64*11,64*48));
        entityManager.addEntity(new Tree(handler,64*3,64*44));
        entityManager.addEntity(new Tree(handler,64*18,64*22));
        entityManager.addEntity(new Tree(handler,64*16,64*24));
        entityManager.addEntity(new Tree(handler,64*8,64*20));
        entityManager.addEntity(new Tree(handler,64*3,64*23));
        entityManager.addEntity(new Tree(handler,64*8,64*28));
        entityManager.addEntity(new Tree(handler,64*13,64*30));
        entityManager.addEntity(new Tree(handler,64*35,64*35));
        entityManager.addEntity(new Tree(handler,64*50,64*41));

        entityManager.addEntity(new Tree2(handler,64*32,64*41));
        entityManager.addEntity(new Tree2(handler,64*31,64*23));

        entityManager.addEntity(new Tree3(handler,64*57,64*12));
        entityManager.addEntity(new Tree3(handler,64*54,64*5));
        entityManager.addEntity(new Tree3(handler,64*54,64*15));
        entityManager.addEntity(new Tree3(handler,64*47,64*6));
        entityManager.addEntity(new Tree3(handler,64*35,64*5));
        entityManager.addEntity(new Tree3(handler,64*28,64*8));
        entityManager.addEntity(new Tree3(handler,40,64*12));



        // chest
        entityManager.addEntity(new BombChest(handler,65,64*57+10));
        entityManager.addEntity(new BombChest(handler,64*53,64*49));
        entityManager.addEntity(new BombChest(handler,64*45,64*34));
        entityManager.addEntity(new BombChest(handler,64*4,64*26));
        entityManager.addEntity(new BombChest(handler,64*45,64*34));
        entityManager.addEntity(new BombChest(handler,64*46,64*3));
        entityManager.addEntity(new BombChest(handler,64*7,64*7));

        entityManager.addEntity(new Goldchest(handler,64*19,64*21));
        entityManager.addEntity(new Goldchest(handler,64*56,64*4));

        entityManager.addEntity(new FakeChest(handler,64*3,64*49));
        entityManager.addEntity(new FakeChest(handler,64*14,64*46));
        entityManager.addEntity(new FakeChest(handler,64*11,64*43));
        entityManager.addEntity(new FakeChest(handler,64*4,64*40));
        entityManager.addEntity(new FakeChest(handler,64*13,64*36));
        entityManager.addEntity(new FakeChest(handler,64*24,64*42));
        entityManager.addEntity(new FakeChest(handler,64*40,64*40));
        entityManager.addEntity(new FakeChest(handler,64*57,64*42));

        entityManager.addEntity(new FakeChest(handler,64*19,64*31));
        entityManager.addEntity(new FakeChest(handler,64*11,64*26));
        entityManager.addEntity(new FakeChest(handler,64*20,64*26));
        entityManager.addEntity(new FakeChest(handler,64*5,64*21));
        entityManager.addEntity(new FakeChest(handler,64*13,64*21));

        entityManager.addEntity(new FakeChest(handler,64*30,64*52));
        entityManager.addEntity(new FakeChest(handler,64*25,64*49));

        entityManager.addEntity(new FakeChest(handler,64*30,64*24));
        entityManager.addEntity(new FakeChest(handler,64*33,64*24));
        entityManager.addEntity(new FakeChest(handler,64*30,64*26));
        entityManager.addEntity(new FakeChest(handler,64*33,64*26));
        entityManager.addEntity(new FakeChest(handler,64*39,64*29));
        entityManager.addEntity(new FakeChest(handler,64*42,64*23));
        entityManager.addEntity(new FakeChest(handler,64*47,64*23));
        entityManager.addEntity(new FakeChest(handler,64*56,64*23));
        entityManager.addEntity(new FakeChest(handler,64*55,64*34));

        entityManager.addEntity(new FakeChest(handler,64*58,64*17));
        entityManager.addEntity(new FakeChest(handler,64*54,64*10));

        entityManager.addEntity(new FakeChest(handler,64*29,64*14));
        entityManager.addEntity(new FakeChest(handler,64*32,64*7));
        entityManager.addEntity(new FakeChest(handler,64*20,64*6));
        entityManager.addEntity(new FakeChest(handler,64*10,64*13));
        entityManager.addEntity(new FakeChest(handler,64*1,64*10));
        entityManager.addEntity(new FakeChest(handler,64*7,64*5));
        entityManager.addEntity(new FakeChest(handler,64*10,64*5));
        entityManager.addEntity(new FakeChest(handler,64*4,64*8));
        entityManager.addEntity(new FakeChest(handler,64*7,64*9));

        entityManager.addEntity(new TrueChest(handler,64*2,64*15));



        // rock
        entityManager.addEntity(new Rock1(handler,64*19,64*53));
        entityManager.addEntity(new Rock1(handler,64*17,64*51));
        entityManager.addEntity(new Rock1(handler,64*41,64*53));
        entityManager.addEntity(new Rock1(handler,64*46,64*46));
        entityManager.addEntity(new Rock1(handler,64*16,64*26));

        entityManager.addEntity(new Rock2(handler,64*54,64*26));
        entityManager.addEntity(new Rock2(handler,64*57,64*11));
        entityManager.addEntity(new Rock2(handler,64*46,64*5));

        entityManager.addEntity(new Rock3(handler,64*21,64*11));
        entityManager.addEntity(new Rock3(handler,64*36,64*4));
        entityManager.addEntity(new Rock3(handler,64*12,64*3));
        entityManager.addEntity(new Rock3(handler,64*6,64*15));
        entityManager.addEntity(new Rock3(handler,64*27,64*6));



        loadMap(path);
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);


    }
    public void update(){
        itemManager.update();
        entityManager.update();
    }
    //วาดแมพ
    public void render(Graphics g) {
        int xStart= (int) Math.max(0,handler.getGameCamera().getxOffset()/Tile.tilewidth);
        int xEnd=(int) Math.min(width,(handler.getGameCamera().getxOffset() + handler.getWidth())/Tile.tilewidth+1);;
        int yStart=(int) Math.max(0,handler.getGameCamera().getyOffset()/Tile.tileheight);;
        int yEnd=(int) Math.min(height,(handler.getGameCamera().getyOffset() + handler.getHeight())/Tile.tileheight+1);;
        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                getTile(x,y).render(g,(int) (x*Tile.tilewidth-handler.getGameCamera().getxOffset()),(int) (y*Tile.tileheight-handler.getGameCamera().getyOffset()));
            }
        }
        // item
        itemManager.render(g);
        // Entity
        entityManager.render(g);
    }
    public Tile getTile(int x,int y){
        if( x<0 || y<0 || x>=width || y>=height){
            return Tile.grassTile;
        }
        Tile t = Tile.tiles[tiles[x][y]];
        if(t==null){
            return Tile.waterTile;
        }
        return t;
    }
    private void loadMap(String path){
        String file = Utils.loadFileAsString(path);
        String[] token = file.split("\\s+");
        width=Utils.parseInt(token[0]);
        height=Utils.parseInt(token[1]);
        spawnX=Utils.parseInt(token[2]);
        spawnY=Utils.parseInt(token[3]);
        tiles = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
               tiles[x][y]=Utils.parseInt(token[(x+y*width)+4]);
            }
        }
    }

    // setter and getter
    public int getWidth(){
        return width;
    }

    public int getHeight() {
        return height;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public void setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }
}
