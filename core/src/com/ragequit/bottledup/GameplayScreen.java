package com.ragequit.bottledup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.ragequit.bottledup.assets.Assets;
import com.ragequit.bottledup.physics.WorldManager;
import com.ragequit.bottledup.util.Constants;
import com.ragequit.bottledup.util.Helpers;

public class GameplayScreen extends ScreenAdapter {

    private SpriteBatch batch;
    private float accumulator = 0;
    private AssetManager manager;

    private ExtendViewport viewport;

    @Override
    public void show() {
        manager = new AssetManager();
        viewport = new ExtendViewport(800, 800);
        Assets.instance.init(manager);
        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        viewport.apply();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        TextureRegion region = Assets.instance.menuAssets.menuRegion;
        Helpers.drawTextureRegion(batch, region, 0, 0);
        batch.end();
        doStep(delta);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
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
