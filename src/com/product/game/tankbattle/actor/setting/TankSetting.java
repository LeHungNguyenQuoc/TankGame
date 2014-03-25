package com.product.game.tankbattle.actor.setting;

import org.andengine.entity.sprite.AnimatedSprite;

import com.product.game.tankbattle.actor.base.TBActor.ACTOR_TEAM;
import com.product.game.tankbattle.resource.sprite.BaseSpriteManager;


public interface TankSetting {
	public int getHitPoint();
	public float getSpeed();
	public int getLevel();
	public AnimatedSprite getEngineEntity();
	public ACTOR_TEAM getTeam();
	public int getStepDistance();
	public BaseSpriteManager getSpriteResourceInfo();
}
