package com.product.game.tankbattle.actor.map;

import java.util.ArrayList;
import java.util.Random;

import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.util.color.Color;

import com.product.game.tankbattle.actor.entity.brick.BrickActor;
import com.product.game.tankbattle.actor.factory.BrickFactory;
import com.product.game.tankbattle.config.GameConfiguration;
import com.product.game.tankbattle.resolution.Resolution;
import com.product.game.tankbattle.resource.GameResource;

import android.R.integer;
import android.graphics.Rect;

public class BattleMap {
	public Rect rectMap;
	public Scene mScene;
	
	public ArrayList<BrickActor> bricks;
	public Rectangle mapBackground;
	
	public BattleMap(Scene scene) {
		
		mScene = scene;
		int off_x = Resolution.SCREEN_WIDTH/2 - Resolution.BATTLE_W/2;
		rectMap = new Rect(off_x, 0, Resolution.BATTLE_W + off_x, Resolution.SCREEN_HEIGHT);
		
		
		mapBackground = new Rectangle(off_x, 0, Resolution.BATTLE_W, Resolution.BATTLE_H, GameResource.getInstance().vertexBufferObjectManager);
		mapBackground.setColor(Color.BLACK);
		scene.attachChild(mapBackground);
		
		bricks = new ArrayList<BrickActor>();
		
		Random random = new Random();
		for(int i = 0; i < Resolution.BATTLE_W / Resolution.BRICK_W; i++) {
			for (int j = 0; j < Resolution.BATTLE_H / Resolution.BRICK_H; j++) {
				if(random.nextBoolean()) {
					BrickActor brickActor = BrickFactory.getInstances().makeBrickType(random.nextInt(4));
					brickActor.setPosition(off_x + i* Resolution.BRICK_W, j* Resolution.BRICK_H);
					bricks.add(brickActor);
					brickActor.addToBattleMap(this);
				}
			}
		}
		
	}
}
