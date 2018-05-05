package com.ragequit.bottledup.util;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Helpers {
    public static void drawTextureRegion(SpriteBatch batch, TextureRegion region, float x, float y) {
        batch.draw(region, x, y,
                region.getRegionX(),
                region.getRegionY(),
                region.getRegionWidth(),
                region.getRegionHeight(),
                1, 1, 0, true);
    }
    public static void drawTextureRegion(SpriteBatch batch, TextureRegion region, float x, float y, float scale) {
        batch.draw(region, x, y,
                region.getRegionX(),
                region.getRegionY(),
                region.getRegionWidth(),
                region.getRegionHeight(),
                scale, scale, 0, true);
    }
    public static void drawTextureRegion(SpriteBatch batch, TextureRegion region, float x, float y, float scaleX, float scaleY) {
        batch.draw(region, x, y,
                region.getRegionX(),
                region.getRegionY(),
                region.getRegionWidth(),
                region.getRegionHeight(),
                scaleX, scaleY, 0, true);
    }
    public static void drawTextureRegion(SpriteBatch batch,
                                         TextureRegion region,
                                         float x, float y, float scaleX,
                                         float scaleY, float rotation) {
        batch.draw(region, x, y,
                region.getRegionX(),
                region.getRegionY(),
                region.getRegionWidth(),
                region.getRegionHeight(),
                scaleX, scaleY, rotation, true);
    }
}
