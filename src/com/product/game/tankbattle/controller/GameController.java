package com.product.game.tankbattle.controller;

import org.andengine.entity.scene.Scene;

import android.util.Log;

import com.product.game.tankbattle.config.GameConfiguration;
import com.product.game.tankbattle.config.GameResource;
import com.product.game.tankbattle.controller.DPadSprite.IDPadSpriteListener;

public class GameController implements IDPadSpriteListener{
	
	public interface IGameControllerDelegate {
		public void doTouchUp();
		public void doTouchDown();
		public void doTouchLeft();
		public void doTouchRight();
		public void doTouchFire();
	}
	
	public enum MoveCommand {
		up, down, left, right, nothing,
	}
	
	public MoveCommand currentMoveCommand;
	public DPadSprite dpadSprite;
	
	private IGameControllerDelegate _delegate;

	
	public GameController() {
		currentMoveCommand = MoveCommand.nothing;
		dpadSprite = (DPadSprite) GameResource.getInstance().controller.dPad.makeAnimateSprite();
		dpadSprite.setPosition(0, (GameConfiguration.getInstance().CAMERA_HEIGHT - dpadSprite.getHeight()) /2);	
		dpadSprite.registerListener(this);
	}
	
	public void setDelegate(IGameControllerDelegate delegate) {
		this._delegate = delegate;
	}
	
	public void addToScene(Scene scene) {
		scene.registerTouchArea(dpadSprite);
		scene.attachChild(dpadSprite);
	}

	@Override
	public void touchUp() {
		currentMoveCommand = MoveCommand.up;
		if(_delegate != null) 
			_delegate.doTouchUp();
	}

	@Override
	public void touchDown() {
		currentMoveCommand = MoveCommand.down;
		if(_delegate != null) 
			_delegate.doTouchDown();
	}

	@Override
	public void touchLeft() {
		currentMoveCommand = MoveCommand.left;
		if(_delegate != null) 
			_delegate.doTouchLeft();
	}

	@Override
	public void touchRight() {
		currentMoveCommand = MoveCommand.right;
		if(_delegate != null) 
			_delegate.doTouchRight();
	}

	@Override
	public void noTouch() {
		currentMoveCommand = MoveCommand.nothing;
	}
	
}



