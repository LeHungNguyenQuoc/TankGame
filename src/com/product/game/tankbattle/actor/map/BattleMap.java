package com.product.game.tankbattle.actor.map;

import java.util.ArrayList;
import java.util.Random;

import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.util.color.Color;

import android.graphics.Rect;

import com.product.game.tankbattle.actor.base.TBActor;
import com.product.game.tankbattle.actor.entity.brick.BrickActor;
import com.product.game.tankbattle.actor.factory.BrickFactory;
import com.product.game.tankbattle.resolution.Resolution;
import com.product.game.tankbattle.resource.GameResource;

public class BattleMap {
	public Rect rectMap;
	private Scene mScene;
	public int numTileX;
	public int numTileY;
	public int tileWidth;
	public int tileHeight;
	public int batleWidth;
	public int batleHeight;
	
	private int mOffX;
	
	public ArrayList<BrickActor> bricks;
	public Rectangle mapBackground;
	
	public BattleMap(Scene scene) {
		
		this.batleWidth = Resolution.BATTLE_W;
		this.batleHeight = Resolution.BATTLE_H;
		
		this.tileWidth = Resolution.BRICK_W;
		this.tileHeight = Resolution.BRICK_H;
		
		this.numTileX = batleWidth/tileWidth;
		this.numTileY = batleHeight/tileHeight;
		
		mScene = scene;
		mOffX = Resolution.SCREEN_WIDTH/2 - batleWidth/2;
		rectMap = new Rect(mOffX, 0, batleWidth + mOffX, batleHeight);
		
		
		mapBackground = new Rectangle(mOffX, 0, batleWidth, batleHeight, GameResource.getInstance().vertexBufferObjectManager);
		mapBackground.setColor(Color.BLACK);
		scene.attachChild(mapBackground);
		
		bricks = new ArrayList<BrickActor>();
		
		Random random = new Random();
		for(int i = 0; i < numTileX; i++) {
			for (int j = 0; j < numTileY; j++) {
				BrickActor brickActor = BrickFactory.getInstances().makeBrickType(random.nextInt(4));
				bricks.add(brickActor);
				if(random.nextInt(3) == 1) {
					addActor(brickActor, i, j);
				}
			}
		}
	}
	
	public void addActor(TBActor actor, int coordX, int coorY) {
		actor.addToScene(mScene);
		actor.setPosition(mOffX + coordX*tileWidth, coorY*tileHeight);
		actor.battleMap = this;
	}
	
	public void addActor(TBActor actor) {
		addActor(actor, 0, 0);
	}
	
	private BrickActor getBrickAtCoord(int coordX, int coordY) {
		return bricks.get(coordX* numTileY + coordY);
	}
	
	public int countActorCoordX(TBActor actor) {
		return (int) ((actor.getX() - mOffX )/tileWidth);
	}
	
	public int countActorCoordY(TBActor actor) {
		return (int) ((actor.getY())/tileHeight);
	}
	
	/**
	 **********************************************************************************************************
	 * Collison
	 **********************************************************************************************************
	 */
	
//	private boolean isFitBrickX(BrickActor brick, TBActor actor) {
//		return (brick.getX() <= actor.getX()
//				&& (brick.getX() + brick.getWidth()) >= (actor.getX() + actor.getWidth()));
//	}
//	
//	private boolean isFitBrickY(BrickActor brick, TBActor actor) {
//		return (brick.getY() <= actor.getY()
//				&& (brick.getY() + brick.getHeight()) >= (actor.getY() + actor.getHeight()));
//	}
	
	
	private boolean isCollisionX(BrickActor brick, TBActor actor) {
		return !(brick.getX() + brick.getHeight() <= actor.getX() || brick.getX() >= actor.getX() + actor.getWidth());
	}
	
