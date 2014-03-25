package com.product.game.tankbattle.actor.factory;

import com.product.game.tankbattle.actor.base.BaseTBFactory;
import com.product.game.tankbattle.actor.entity.tank.UserTank;
import com.product.game.tankbattle.actor.setting.UserTankSetting;

public class UserTankFactory extends BaseTBFactory<UserTank, UserTankSetting> {

	private static UserTankFactory instance;
	public static UserTankFactory getInstance() {
		if (instance == null) {
			instance = new UserTankFactory();
		}
		return instance;
	}
	
	@Override
	protected UserTank makePlainActor() {
		return new UserTank();
	}

	@Override
	protected UserTankSetting orderSetting() {
		return new UserTankSetting();
	}
	
}
