package com.ragequit.bottledup;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ragequit.bottledup.physics.WorldManager;
import com.ragequit.bottledup.util.Constants;

public class GameplayScreen extends ScreenAdapter {

    private SpriteBatch batch;
    private float accumulator = 0;

    @Override
    public void show() {
        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        doStep(delta);
    }

    private void doStep(float deltaTime) {
        float frameTime = Math.min(deltaTime, 0.25f);
        accumulator += frameTime;
        while(accumulator >= Constants.TIME_STEP) {
            WorldManager.world.step(Constants.TIME_STEP,
                    Constants.VELOCITY_ITERATIONS,
                    Constants.POSITION_ITERATIONS);
            accumulator -= Constants.TIME_STEP;
        }
    }
}
