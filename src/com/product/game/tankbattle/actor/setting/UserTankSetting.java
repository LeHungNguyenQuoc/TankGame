package com.product.game.tankbattle.actor.setting;

import com.product.game.tankbattle.actor.base.BaseTBSetting;
import com.product.game.tankbattle.actor.base.TBActor.ACTOR_TYPE;
import com.product.game.tankbattle.resolution.Resolution;
import com.product.game.tankbattle.resource.GameResource;
import com.product.game.tankbattle.resource.sprite.BaseSpriteManager;

public class UserTankSetting implements BaseTBSetting {
	
	@Override
	public int getDefaultHitPoint() {
		return 1;
	}
	@Override
	public float getDefaultSpeed() {
		return 500;
	}
	@Override
	public int getDefaultLevel() {
		return 1;
	}
	@Override
	public int getStepDistance() {
		return Resolution.TANK_USER_STEP_DISTANCE;
	}
	@Override
	public ACTOR_TYPE getActorType() {
		return ACTOR_TYPE.Tank;
	}
	@Override
	public BaseSpriteManager getSpriteManager() {
		return GameResource.getInstance().tank;
	}
	@Override
	public float getDefaultAttackFPS() {
		return 5;
	}
	@Override
	public int getActorWidth() {
		return Resolution.TANK_W;
	}

	@Override
	public int getActorHeight() {
		return Resolution.TANK_H;
	}

}
