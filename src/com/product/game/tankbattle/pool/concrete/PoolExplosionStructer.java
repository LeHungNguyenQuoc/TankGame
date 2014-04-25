package com.product.game.tankbattle.pool.concrete;

import com.product.game.tankbattle.actor.base.TBActor;
import com.product.game.tankbattle.actor.factory.ExplosionFactory;
import com.product.game.tankbattle.actor.map.BattleMap;
import com.product.game.tankbattle.pool.PoolStructer;

public class PoolExplosionStructer extends PoolStructer{

	public PoolExplosionStructer(int size, BattleMap map) {
		super(size, map);
	}

	@Override
	protected TBActor makeDefaultActor() {
		return ExplosionFactory.getInstances().makeCompleteActor();
	}

}
