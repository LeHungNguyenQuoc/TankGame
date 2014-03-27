package com.product.game.tankbattle.actor.setting;

import com.product.game.tankbattle.resolution.Resolution;


public class EnemyTankSetting extends UserTankSetting{
	@Override
	public int getStepDistance() {
		return Resolution.TANK_ENEMY_STEP_DISTANCE;
	}
	
	@Override
	public float getDefaultSpeed() {
		return Resolution.TANK_ENEMY_SPEED;
	}
}
