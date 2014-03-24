package com.product.game.tankbattle.actor.entity.tank;

import org.andengine.entity.sprite.AnimatedSprite;

import com.product.game.tankbattle.actor.base.TBActor;
import com.product.game.tankbattle.resource.GameResource;

public class TankActor extends TBActor{
	public int stepDistance;
	
	@Override
	public AnimatedSprite getEngineEntity() {
		return (AnimatedSprite)super.getEngineEntity();
	}
	
	
	public void stepUp() {
		if (isMoving) {
			return;
		}
		
		isMoving = true;
		moveByY(getY(), getY() - stepDistance, new IActorMovingEvent() {
			
			@Override
			public void onStartMoving() {
				rotate(spriteInfo.getRotateUpAngle());
			}
			
			@Override
			public void onEndMoving() {
				isMoving = false;
			}
		});
	}
	
	public void stepDown() {
		if (isMoving) {
			return;
		}
		
		isMoving = true;
		moveByY(getY(), getY() + stepDistance, new IActorMovingEvent() {
			
			@Override
			public void onStartMoving() {
				rotate(spriteInfo.getRotateDownAngle());
			}
			
			@Override
			public void onEndMoving() {
				isMoving = false;
			}
		});
		
	}
	
	public void stepLeft() {
		if (isMoving) {
			return;
		}
		
		isMoving = true;
		moveByX(getX(), getX() - stepDistance, new IActorMovingEvent() {
			
			@Override
			public void onStartMoving() {
				rotate(spriteInfo.getRotateLeftAngle());
			}
			
			@Override
			public void onEndMoving() {
				isMoving = false;
			}
		});
		
	}
	
	public void stepRight() {
		if (isMoving) {
			return;
		}
		
		isMoving = true;
		moveByX(getX(), getX() + stepDistance, new IActorMovingEvent() {
			
			@Override
			public void onStartMoving() {
				rotate(spriteInfo.getRotateRightAngle());
			}
			
			@Override
			public void onEndMoving() {
				isMoving = false;
			}
		});
		
	}
}
