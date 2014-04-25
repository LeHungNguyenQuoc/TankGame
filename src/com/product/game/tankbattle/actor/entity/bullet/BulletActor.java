package com.product.game.tankbattle.actor.entity.bullet;

import com.product.game.tankbattle.actor.base.TBActor;
import com.product.game.tankbattle.actor.entity.explosion.ExplosionActor;
import com.product.game.tankbattle.actor.factory.ExplosionFactory;
import com.product.game.tankbattle.pool.PoolManager;
import com.product.game.tankbattle.resolution.Resolution;

public class BulletActor extends TBActor {
	private int mDistance;
	
	public BulletActor() {
		mDistance = 0;
	}
	
	
	public void causeExplosion() {
		ExplosionActor explosionActor = PoolManager.getInstance().getExplosion();
//		explosionActor.addToScene(mScene);
		explosionActor.performExplosionOn(this, null);
		performHidden();
	}
	public void flyUp() {
		if (mDistance > Resolution.BULLET_MAX_WAY) {
			mDistance = 0;
			causeExplosion();
			return;
		}

		mDistance+= Resolution.BULLET_STEP;
		
		stepUp(new IActorMovingEvent() {
			
			@Override
			public void onStartMoving() {
			}
			
			@Override
			public void onEndMoving() {
				flyUp();
			}

			@Override
			public void onForceStopMoving() {
				causeExplosion();
			}
		});
	}
	public void flyDown() {
		if (mDistance > Resolution.BULLET_MAX_WAY) {
			mDistance = 0;
			causeExplosion();
			return;
		}
		mDistance+= Resolution.BULLET_STEP;
		
		stepDown(new IActorMovingEvent() {
			
			@Override
			public void onStartMoving() {
			}
			
			@Override
			public void onEndMoving() {
				flyDown();
			}

			@Override
			public void onForceStopMoving() {
				causeExplosion();
			}
		});
	}
	public void flyLeft() {
		if (mDistance > Resolution.BULLET_MAX_WAY) {
			mDistance = 0;
			causeExplosion();
			return;
		}
		mDistance+= Resolution.BULLET_STEP;
		
		stepLeft(new IActorMovingEvent() {
			
			@Override
			public void onStartMoving() {
			}
			
			@Override
			public void onEndMoving() {
				flyLeft();
			}

			@Override
			public void onForceStopMoving() {
				causeExplosion();
			}
		});
	}
	public void flyRight() {
		if (mDistance > Resolution.BULLET_MAX_WAY) {
			mDistance = 0;
			causeExplosion();
			return;
		}
		mDistance+= Resolution.BULLET_STEP;
		
		stepRight(new IActorMovingEvent() {
			
			@Override
			public void onStartMoving() {
			}
			
			@Override
			public void onEndMoving() {
				flyRight();
			}

			@Override
			public void onForceStopMoving() {
				causeExplosion();
			}
		});
	}
}
