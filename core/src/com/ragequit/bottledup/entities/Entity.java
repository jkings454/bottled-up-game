package com.ragequit.bottledup.entities;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class Entity 
{
	private BodyDef bodyDef;
	
	Entity()
	{
		bodyDef = new BodyDef();
	}
	
	public void setBodyDef(BodyType type)
	{
		bodyDef.type = BodyType.DynamicBody;
	}
}
