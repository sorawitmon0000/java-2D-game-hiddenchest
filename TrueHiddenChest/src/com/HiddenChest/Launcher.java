/*
     คลาส main มีการเรียกใช้ constructor สร้างหน้าจอเกม
     และมีการใช้เมธอดเริ่มเกม
 */
package com.HiddenChest;
public class Launcher {
    public static void main(String[] args){
        Panel game = new Panel("HIDDEN CHEST",1024,700); //สร้างหน้าต่างมีขนาดเป็นพิกเซล
        game.start();
    }
}
