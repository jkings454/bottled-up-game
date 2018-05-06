package com.ragequit.bottledup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.ragequit.bottledup.assets.Assets;
import com.ragequit.bottledup.entities.Player;
import com.ragequit.bottledup.util.Constants;

public class GameplayScreen extends ScreenAdapter {
    private World world;
    private SpriteBatch batch;
    private float accumulator = 0;
    private AssetManager manager;
    private Player player;

    private ExtendViewport viewport;

    @Override
    public void show() {
        manager = new AssetManager();
        Assets.instance.init(manager);

        world = new World(Constants.GRAVITY, true);

        viewport = new ExtendViewport(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
        player = new Player(world);
        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        viewport.apply();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT |
                GL20.GL_DEPTH_BUFFER_BIT |
                (Gdx.graphics.getBufferFormat().coverageSampling?GL20.GL_COVERAGE_BUFFER_BIT_NV:0));

        player.tick(delta);
        
		EdgeShape ground = new EdgeShape();
		ground.set(0, 0, Constants.WORLD_WIDTH, 0);
		FixtureDef def = new FixtureDef();
		def.density = 1.0f;
		def.friction = 0.0f;
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.StaticBody;
		Body body = world.createBody(bodyDef);
		def.shape = ground;
		Fixture fixture = body.createFixture(def);

        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        player.draw(batch, 1);
        batch.end();
        doStep(delta);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }
    
    public void screenToWorld(Vector2 cordinates)
    {
    	viewport.unproject(cordinates);
    }

    private void doStep(float deltaTime) {
        float frameTime = Math.min(deltaTime, 0.25f);
        accumulator += frameTime;
        while(accumulator >= Constants.TIME_STEP) {
            world.step(Constants.TIME_STEP,
                    Constants.VELOCITY_ITERATIONS,
                    Constants.POSITION_ITERATIONS);
            accumulator -= Constants.TIME_STEP;
        }
    }
}
