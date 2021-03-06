package com.ragequit.bottledup.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public final class Constants {
    public static final Vector2 GRAVITY = new Vector2(0, -10);
    public static final float TIME_STEP = (1 / 60f);
    public static final int VELOCITY_ITERATIONS = 6;
    public static final int POSITION_ITERATIONS = 2;


    public static final String ASSET_INPUT_DIRECTORY = "core/assets/input";
    public static final String ASSET_OUTPUT_DIRECTORY = "core/assets/output";
    public static final String PACKFILE_NAME = "atlas";


    public static final String TEXTURE_ATLAS = "output/atlas.atlas";

    public static final float WORLD_SCALE = 0.05f;
    public static final float VELOCITY_FACTOR = 50;
    public static final float WORLD_WIDTH = 100;
    public static final float WORLD_HEIGHT = 100;
}
