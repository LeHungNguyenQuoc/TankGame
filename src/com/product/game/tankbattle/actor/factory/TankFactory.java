package com.product.game.tankbattle.actor.factory;

import com.product.game.tankbattle.actor.base.TBActor.ACTOR_TYPE;
import com.product.game.tankbattle.actor.entity.tank.TankActor;
import com.product.game.tankbattle.actor.setting.TankSetting;


public abstract class TankFactory {
	
	protected abstract TankActor makePlainTank();
	
	public TankActor makeCompleteTank(TankSetting setting) {
		TankActor tankActor = makePlainTank();
		//tank default
		tankActor.canAttack = true;
		tankActor.actorType = ACTOR_TYPE.Tank;
		
		// tank attribute
		tankActor.actorEntity = setting.getEngineEntity();
		tankActor.hitPoint = setting.getHitPoint();
		tankActor.level = setting.getLevel();
		tankActor.speed = setting.getSpeed();
		tankActor.actorTeam = setting.getTeam();
		
		return tankActor;
	}

}
