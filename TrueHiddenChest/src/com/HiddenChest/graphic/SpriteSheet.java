
package com.HiddenChest.graphic;

import java.awt.image.BufferedImage;
/*
        คลาสสำหรับ crop รูปจาก sprite sheet
 */

public class SpriteSheet {
    private BufferedImage sheet;
    public SpriteSheet(BufferedImage sheet){
        this.sheet=sheet;
    }
    public BufferedImage crop(int x,int y,int width,int height){
        return sheet.getSubimage(x,y,width,height);
    }
}
