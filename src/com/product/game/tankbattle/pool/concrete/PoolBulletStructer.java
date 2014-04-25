package com.product.game.tankbattle.pool.concrete;

import com.product.game.tankbattle.actor.base.TBActor;
import com.product.game.tankbattle.actor.factory.BulletFactory;
import com.product.game.tankbattle.actor.map.BattleMap;
import com.product.game.tankbattle.pool.PoolStructer;

public class PoolBulletStructer extends PoolStructer{

	public PoolBulletStructer(int size, BattleMap map) {
		super(size, map);
	}

	@Override
	protected TBActor makeDefaultActor() {
		return BulletFactory.getInstances().makeCompleteActor();
	}

}
