package com.product.game.tankbattle.actor.base;


public abstract class BaseTBFactory<T extends TBActor, S extends BaseTBSetting>{
	protected abstract T makePlainActor();
	protected abstract S orderSetting();
	
	public T makeCompleteActor() {
		T actor = makePlainActor();
		actor.actorID = ++TBActor.actorIdValue;
		
		S setting = orderSetting();
		actor.spriteInfo = setting.getSpriteManager();
		actor.actorType = setting.getActorType();
		actor.speed = setting.getDefaultSpeed();
		actor.hitPoint = setting.getDefaultHitPoint();
		actor.level = setting.getDefaultLevel();
		actor.stepDistance = setting.getStepDistance();
		actor.attackFPS = setting.getDefaultAttackFPS();
		
		actor.direction = actor.spriteInfo.getDefaultDirection();
		actor.actorEntity = actor.spriteInfo.makeAnimateSprite();
		
		return actor;
	}	
}
