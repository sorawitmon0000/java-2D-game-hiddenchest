package com.HiddenChest.entity.creatures;

import com.HiddenChest.Handler;
import com.HiddenChest.Panel;
import com.HiddenChest.entity.Entity;
import com.HiddenChest.entity.statics.Tree;
import com.HiddenChest.graphic.Animation;
import com.HiddenChest.graphic.Assets;
import com.HiddenChest.graphic.ImageLoader;
import com.HiddenChest.inventory.Inventory;
import com.HiddenChest.item.Item;
import com.HiddenChest.state.GameState;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Player extends Creature {
    //animation
    private Animation animationUp,animationDown,animationLeft,animationRight,animationNothing;
    //attack timer
    private long lastAttackTimer,attackCooldown=800,attackTimer=attackCooldown;
    //inventory
    private Inventory inventory;


    public Player(Handler handler, float x, float y){
        super(handler,x,y,Creature.Default_width,Creature.Default_height);
        bounds.x=15;       // ตำแหน่งฮิตบ็อกคกน x
        bounds.y=20;       // ตำแหน่งฮิตบ็อคแกน y
        bounds.width=32;   // ความกว้างฮิตบ็อค
        bounds.height=32;  // ความสูงฮิตบ็อค

        //animation
        animationNothing=new Animation(75,Assets.player_nothing);
        animationUp = new Animation(75,Assets.player_up);
        animationDown = new Animation(75,Assets.player_down);
        animationLeft = new Animation(75,Assets.player_left);
        animationRight = new Animation(75,Assets.player_right);

        inventory = new Inventory(handler);
        this.health=5;
    }

    private BufferedImage getCurrentAnimationFrame(){
        if(xMove < 0){
            return animationLeft.getCurrentframe();
        }
        else if(xMove > 0){
            return animationRight.getCurrentframe();
        }
        else if(yMove < 0){
            return animationUp.getCurrentframe();
        }
        else if(yMove > 0) {
            return animationDown.getCurrentframe();
        }
        else if(xMove==0){
            return animationNothing.getCurrentframe();
        }
        else {
            return animationNothing.getCurrentframe();
        }
    }
    private void getInput(){
        xMove=0;
        yMove=0;
        if(handler.getKeyManager().up){
            yMove=-speed;
        }
        if(handler.getKeyManager().down){
            yMove=+speed;
        }
        if(handler.getKeyManager().left){
            xMove=-speed;
        }
        if(handler.getKeyManager().right){
            xMove=+speed;
        }

    }

    @Override
    public void update() {
        //animation
        animationUp.update();
        animationDown.update();
        animationLeft.update();
        animationRight.update();
        // การเคลื่อนที
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
        // attack
        checkAttack();
        // inventory
        inventory.update();
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_C)) {
            System.out.println(health);

        }

        if (health <= 0) {
            die();
        }

    }
    public void checkAttack(){
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if(attackTimer < attackCooldown)
            return;;

        Rectangle collisionBalance = getCollisionBounds(0,0);
        Rectangle attackRange = new Rectangle();
        int arSize = 20; // ระยะตี
        attackRange.width = arSize;
        attackRange.height = arSize;
        if(handler.getKeyManager().attackUp){
            attackRange.x=collisionBalance.x + collisionBalance.width/2 - arSize/2;
            attackRange.y=collisionBalance.y - arSize;
            this.health-=1;
        }
        else if(handler.getKeyManager().attackDown){
            attackRange.x=collisionBalance.x + collisionBalance.width/2 - arSize/2;
            attackRange.y=collisionBalance.y + collisionBalance.height;
            this.health-=1;
        }
        else if(handler.getKeyManager().attackLeft){
            attackRange.x=collisionBalance.x - arSize;
            attackRange.y=collisionBalance.y + collisionBalance.height/2 - arSize/2;
            this.health-=1;
        }
        else if(handler.getKeyManager().attackRight){
            attackRange.x=collisionBalance.x + collisionBalance.width;
            attackRange.y=collisionBalance.y +collisionBalance.height/2 - arSize/2;
            this.health-=1;
        }
        else {
            return;
        }

        attackTimer=0;

        for(Entity e : handler.getMap().getEntityManager().getEntities()) {
            if (e.equals(this))
                continue;
            if (e.getCollisionBounds(0, 0).intersects(attackRange)) {
                e.hurt(1);
                return;
            }

        }
    }

    @Override
    public void render(Graphics g) {
        // วาดผู้เล่นและผูกให้มุมกล้องติดไปกับผู้เล่น
        g.drawImage(getCurrentAnimationFrame() ,(int) (x-handler.getGameCamera().getxOffset()),(int) (y-handler.getGameCamera().getyOffset()),width,height,null);
        inventory.render(g);
        // เช็คฮิตบ็อค
        /* g.setColor(Color.BLUE);
        g.fillRect((int)(x+bounds.x-handler.getGameCamera().getxOffset()),(int)(y+bounds.y-handler.getGameCamera().getyOffset()),
                bounds.width , bounds.height);*/
        for(int i=0;i<health;i++) {
            int hp = i + 1;
            if (health >= 4) {
                g.setColor(Color.GREEN);
                g.fillRect(674, 25, 70 * hp, 40);
            } else if (health >= 3) {
                g.setColor(Color.YELLOW);
                g.fillRect(674, 25, 70 * hp, 40);
            } else if (health >= 1) {
                g.setColor(Color.RED);
                g.fillRect(674, 25, 70 * hp, 40);
            }
        }
    }

    @Override
    public void die(){
        GameState.setState(handler.getGame().overState);
    }
    // getter

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }



}
