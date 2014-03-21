package com.product.game.tankbattle.actor.factory;

import com.product.game.tankbattle.actor.entity.tank.EnermyTank;
import com.product.game.tankbattle.actor.entity.tank.TankActor;

public class EnermyTankFactory extends TankFactory{

	@Override
	protected TankActor makePlainTank() {
		return new EnermyTank();
	}
	

}
