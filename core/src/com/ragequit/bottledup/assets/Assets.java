package com.ragequit.bottledup.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Disposable;
import com.ragequit.bottledup.util.Constants;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

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
        Gdx.app.error(TAG, "Error loading asset " + asset.fileName);
    }

    public final class MenuAssets {
        public final TextureRegion menuRegion;
        private MenuAssets(TextureAtlas atlas) {
            menuRegion = atlas.findRegion("Menu/Title.png");
        }

        public TextureRegion getMenuRegion() {
            return menuRegion;
        }
    }

    public final class PlayerAssets {
        private PlayerAssets(TextureAtlas atlas) {
        }
    }
}
