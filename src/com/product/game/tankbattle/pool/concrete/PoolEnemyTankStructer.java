package com.product.game.tankbattle.pool.concrete;

import com.product.game.tankbattle.actor.base.TBActor;
import com.product.game.tankbattle.actor.factory.EnermyTankFactory;
import com.product.game.tankbattle.actor.map.BattleMap;
import com.product.game.tankbattle.pool.PoolStructer;

public class PoolEnemyTankStructer extends PoolStructer{

	public PoolEnemyTankStructer(int size, BattleMap map) {
		super(size, map);
	}

	@Override
	protected TBActor makeDefaultActor() {
		return EnermyTankFactory.getInstance().makeCompleteActor();
	}

}
