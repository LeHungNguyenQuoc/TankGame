package com.product.game.tankbattle.actor.entity.tank;

import org.andengine.entity.sprite.AnimatedSprite;

import com.product.game.tankbattle.actor.base.TBActor;
import com.product.game.tankbattle.actor.entity.bullet.BulletActor;
import com.product.game.tankbattle.actor.factory.BulletFactory;
import com.product.game.tankbattle.resource.GameResource;

public class TankActor extends TBActor{
	
	@Override
	public AnimatedSprite getEngineEntity() {
		return (AnimatedSprite)super.getEngineEntity();
	}
	
	
	public void fireBullet() {
		
		if (!couldBeAttack()) {
			return;
		}
		
		if (mScene == null) {
			return;
		}
		
		BulletActor bullet = BulletFactory.getInstances().makeCompleteActor();
		bullet.addToScene(mScene);
		bullet.setPosition(getX() + getWidth() / 2  - bullet.getWidth()/2 , 
				getY() + getHeight()/2 - bullet.getHeight()/2);
				
		switch (direction) {
		case Down:
			bullet.stepDown();
			break;
		case Left:
			bullet.stepLeft();
			break;
		case Up:
			bullet.stepUp();
			break;
		case Right:
			bullet.stepRight();
			break;

		default:
			break;
		}
	}
	
}
