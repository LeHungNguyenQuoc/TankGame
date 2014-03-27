package com.product.game.tankbattle.actor.factory;

import com.product.game.tankbattle.actor.base.BaseTBFactory;
import com.product.game.tankbattle.actor.entity.explosion.ExplosionActor;
import com.product.game.tankbattle.actor.setting.ExplosionSetting;

public class ExplosionFactory extends BaseTBFactory<ExplosionActor, ExplosionSetting>{
	static ExplosionFactory instances;
	public static ExplosionFactory getInstances() {
		if (instances == null) {
			instances = new ExplosionFactory();
		}
		return instances;
	}
	@Override
	protected ExplosionActor makePlainActor() {
		return new ExplosionActor();
	}

	@Override
	protected ExplosionSetting orderSetting() {
		return new ExplosionSetting();
	}

}
