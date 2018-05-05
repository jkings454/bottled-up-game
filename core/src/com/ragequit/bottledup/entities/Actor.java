package com.ragequit.bottledup.entities;

import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public abstract class Actor extends Entity implements IDamagable
{
	private int maxHealth;
	private int curHealth;
	
	Actor()
	{
		super();
	}
	
	public int getHealth()
	{
		return curHealth;
	}

	@Override
	public void damage(int amount) 
	{
		
	}

	@Override
	public void destroy() 
	{
		
	}
	
}
