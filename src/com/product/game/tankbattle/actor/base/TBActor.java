package com.product.game.tankbattle.actor.base;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.andengine.entity.modifier.MoveXModifier;
import org.andengine.entity.modifier.MoveYModifier;
import org.andengine.entity.scene.Scene;
import org.andengine.util.modifier.IModifier;

import android.content.Entity;

import com.product.game.tankbattle.actor.TBActorHelper;
import com.product.game.tankbattle.resource.sprite.BaseSpriteManager;
public abstract class TBActor {
	
	public interface IActorMovingEvent {
		public void onStartMoving();
		public void onEndMoving();
	}
	
	public static int actorIdValue = 0;
	
	public enum ACTOR_TYPE {
		Tank, Brick, Item, Bullet,
	}
	
	public enum ACTOR_TEAM {
		User, Enermy, Monster, Neutral,
	}
	
	public int actorID;	
	public ACTOR_TYPE actorType;
	public ACTOR_TEAM actorTeam;
	protected IEntity actorEntity;
	public BaseSpriteManager spriteInfo;
	
	public int hitPoint;
	public float speed;
	public int level;

	
	public boolean canAttack;

	protected boolean isMoving;
	
	public TBActor() {
		isMoving = false;
		actorID = actorIdValue;
		actorIdValue ++;
	}
		
	public float getX() {
		return actorEntity.getX();
	}
	
	public float getY() {
		return actorEntity.getY();
	}
	
	public void setPosition(float pX, float pY) {
		actorEntity.setPosition(pX, pY);
	}
	
	
	public void setEngineEntity(IEntity entity) {
		actorEntity = entity;
	}
	
	public IEntity getEngineEntity() {
		return actorEntity;
	}
	
	public void addToScene(Scene scene) {
		scene.attachChild(actorEntity);
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
		float duration = TBActorHelper.getDurationSecond(fromX, toX, speed);
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
					eventListener.onStartMoving();
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
		float duration = TBActorHelper.getDurationSecond(fromY, toY, speed);
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
					eventListener.onStartMoving();
				}
			}
		}));
	}
}
