package com.ragequit.bottledup.util;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Helpers {
    public static void drawTextureRegion(SpriteBatch batch, TextureRegion region, float x, float y, float scale) {
        batch.draw(region.getTexture(),
                x,
                y,
                0, 0,
                region.getRegionWidth(),
                region.getRegionHeight(), scale, scale, 0,
                region.getRegionX(),
                region.getRegionY(),
                region.getRegionWidth(),
                region.getRegionHeight(),
                false, false
        );
    }

    public static void drawTextureRegion(SpriteBatch batch, TextureRegion region, float x, float y) {
        drawTextureRegion(batch, region, x, y, 1);
    }
}
