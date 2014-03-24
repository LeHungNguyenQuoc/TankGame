package com.product.game.tankbattle.controller;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.input.touch.TouchEvent;

import com.product.game.tankbattle.actor.sprite.BaseSpriteResourceInfo.ITouchOnSprite;
import com.product.game.tankbattle.config.GameConfiguration;
import com.product.game.tankbattle.config.GameResource;
import com.product.game.tankbattle.controller.DPadSprite.IDPadSpriteListener;

public class GameController implements IDPadSpriteListener{

	
	public enum MoveCommand {
		up, down, left, right, nothing,
	}
	
	public enum FireCommand {
		fire, nothing,
	}
	
	public MoveCommand currentMoveCommand;
	public FireCommand currentFireCommand;
	
	public DPadSprite dpadSprite;
	public AnimatedSprite fireSprite;
	
	
	public GameController() {
		currentMoveCommand = MoveCommand.nothing;
		dpadSprite = (DPadSprite) GameResource.getInstance().controller.dPad.makeAnimateSprite();
		dpadSprite.setPosition(0, (GameConfiguration.getInstance().CAMERA_HEIGHT - dpadSprite.getHeight()) /2);	
		dpadSprite.registerListener(this);
		
		
		fireSprite = GameResource.getInstance().controller.fireButton.makeAnimateSprite(new ITouchOnSprite() {
			
			@Override
			public boolean onAreaTouched(TouchEvent pSceneTouchEvent,
					float pTouchAreaLocalX, float pTouchAreaLocalY) {
				
				 if (pSceneTouchEvent.isActionDown()){
					 currentFireCommand = FireCommand.fire;
				 } else if (pSceneTouchEvent.isActionUp()){
					 currentFireCommand = FireCommand.nothing;
				 }

				return true;
			}
		});
		fireSprite.setPosition(GameConfiguration.getInstance().CAMERA_WIDTH - fireSprite.getWidth(),
				(GameConfiguration.getInstance().CAMERA_HEIGHT - dpadSprite.getHeight()) /2);
	}
	

	public void addToScene(Scene scene) {
		scene.registerTouchArea(dpadSprite);
		scene.registerTouchArea(fireSprite);
		scene.attachChild(dpadSprite);
		scene.attachChild(fireSprite);		
	}

	@Override
	public void touchUp() {
		currentMoveCommand = MoveCommand.up;
	}

	@Override
	public void touchDown() {
		currentMoveCommand = MoveCommand.down;
	}

	@Override
	public void touchLeft() {
		currentMoveCommand = MoveCommand.left;
	}

	@Override
	public void touchRight() {
		currentMoveCommand = MoveCommand.right;
	}

	@Override
	public void noTouch() {
		currentMoveCommand = MoveCommand.nothing;
	}
	
}



