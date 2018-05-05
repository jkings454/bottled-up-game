package com.ragequit.bottledup.entities;

import com.badlogic.gdx.Gdx;

public class PlayerInput
{	
	public static float horizontalInput(int neg, int pos)
	{
		boolean negPressed = Gdx.input.isKeyPressed(neg);
		boolean posPressed = Gdx.input.isKeyPressed(pos);
		return (negPressed ? -1.0f : 0.0f) + (posPressed ? 1.0f : 0.0f);
	}
	
	public static boolean jumped(int key)
	{
		return Gdx.input.isKeyPressed(key);
	}
	
	public static boolean fire()
	{
		return Gdx.input.isTouched();
	}
	
}