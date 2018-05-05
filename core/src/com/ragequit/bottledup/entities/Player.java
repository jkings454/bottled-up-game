package com.ragequit.bottledup.entities;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class Player extends Actor
{
	Player()
	{
		setBodyDef(BodyType.KinematicBody);
	}
}
