package com.product.game.tankbattle.actor.setting;

import org.andengine.entity.IEntity;

import com.product.game.tankbattle.actor.base.TBActor.ACTOR_TEAM;
import com.product.game.tankbattle.actor.sprite.BaseSpriteResourceInfo;


public interface TankSetting {
	public int getHitPoint();
	public float getSpeed();
	public int getLevel();
	public IEntity getEngineEntity();
	public ACTOR_TEAM getTeam();
	public int getStepDistance();
	public BaseSpriteResourceInfo getSpriteResourceInfo();
}
