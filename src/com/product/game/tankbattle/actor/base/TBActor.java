package com.product.game.tankbattle.actor.base;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.andengine.entity.modifier.MoveXModifier;
import org.andengine.entity.modifier.MoveYModifier;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.util.modifier.IModifier;

import com.product.game.tankbattle.actor.map.BattleMap;
import com.product.game.tankbattle.resource.sprite.BaseSpriteManager;
public abstract class TBActor {
	
	public interface IActorMovingEvent {
		public void onStartMoving();
		public void onEndMoving();
		public void onForceStopMoving();
	}
	
	public static int actorIdValue = 0;
	
	public enum ACTOR_TYPE {
		Tank, Brick, Item, Bullet, Explosion,
	}
	
	public enum ACTOR_TEAM {
		User, Enermy, Monster, Neutral,
	}
	
	public enum ACTOR_DIRECTION {
		Up, Down, Left, Right, Unknow,
	}
	
	
	public int actorID;	
	public ACTOR_TYPE actorType;
	public ACTOR_TEAM actorTeam;
	protected AnimatedSprite actorEntity;
	public BaseSpriteManager spriteInfo;
	public int hitPoint;
	public float speed;
	public int level;
	public int stepDistance;
	public float attackFPS;
	public ACTOR_DIRECTION direction;
	
	private boolean isMoving;
	private long mLastAttackTimeMS;
	
	protected Scene mScene;
	public BattleMap battleMap;
	
	public TBActor() {
		isMoving = false;
		mLastAttackTimeMS = 0;
		actorID = actorIdValue;
		actorIdValue ++;
	}
	
	/**
	 **********************************************************************************************************
	 * Basic attributes
	 **********************************************************************************************************
	 */
		
	public float getX() {
		return actorEntity.getX();
	}
	
	public float getY() {
		return actorEntity.getY();
	}
	
	public float getWidth() {
		return actorEntity.getWidth();
	}
	
	public float getHeight() {
		return actorEntity.getHeight();
	}
	
	public void setPosition(float pX, float pY) {
		actorEntity.setPosition(pX, pY);
	}
	
	
	public void setSpriteFrame(int index) {
		actorEntity.setCurrentTileIndex(index);
	}
		
	public void setEngineEntity(AnimatedSprite entity) {
		actorEntity = entity;
	}
	
	public IEntity getEngineEntity() {
		return actorEntity;
	}
	
	public void addToScene(Scene scene) {
		mScene = scene;
		mScene.attachChild(actorEntity);
	}
	
	public void performHidden() {
		actorEntity.setPosition(-getWidth(), -getHeight());
//		mScene.detachChild(actorEntity);
	}

	
	/**
	 **********************************************************************************************************
	 * Rotations, Movements, Attack
	 **********************************************************************************************************
	 */
	
	private float getDurationSecond(float pFrom, float pTo, float speed) {
		return Math.abs(pFrom - pTo) / speed;
	}
	
	public void rotate(Float angle) {
		actorEntity.setRotation(angle);
	}
		
	/**
	 * move object by X coordinate
	 * @param fromX
	 * @param toX
	 * @param eventListener
	 */
	public void moveByX(float fromX, float toX, final IActorMovingEvent eventListener ) {
		
		if (fromX == toX) {
			isMoving = false;
			if (eventListener != null) {
				eventListener.onForceStopMoving();
			}
			return;
		}
		
		float duration = getDurationSecond(fromX, toX, speed);
		actorEntity.registerEntityModifier(new MoveXModifier(duration, fromX, toX, new IEntityModifierListener() {
			
			@Override
			public void onModifierStarted(IModifier<IEntity> pModifier, IEntity pItem) {
				isMoving = true;
				if (eventListener != null) {
					eventListener.onStartMoving();
				}
			}
			
			@Override
			public void onModifierFinished(IModifier<IEntity> pModifier, IEntity pItem) {
				isMoving = false;
				if (eventListener != null) {
					eventListener.onEndMoving();
				}
			}
		}));
	}
	
	/**
	 * move object by Y coordinate
	 * @param fromY
	 * @param toY
	 * @param eventListener
	 */
	public void moveByY(float fromY, float toY, final IActorMovingEvent eventListener ) {
		
		if (fromY == toY) {
			isMoving = false;
			if (eventListener != null) {
				eventListener.onForceStopMoving();
			}
			return;
		}
		
		float duration = getDurationSecond(fromY, toY, speed);
		actorEntity.registerEntityModifier(new MoveYModifier(duration, fromY, toY, new IEntityModifierListener() {
			
			@Override
			public void onModifierStarted(IModifier<IEntity> pModifier, IEntity pItem) {
				isMoving = true;
				if (eventListener != null) {
					eventListener.onStartMoving();
				}
			}
			
			@Override
			public void onModifierFinished(IModifier<IEntity> pModifier, IEntity pItem) {
				isMoving = false;
				if (eventListener != null) {
					eventListener.onEndMoving();
				}
			}
		}));
	}
	
	
	
	/**
	 * actor steps up
	 */
	public void stepUp(final IActorMovingEvent 	event) {
		if (isMoving) {
			return;
		}
		
		rotateUp();
		float newY = Math.max(getY() - stepDistance, battleMap.getCollisonUpSide(this));
		moveByY(getY(), newY,event);
	}
	
	/**
	 * actor steps down
	 */
	public void stepDown(final IActorMovingEvent event) {
		if (isMoving) {
			return;
		}
		
		rotateDown();
		float newY = Math.min(getY() + stepDistance, battleMap.getCollisonDownSide(this) - getHeight());
		moveByY(getY(), newY, event); 
	}
	
	/**
	 * actor steps left
	 */
	public void stepLeft(final IActorMovingEvent event) {
		if (isMoving) {
			return;
		}
		
		rotateLeft();
		float newX = Math.max(getX() - stepDistance, battleMap.getCollisonLeftSide(this));
		moveByX(getX(), newX, event);
		
	}
	
	/**
	 * actor steps right
	 */
	public void stepRight(final IActorMovingEvent event) {
		if (isMoving) {
			return;
		}
		
		rotateRight();
		float newX = Math.min(getX() + stepDistance, battleMap.getCollisonRightSide(this) - getWidth());

		moveByX(getX(), newX, event);
	}
	
	/**
	 * actor rotate up 
	 */
	public void rotateUp() {
		this.rotate(spriteInfo.getRotateUpAngle());
		direction = ACTOR_DIRECTION.Up;
	}
	/**
	 * actor rotate down 
	 */
	public void rotateDown() {
		this.rotate(spriteInfo.getRotateDownAngle());
		direction = ACTOR_DIRECTION.Down;
	}
	/**
	 * actor rotate left 
	 */
	public void rotateLeft() {
		this.rotate(spriteInfo.getRotateLeftAngle());
		direction = ACTOR_DIRECTION.Left;
	}
	/**
	 * actor rotate right 
	 */
	public void rotateRight() {
		this.rotate(spriteInfo.getRotateRightAngle());
		direction = ACTOR_DIRECTION.Right;
	}
	
	/**
	 * actor attack
	 */
	protected boolean couldBeAttack() {
		long curMS = System.currentTimeMillis();
		if (curMS - mLastAttackTimeMS > ((float)1000/attackFPS) ) {
			mLastAttackTimeMS = curMS;
			return true;
		}
		return false;
	}
}
