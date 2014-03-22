package com.product.game.tankbattle.controller;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.AnimatedSprite;

import com.product.game.tankbattle.config.GameConfiguration;
import com.product.game.tankbattle.config.GameResource;

public class GameController {
	public AnimatedSprite dpadSprite;
	public GameController() {
		
		dpadSprite = GameResource.getInstance().controller.dPad.makeAnimateSprite();
		dpadSprite.setPosition(0, (GameConfiguration.getInstance().CAMERA_HEIGHT - dpadSprite.getHeight()) /2);		
	}
	
	public void addToScene(Scene scene) {
		scene.attachChild(dpadSprite);
	}
	
}



