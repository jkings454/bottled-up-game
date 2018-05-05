package com.ragequit.bottledup.util;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Helpers {
    public static void drawTextureRegion(SpriteBatch batch, TextureRegion region, float x, float y) {
        batch.draw(region.getTexture(),
                x,
                y,
                0, 0,
                region.getRegionWidth(),
                region.getRegionHeight(), 1, 1, 0,
                region.getRegionX(),
                region.getRegionY(),
                region.getRegionWidth(),
                region.getRegionHeight(),
                false, false);
    }
}
