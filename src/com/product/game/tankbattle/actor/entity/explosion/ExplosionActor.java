package com.product.game.tankbattle.actor.entity.explosion;

import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.AnimatedSprite.IAnimationListener;

import com.product.game.tankbattle.actor.base.TBActor;

public class ExplosionActor extends TBActor{
	
	public interface IExplosionEvent {
		public void startExplosion();
		public void endExplosion();
	}
	
	public void performExplosionOn(TBActor actor, final IExplosionEvent event) {
		float x = actor.getX() + actor.getWidth()/2 - getWidth()/2;
		float y = actor.getY() + actor.getHeight()/2 - getHeight()/2;
		
		setPosition(x, y);
		long[] pFrameDurations = {100, 100, 100, 100, 100, 100, 100, 100, 100};
		int[] pFrames = {0, 2, 4, 6, 7, 6, 4, 2, 0};
		actorEntity.animate(pFrameDurations, pFrames, false, new IAnimationListener() {
			
			@Override
			public void onAnimationStarted(AnimatedSprite pAnimatedSprite,
					int pInitialLoopCount) {
				if (event != null) {
					event.startExplosion();
				}
			}
			
			@Override
			public void onAnimationLoopFinished(AnimatedSprite pAnimatedSprite,
					int pRemainingLoopCount, int pInitialLoopCount) {
				
			}
			
			@Override
			public void onAnimationFrameChanged(AnimatedSprite pAnimatedSprite,
					int pOldFrameIndex, int pNewFrameIndex) {
				
			}
			
			@Override
			public void onAnimationFinished(AnimatedSprite pAnimatedSprite) {
				performHidden();
				if (event != null) {
					event.endExplosion();
				}
			}
		});
	}
}
