package com.product.game.tankbattle.actor.setting;

import org.andengine.entity.sprite.AnimatedSprite;

import com.product.game.tankbattle.actor.base.TBActor.ACTOR_TEAM;
import com.product.game.tankbattle.resource.GameResource;
import com.product.game.tankbattle.resource.sprite.BaseSpriteManager;

public class UserTankSetting implements TankSetting {
	
	final static int HIT_POINT = 1;
	final static float SPEED = 500;
	final static int STEP_DISTANCE = 10;
	final static int TANK_LEVEL = 1;
	
	@Override
	public int getHitPoint() {
		return HIT_POINT;
	}

	@Override
	public float getSpeed() {
		return SPEED;
	}

	@Override
	public int getLevel() {
		return TANK_LEVEL;
	}

	@Override
	public AnimatedSprite getEngineEntity() {
		return GameResource.getInstance().tankResources.makeAnimateSprite();
	}

	@Override
	public ACTOR_TEAM getTeam() {
		return ACTOR_TEAM.User;
	}

	@Override
	public int getStepDistance() {
		return STEP_DISTANCE;
	}

	@Override
	public BaseSpriteManager getSpriteResourceInfo() {
		return GameResource.getInstance().tankResources;
	}

}
