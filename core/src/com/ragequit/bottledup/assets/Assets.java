package com.ragequit.bottledup.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Disposable;
import com.ragequit.bottledup.util.Constants;

public class Assets implements Disposable, AssetErrorListener {
    private static final String TAG = Assets.class.getName();
    public static final Assets instance = new Assets();

    public PlayerAssets playerAssets;
    public MenuAssets menuAssets;

    private AssetManager manager;
    private TextureAtlas atlas;

    private Assets() {
    }

    public void init(AssetManager assetManager) {
        manager = assetManager;
        manager.setErrorListener(this);
        manager.load(Constants.TEXTURE_ATLAS, TextureAtlas.class);
        manager.finishLoading();

        atlas = manager.get(Constants.TEXTURE_ATLAS);
        playerAssets = new PlayerAssets(atlas);
        menuAssets = new MenuAssets(atlas);
    }

    @Override
    public void dispose() {
        manager.dispose();
        atlas.dispose();
    }

    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.log(TAG, "Error loading asset " + asset.fileName);
    }

    public class MenuAssets {
        public final AtlasRegion menuRegion;
        public MenuAssets(TextureAtlas atlas) {
            menuRegion = atlas.findRegion("Menu/Title");
        }
    }

    public final class PlayerAssets {
        public final AtlasRegion playerRegion;
        private PlayerAssets(TextureAtlas atlas) {
            playerRegion = atlas.findRegion("Character/Cricket");
        }
    }
}
