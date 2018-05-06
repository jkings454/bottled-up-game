package com.ragequit.bottledup.entities;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.BodyDef.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.ragequit.bottledup.GameplayScreen;

public abstract class Entity extends Actor
{
	private BodyDef bodyDef;
	private Body body;
	private FixtureDef fixtureDef;
	private Fixture fixture;
	private Shape collisionShape;
	private TextureRegion region;
	private World world;

	public Entity(World world) {
		this.world = world;
	}
	protected void createBody(BodyType type, Shape shape, FixtureDef def)
	{
		bodyDef = new BodyDef();
		bodyDef.type = type;
		body = world.createBody(bodyDef);
		collisionShape = shape;
		fixtureDef = def;
		fixtureDef.shape = collisionShape;
		fixture = body.createFixture(def);
	}
	
	protected void setTextureRegion(TextureRegion region)
	{
		this.region = region;
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
