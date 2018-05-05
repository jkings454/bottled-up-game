package com.ragequit.bottledup.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable, AssetErrorListener {
    private static final String TAG = Assets.class.getName();
    public static final Assets instance = new Assets();

    private AssetManager manager;
    private TextureAtlas atlas;

    private Assets() {
        manager = new AssetManager();
        atlas = new TextureAtlas();
    }

    @Override
    public void dispose() {
        manager.dispose();
        atlas.dispose();
    }

    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error(TAG, "Error loading asset " + asset.fileName);
    }
}
