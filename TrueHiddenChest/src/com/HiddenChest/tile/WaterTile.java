package com.HiddenChest.tile;

import com.HiddenChest.graphic.Assets;

import java.awt.image.BufferedImage;

public class WaterTile extends Tile{

    public WaterTile(int id) {
        super(Assets.water, id);
    }
    @Override
    public boolean isSolid(){
        return true;
    }
}
