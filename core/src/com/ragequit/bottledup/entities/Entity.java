package com.ragequit.bottledup.entities;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.BodyDef.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.ragequit.bottledup.physics.WorldManager;

public abstract class Entity extends Actor
{
	private BodyDef bodyDef;
	private Body body;
	private FixtureDef fixtureDef;
	private Fixture fixture;
	private Shape collisionShape;
	private TextureRegion region;
	
	protected void createBody(BodyType type, Shape shape, FixtureDef def)
	{
		bodyDef = new BodyDef();
		bodyDef.type = BodyType.DynamicBody;
		body = WorldManager.world.createBody(bodyDef);		
		collisionShape = shape;
		fixtureDef = def;
		fixture = body.createFixture(fixtureDef);
	}
	
	protected void setTextureRegion(TextureRegion region)
	{
		this.region = new TextureRegion();
	}
	
	public TextureRegion getTextureRegion()
	{
		return region;
	}
	
	public Body getBody()
	{
		return body;
	}
	
	public void dispose()
	{
		collisionShape.dispose();
	}
}
