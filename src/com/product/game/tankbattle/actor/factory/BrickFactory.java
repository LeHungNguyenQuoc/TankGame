package com.product.game.tankbattle.actor.factory;

import com.product.game.tankbattle.actor.base.BaseTBFactory;
import com.product.game.tankbattle.actor.entity.brick.BrickActor;
import com.product.game.tankbattle.actor.setting.BrickSetting;

public class BrickFactory extends BaseTBFactory<BrickActor, BrickSetting> {

	static BrickFactory instances;
	public static BrickFactory getInstances() {
		if (instances == null) {
			instances = new BrickFactory();
		}
		return instances;
	}
	@Override
	protected BrickActor makePlainActor() {
		return new BrickActor();
	}

	@Override
	protected BrickSetting orderSetting() {
		return new BrickSetting();
	}
	
	public BrickActor makeBrickType(int type) {
		BrickActor brickActor = makeCompleteActor();
		brickActor.setSpriteFrame(type);
		
		return brickActor;
	}

}
