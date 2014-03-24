package com.product.game.tankbattle.scene;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.scene.background.Background;
import org.andengine.ui.activity.BaseGameActivity;
import org.andengine.util.color.Color;

import android.util.Log;

import com.product.game.tankbattle.actor.entity.tank.TankActor;
import com.product.game.tankbattle.actor.entity.tank.UserTank;
import com.product.game.tankbattle.actor.factory.UserTankFactory;
import com.product.game.tankbattle.actor.setting.UserTankSetting;
import com.product.game.tankbattle.controller.GameController;
import com.product.game.tankbattle.controller.GameController.IGameControllerDelegate;

public class ActionScreen extends TBBaseScreen implements IGameControllerDelegate{

	GameController mGameController;
	TankActor userTank;
	
	public ActionScreen() {
		this.setBackground(new Background(Color.BLACK));
		
		this.initUserTanks();
		this.initGameController();
		this.addGameUpdateListener();
	}
	
	private void addGameUpdateListener() {
		this.registerUpdateHandler(new IUpdateHandler() {
			
			@Override
			public void reset() {
			}
			
			@Override
			public void onUpdate(float pSecondsElapsed) {
			}
		});
	}
		
	private void initUserTanks() {
		userTank = UserTankFactory.getInstance().makeCompleteTank(new UserTankSetting());
		userTank.addToScene(this);
		userTank.setPosition(100, 100);
	}
	
	
	private void initGameController() {
		mGameController = new GameController();
		mGameController.addToScene(this);
		mGameController.setDelegate(this);
	}

	@Override
	public void doTouchUp() {
		userTank.stepUp();
	}

	@Override
	public void doTouchDown() {
		userTank.stepDown();
	}

	@Override
	public void doTouchLeft() {
		userTank.stepLeft();
	}

	@Override
	public void doTouchRight() {
		userTank.stepRight();
	}

	@Override
	public void doTouchFire() {
		
	}

}
