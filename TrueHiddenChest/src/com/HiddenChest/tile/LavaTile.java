package com.HiddenChest.tile;

import com.HiddenChest.graphic.Assets;

public class LavaTile extends Tile {
    public LavaTile(int id) {
        super(Assets.lava, id);
    }
    @Override
    public boolean isSolid(){
        return true;
    }
}
