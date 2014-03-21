package com.product.game.tankbattle.actor.factory;

import com.product.game.tankbattle.actor.entity.tank.TankActor;

public class UserTankFactory extends TankFactory {

	@Override
	protected TankActor makePlainTank() {
		return new TankActor();
	}
}
