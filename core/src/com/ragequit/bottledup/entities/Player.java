package com.ragequit.bottledup.entities;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class Player extends Actor
{
	Player()
	{
		PolygonShape box = new PolygonShape();
		box.setAsBox(1,1);
		FixtureDef def = new FixtureDef();
		super.createBody(BodyType.KinematicBody, box, def);
	}
}
