package com.product.game.tankbattle.actor.factory;

import com.product.game.tankbattle.actor.base.BaseTBFactory;
import com.product.game.tankbattle.actor.entity.bullet.BulletActor;
import com.product.game.tankbattle.actor.setting.BulletSetting;

public class BulletFactory extends BaseTBFactory<BulletActor, BulletSetting>{

	static	BulletFactory instances;
	public static BulletFactory getInstances() {
		if (instances == null) {
			instances = new BulletFactory();
		}
		return instances;
	}
	@Override
	protected BulletActor makePlainActor() {
		return new BulletActor();
	}
	@Override
	protected BulletSetting orderSetting() {
		return new BulletSetting();
	}

}
