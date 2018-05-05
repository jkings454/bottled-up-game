package com.ragequit.bottledup.physics;

import com.badlogic.gdx.physics.box2d.World;
import com.ragequit.bottledup.util.Constants;

public class WorldManager {
    public static final World world = new World(Constants.GRAVITY, true);
}