	private boolean isCollisionY(BrickActor brick, TBActor actor) {
		return !(brick.getY() + brick.getHeight() <= actor.getY() || brick.getY() >= actor.getY() + actor.getHeight());
	}
	/**
	 * Collision with up side
	 * @param actor
	 * @return
	 */
	public int getCollisonUpSide(TBActor actor) {
		int coordX = countActorCoordX(actor);
		int coordY = countActorCoordY(actor);
		
		if (coordY == 0) {
			return rectMap.top;
		}
		
		ArrayList<BrickActor> upBricks = new ArrayList<BrickActor>();
		upBricks.add(getBrickAtCoord(coordX, coordY - 1));
		if (coordX > 0) {
			upBricks.add(getBrickAtCoord(coordX - 1, coordY - 1));
		}
		
		if (coordX < numTileX - 1) {
			upBricks.add(getBrickAtCoord(coordX + 1, coordY - 1));
		}
		
		int result = rectMap.top;
		for (BrickActor brick : upBricks) {
			if (!brick.couldBeThrough 
				&& brick.battleMap != null
				&& isCollisionX(brick, actor)) {
				
				result = (int) Math.max(result, brick.getY() + brick.getHeight());
			}
		}
		return result;
	}
	
	/**
	 * Collision with down side
	 * @param actor
	 * @return
	 */
	public int getCollisonDownSide(TBActor actor) {
		int coordX = countActorCoordX(actor);
		int coordY = countActorCoordY(actor);
		
		if (coordY == numTileY - 1) {
			return rectMap.bottom;
		}
		
		ArrayList<BrickActor> downBricks = new ArrayList<BrickActor>();
		downBricks.add(getBrickAtCoord(coordX, coordY + 1));
		if (coordX > 0) {
			downBricks.add(getBrickAtCoord(coordX - 1, coordY + 1));
		}
		if (coordX < numTileX - 1) {
			downBricks.add(getBrickAtCoord(coordX + 1, coordY + 1));
		}
		
		int result = rectMap.bottom;
		for (BrickActor brick : downBricks) {
			if (!brick.couldBeThrough 
					&& brick.battleMap != null
					&& isCollisionX(brick, actor)) {
				
				result = (int) Math.min(result, brick.getY());
			}
		}
		return result;
	}
	
	/**
	 * Collision with left side
	 * @param actor
	 * @return
	 */
	public int getCollisonLeftSide(TBActor actor) {
		int coordX = countActorCoordX(actor);
		int coordY = countActorCoordY(actor);
		
		if (coordX == 0) {
			return rectMap.left;
		}
		
		ArrayList<BrickActor> leftBricks = new ArrayList<BrickActor>();
		leftBricks.add(getBrickAtCoord(coordX - 1, coordY));
		if (coordY > 0) {
			leftBricks.add(getBrickAtCoord(coordX - 1, coordY - 1));
		}
		
		if (coordY < numTileY - 1) {
			leftBricks.add(getBrickAtCoord(coordX - 1, coordY + 1));
		}
		
		int result = rectMap.left;
		for (BrickActor brick : leftBricks) {
			if (!brick.couldBeThrough 
					&& brick.battleMap != null
					&& isCollisionY(brick, actor)) {
				
				result = (int) Math.max(result, brick.getX() + brick.getWidth());
			}
		}
		return result;
	}
	
	/**
	 * Collision with left side
	 * @param actor
	 * @return
	 */
	public int getCollisonRightSide(TBActor actor) {
		int coordX = countActorCoordX(actor);
		int coordY = countActorCoordY(actor);
		
		if (coordX == numTileX - 1) {
			return rectMap.right;
		}
		
		ArrayList<BrickActor> rightBricks = new ArrayList<BrickActor>();
		rightBricks.add(getBrickAtCoord(coordX + 1, coordY));
		if (coordY > 0) {
			rightBricks.add(getBrickAtCoord(coordX + 1, coordY - 1));
		}
		
		if (coordY < numTileY - 1) {
			rightBricks.add(getBrickAtCoord(coordX + 1, coordY + 1));
		}
		
		int result = rectMap.right;
		for (BrickActor brick : rightBricks) {
			if (!brick.couldBeThrough 
					&& brick.battleMap != null
					&& isCollisionY(brick, actor)) {
				
				result = (int) Math.min(result, brick.getX());
			}
		}
		return result;
	}
}


