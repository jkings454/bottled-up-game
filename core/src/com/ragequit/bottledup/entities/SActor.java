package com.ragequit.bottledup.entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.World;

public abstract class SActor extends Entity implements IDamagable
{
	private int maxHealth;
	private int curHealth;
	
	SActor(World world)
	{
		super(world);
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
