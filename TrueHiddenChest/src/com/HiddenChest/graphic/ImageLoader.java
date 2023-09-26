
package com.HiddenChest.graphic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/*
        คลาสสำหรับโหลดรูป
 */

public class ImageLoader {
    public static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(new File(path));
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
