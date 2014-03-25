package com.product.game.tankbattle.actor.base;

import com.product.game.tankbattle.actor.base.TBActor.ACTOR_TYPE;
import com.product.game.tankbattle.resource.sprite.BaseSpriteManager;

public interface BaseTBSetting {
	public int getDefaultHitPoint();
	public float getDefaultSpeed();
	public int getDefaultLevel();
	public int getStepDistance();
	public ACTOR_TYPE getActorType();
	public float getDefaultAttackFPS();
	public BaseSpriteManager getSpriteManager();
	public int getActorWidth();
	public int getActorHeight();
}
