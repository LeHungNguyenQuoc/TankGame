package com.product.game.tankbattle.actor.setting;

import com.product.game.tankbattle.actor.base.BaseTBSetting;
import com.product.game.tankbattle.actor.base.TBActor.ACTOR_TYPE;
import com.product.game.tankbattle.config.GameConfiguration;
import com.product.game.tankbattle.resource.GameResource;
import com.product.game.tankbattle.resource.sprite.BaseSpriteManager;

public class BulletSetting implements BaseTBSetting{

	@Override
	public int getDefaultHitPoint() {
		return 1;
	}

	@Override
	public float getDefaultSpeed() {
		return 1000;
	}

	@Override
	public int getDefaultLevel() {
		return 1;
	}

	@Override
	public int getStepDistance() {
		return (int) GameConfiguration.getInstance().CAMERA_WIDTH;
	}

	@Override
	public ACTOR_TYPE getActorType() {
		return ACTOR_TYPE.Bullet;
	}

	@Override
	public BaseSpriteManager getSpriteManager() {
		return GameResource.getInstance().bulletResources;
	}

	@Override
	public float getDefaultAttackFPS() {
		return 0;
	}

}
