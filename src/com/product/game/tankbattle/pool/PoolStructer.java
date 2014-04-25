package com.product.game.tankbattle.pool;

import com.product.game.tankbattle.actor.base.TBActor;
import com.product.game.tankbattle.actor.map.BattleMap;


public abstract class PoolStructer{
	public BattleMap battleMap;
	public int poolSize;
	public TBActor[] poolActors;
	public int indexPool;
	
	public PoolStructer(int size, BattleMap map) {
		poolSize = size;
		indexPool = 0;
		battleMap = map;
		poolActors = new TBActor[poolSize];
	}
	
	protected abstract TBActor makeDefaultActor();
	
	public TBActor getActor() {
		
		indexPool ++;
		if (indexPool == poolSize) {
			indexPool = 0;
		}
		TBActor actor = poolActors[indexPool];
		if (actor == null) {
			actor = makeDefaultActor();
			battleMap.addActor(actor);
			poolActors[indexPool] = actor;
		}
		
		return actor;
	}
}
