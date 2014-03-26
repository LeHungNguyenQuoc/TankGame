package com.product.game.tankbattle.actor.map;

import java.util.ArrayList;
import java.util.Random;

import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.util.color.Color;

import com.product.game.tankbattle.actor.base.TBActor;
import com.product.game.tankbattle.actor.entity.brick.BrickActor;
import com.product.game.tankbattle.actor.factory.BrickFactory;
import com.product.game.tankbattle.config.GameConfiguration;
import com.product.game.tankbattle.resolution.Resolution;
import com.product.game.tankbattle.resource.GameResource;

import android.R.integer;
import android.graphics.Rect;

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
				if(random.nextBoolean()) {
					BrickActor brickActor = BrickFactory.getInstances().makeBrickType(random.nextInt(4));
					addActor(brickActor, i, j);
					bricks.add(brickActor);
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
}


