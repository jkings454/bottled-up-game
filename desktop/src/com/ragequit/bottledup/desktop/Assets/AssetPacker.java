package com.ragequit.bottledup.desktop.Assets;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.ragequit.bottledup.util.Constants;

public class AssetPacker {
    public static void main(String[] args) {
        TexturePacker.Settings settings = new TexturePacker.Settings();
        settings.maxHeight = 2048;
        settings.maxWidth = 2048;
        TexturePacker.process(settings, Constants.ASSET_INPUT_DIRECTORY,
                Constants.ASSET_OUTPUT_DIRECTORY,
                Constants.PACKFILE_NAME);
    }
}
