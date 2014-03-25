package com.product.game.tankbattle.actor.factory;

import com.product.game.tankbattle.actor.base.BaseTBFactory;
import com.product.game.tankbattle.actor.entity.tank.EnermyTank;
import com.product.game.tankbattle.actor.entity.tank.TankActor;
import com.product.game.tankbattle.actor.setting.UserTankSetting;

public class EnermyTankFactory extends BaseTBFactory<EnermyTank, UserTankSetting>{

	private static EnermyTankFactory instance;
	public static EnermyTankFactory getInstance() {
		if (instance == null) {
			instance = new EnermyTankFactory();
		}
		return instance;
	}
	
	@Override
	protected EnermyTank makePlainActor() {
		return new EnermyTank();
	}

	@Override
	protected UserTankSetting orderSetting() {
		return new UserTankSetting();
	}

	
	@Override
	public EnermyTank makeCompleteActor() {
		EnermyTank tank =  super.makeCompleteActor();
		tank.setSpriteFrame(2);
		tank.rotateDown();
		
		return tank;
	}
}
