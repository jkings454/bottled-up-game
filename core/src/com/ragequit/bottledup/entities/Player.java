package com.ragequit.bottledup.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.World;
import com.ragequit.bottledup.assets.Assets;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.ragequit.bottledup.util.Constants;
import com.ragequit.bottledup.util.Helpers;

public class Player extends SActor
{
	private enum PlayerLocomotionState
	{
		RUNNING,
		JUMPING,
		FALLING
	}
	
	private PlayerLocomotionState pState = PlayerLocomotionState.RUNNING;
	
	public Player(World world)
	{
	    super(world);
		this.setTextureRegion(Assets.instance.playerAssets.playerRegion);
		
		PolygonShape box = new PolygonShape();
		box.setAsBox(Assets.instance.playerAssets.playerRegion.getRegionWidth(),Assets.instance.playerAssets.playerRegion.getRegionHeight());
		FixtureDef def = new FixtureDef();
		def.density = 1.0f;
		def.friction = 0.0f;
		super.createBody(BodyType.KinematicBody, box, def);
	}
	
	public void move(float xInput)
	{
	    getBody().setAwake(true);
        getBody().setLinearVelocity(xInput * Constants.VELOCITY_FACTOR, 0);
	}
	
	public void jump()
	{
		pState = PlayerLocomotionState.JUMPING;
		getBody().setLinearVelocity(0.0f, 10.0f);
	}
	
	public void tick()
	{
		switch(pState)
		{
			case JUMPING:
				break;
			case RUNNING:
				move(PlayerInput.horizontalInput(Keys.A, Keys.D));
				if(PlayerInput.jumped(Keys.W)) 
				{
					jump();
				}
				break;
			case FALLING:
				break;
			default:
				break;
				
			
		}
		
        Vector2 position = getBody().getPosition();
	    setX(position.x);
	    setY(position.y);
	}
	@Override
	public void draw(Batch batch, float parentAlpha)
	{
		Color color = getColor();
		batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        Helpers.drawTextureRegion((SpriteBatch) batch, getTextureRegion(), getX(), getY(), Constants.WORLD_SCALE);
	}
}
