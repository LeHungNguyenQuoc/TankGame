package com.product.game.tankbattle.actor.setting;

import org.andengine.entity.IEntity;

import com.product.game.tankbattle.actor.base.TBActor.ACTOR_TEAM;

public class UserTankSetting implements TankSetting {

	@Override
	public int getHitPoint() {
		return 50;
	}

	@Override
	public float getSpeed() {
		return 100;
	}

	@Override
	public int getLevel() {
		return 1;
	}

	@Override
	public IEntity getEngineEntity() {
		return null;
	}

	@Override
	public ACTOR_TEAM getTeam() {
		return ACTOR_TEAM.User;
	}

}
