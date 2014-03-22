package com.product.game.tankbattle.actor.factory;

import com.product.game.tankbattle.actor.entity.tank.TankActor;
import com.product.game.tankbattle.actor.entity.tank.UserTank;

public class UserTankFactory extends TankFactory {
	
	private static UserTankFactory _instance;
	
	public static UserTankFactory getInstance() {
		if (_instance == null) {
			_instance = new UserTankFactory();
		}
		return _instance;
	}
	
	@Override
	protected TankActor makePlainTank() {
		return new UserTank();
	}
}
