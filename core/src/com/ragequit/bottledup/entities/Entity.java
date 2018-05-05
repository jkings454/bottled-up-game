package com.ragequit.bottledup.entities;

import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.BodyDef.*;
import com.ragequit.bottledup.physics.WorldManager;

public class Entity 
{
	private BodyDef bodyDef;
	private Body body;
	private FixtureDef fixtureDef;
	private Fixture fixture;
	private Shape collisionShape;
	
	Entity()
	{
		createBody(BodyType.StaticBody, new PolygonShape(), new FixtureDef());
	}
	
	protected void createBody(BodyType type, Shape shape, FixtureDef def)
	{
		bodyDef = new BodyDef();
		bodyDef.type = BodyType.DynamicBody;
		body = WorldManager.world.createBody(bodyDef);		
		collisionShape = shape;
		fixtureDef = def;
		fixture = body.createFixture(fixtureDef);
	}
	
	public void dispose()
	{
		collisionShape.dispose();
	}
}
