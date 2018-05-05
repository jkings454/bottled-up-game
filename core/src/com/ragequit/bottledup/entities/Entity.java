package com.ragequit.bottledup.entities;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class Entity 
{
	private BodyDef bodyDef;
	private Body body;
	
	Entity()
	{
		setBodyDef(BodyType.StaticBody);
	}
	
	protected void setBodyDef(BodyType type)
	{
		bodyDef = new BodyDef();
		bodyDef.type = BodyType.DynamicBody;
		body = new world.createBody(bodyDef);
	}
}
