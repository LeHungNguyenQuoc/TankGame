package com.product.game.tankbattle.actor.entity.bullet;

import com.product.game.tankbattle.actor.base.TBActor;
import com.product.game.tankbattle.resolution.Resolution;

public class BulletActor extends TBActor {
	private int mDistance;
	
	public BulletActor() {
		mDistance = 0;
	}
	public void flyUp() {
		if (mDistance > Resolution.BULLET_MAX_WAY) {
			mDistance = 0;
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
		});
	}
	public void flyDown() {
		if (mDistance > Resolution.BULLET_MAX_WAY) {
			mDistance = 0;
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
		});
	}
	public void flyLeft() {
		if (mDistance > Resolution.BULLET_MAX_WAY) {
			mDistance = 0;
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
		});
	}
	public void flyRight() {
		if (mDistance > Resolution.BULLET_MAX_WAY) {
			mDistance = 0;
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
		});
	}
}
