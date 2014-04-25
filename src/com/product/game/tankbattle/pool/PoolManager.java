package com.product.game.tankbattle.pool;

import com.product.game.tankbattle.actor.entity.bullet.BulletActor;
import com.product.game.tankbattle.actor.entity.explosion.ExplosionActor;
import com.product.game.tankbattle.actor.entity.tank.TankActor;
import com.product.game.tankbattle.actor.map.BattleMap;
import com.product.game.tankbattle.pool.concrete.PoolBulletStructer;
import com.product.game.tankbattle.pool.concrete.PoolEnemyTankStructer;
import com.product.game.tankbattle.pool.concrete.PoolExplosionStructer;

public class PoolManager {
	
	final static int BULLET_POOL_SIZE = 50;
	final static int ENEMY_TANK_POOL_SIZE = 30;
	final static int EXPLOSION_POOL_SIZE = 30;
	
	private static PoolManager instances;
	private BattleMap mBattleMap;
	
	private PoolBulletStructer _bulletStructer;
	private PoolEnemyTankStructer _tankStructer;
	private PoolExplosionStructer _explosionStructer;
	
	public static void init(BattleMap map) {
		instances = new PoolManager(map);
	}
	
	public static PoolManager getInstance() {
		return instances;
	}
	
	private PoolManager(BattleMap map) {
		mBattleMap = map;
		_bulletStructer = new PoolBulletStructer(BULLET_POOL_SIZE, mBattleMap);
		_tankStructer = new PoolEnemyTankStructer(ENEMY_TANK_POOL_SIZE, mBattleMap);
		_explosionStructer = new PoolExplosionStructer(EXPLOSION_POOL_SIZE, mBattleMap);
	}
	
	
	public BulletActor getBullet() {
		return (BulletActor) _bulletStructer.getActor();
	}
	public TankActor getEnemyTank() {
		return (TankActor) _tankStructer.getActor();
	}
	public ExplosionActor getExplosion() {
		return (ExplosionActor) _explosionStructer.getActor();
	}
}
