package com.ragequit.bottledup.entities;

import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class Actor extends Entity 
{
	Actor()
	{
		super();
		setBodyDef(BodyType.StaticBody);
	}
}
