package com.ragequit.bottledup;

import com.badlogic.gdx.Game;

public class BottledUp extends Game {
	@Override
	public void create() {
		GameplayScreen screen = new GameplayScreen();
		screen.show();
	}
}
