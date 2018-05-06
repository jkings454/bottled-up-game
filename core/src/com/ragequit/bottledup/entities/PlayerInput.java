package com.ragequit.bottledup.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class PlayerInput
{	
	private static ExtendViewport viewport;
	
	public static float horizontalInput(int neg, int pos)
	{
		boolean negPressed = Gdx.input.isKeyPressed(neg);
		boolean posPressed = Gdx.input.isKeyPressed(pos);
		return (negPressed ? -1.0f : 0.0f) + (posPressed ? 1.0f : 0.0f);
	}
	
	public static boolean jumped(int key)
	{
		return Gdx.input.isKeyJustPressed(key);
	}
	
	public static boolean fire()
	{
		return Gdx.input.isTouched();
	}
	
	public static void setViewport(ExtendViewport ev)
	{
		viewport = ev;
	}
	
	public static Vector2 mousePosition()
	{
		Vector2 screenCoord = new Vector2(Gdx.input.getX(), Gdx.input.getY());
		if(viewport == null)
			return Vector2.Zero;
		return viewport.unproject(screenCoord);
	}
	
}