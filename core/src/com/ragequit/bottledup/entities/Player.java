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
		box.setAsBox(1,1);
		FixtureDef def = new FixtureDef();
		super.createBody(BodyType.KinematicBody, box, def);
	}
	
	public void Move(float xInput)
	{
		getBody().setLinearVelocity(xInput, 0.0f);
	}
	
	public void Jump()
	{
		pState = PlayerLocomotionState.JUMPING;
		getBody().setLinearVelocity(0.0f, 1.0f);
	}
	
	public void Tick()
	{
		switch(pState)
		{
			case JUMPING:
				break;
			case RUNNING:
				Move(PlayerInput.horizontalInput(Keys.A, Keys.D));
				if(PlayerInput.jumped(Keys.W)) 
				{
					Jump();
				}
				break;
			case FALLING:
				break;
			default:
				break;
		}
	}
	public void update() {
        Vector2 position = getBody().getPosition();
	    setX(position.x);
	    setY(position.y);
    }
	@Override
	public void draw(Batch batch, float parentAlpha)
	{
		Color color = getColor();
		batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        Helpers.drawTextureRegion((SpriteBatch) batch, getTextureRegion(), getX(), getY());
	}
}
