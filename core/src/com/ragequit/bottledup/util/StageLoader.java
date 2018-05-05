package com.ragequit.bottledup.util;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Pool;
import com.ragequit.bottledup.entities.Entity;


public class StageLoader {
    public static final String TAG = StageLoader.class.getName();
    private TiledMap map;
    private Pool<Entity> platforms;

    private OrthogonalTiledMapRenderer renderer;

    public StageLoader(AssetManager manager, String level) {
        manager.setLoader(TiledMap.class,
                new TmxMapLoader(new InternalFileHandleResolver()));
        manager.load(level, TiledMap.class);
        manager.finishLoading();

        map = manager.get(level);
    }

    public TiledMap getMap() {
        return map;
    }

    public Pool<Entity> getPlatforms() {
        return null;
    }
}
