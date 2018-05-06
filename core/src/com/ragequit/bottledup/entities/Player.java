package com.ragequit.bottledup.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import com.ragequit.bottledup.assets.Assets;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.RayCastCallback;
import com.ragequit.bottledup.util.Constants;
import com.ragequit.bottledup.util.Helpers;

public class Player extends SActor
{	
	private float jumpHeight = 10;
	private float jumpDuration = 0.5f;
	private float desiredHeight;
	private float jumpTimer;
	
	private boolean jumping = false;
	private boolean falling = false;
	
	private Vector2 desiredVelocity = new Vector2(0.0f, 0.0f);
	private World world;
	
	public Player(World world)
	{
	    super(world);
	    this.world = world;
		this.setTextureRegion(Assets.instance.playerAssets.playerRegion);
		
		PolygonShape box = new PolygonShape();
		box.setAsBox(Assets.instance.playerAssets.playerRegion.getRegionWidth(),Assets.instance.playerAssets.playerRegion.getRegionHeight());
		FixtureDef def = new FixtureDef();
		def.density = 1.0f;
		def.friction = 0.0f;
		super.createBody(BodyType.KinematicBody, box, def);
	}
	
	public Vector2 move(float xInput)
	{
        return new Vector2(xInput * Constants.VELOCITY_FACTOR, 0);
	}
	
	public void jump()
	{
		jumping = true;
		jumpTimer = 0.0f;
        desiredHeight = getBody().getPosition().y + jumpHeight;
	}
	
	public void tick(float delta)
	{
		if(PlayerInput.jumped(Keys.W))
		{
			jump();	
		}
		
		if(PlayerInput.fire())
			shoot();
		
		desiredVelocity.set(Vector2.Zero);
		desiredVelocity.add(move(PlayerInput.horizontalInput(Keys.A, Keys.D)));
		desiredVelocity.add(applyJump(delta));
		desiredVelocity.add(applyGravity());
		
		getBody().setLinearVelocity(desiredVelocity);
		
        Vector2 position = getBody().getPosition();
        System.out.println(desiredVelocity);
	    setX(position.x);
	    setY(position.y);
	}
	
	Vector2 applyJump(float delta)
	{
		jumpTimer += delta;
		float jumpVel = -((2*desiredHeight)/(jumpDuration * jumpDuration)) * (jumpTimer - jumpDuration);
		if(jumpTimer >= jumpDuration)
		{
			jumping = false;
		}
		
		return new Vector2( 0, jumpVel);
	}
	
	Vector2 applyGravity()
	{
		if(jumping)
		{
			return new Vector2(0.0f, 0.0f);
		}
		
		return new Vector2(0.0f, -1.0f);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha)
	{
		Color color = getColor();
		batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        Helpers.drawTextureRegion((SpriteBatch) batch, getTextureRegion(), getX(), getY(), Constants.WORLD_SCALE);
	}
	
	public void shoot()
	{
		//RayCastCallback callback = new RayCastCallback();
		Vector2 fromPoint = getBody().getPosition();
		Vector2 toPoint = (PlayerInput.mousePosition().sub(fromPoint)).nor().scl(20f);
		
		RayCastCallback callback = new RayCastCallback()
		{
            @Override
            public float reportRayFixture(Fixture fixture, Vector2 point, Vector2 normal, float fraction) 
            {
            	System.out.println(fixture.getBody().getUserData());
                return 1;
            }
		};
		
		world.rayCast(callback, fromPoint, toPoint);
	}
}
