package com.product.game.tankbattle.scene;

import java.util.ArrayList;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.scene.background.Background;
import org.andengine.util.color.Color;

import com.product.game.tankbattle.actor.entity.bullet.BulletActor;
import com.product.game.tankbattle.actor.entity.tank.EnermyTank;
import com.product.game.tankbattle.actor.entity.tank.TankActor;
import com.product.game.tankbattle.actor.factory.BulletFactory;
import com.product.game.tankbattle.actor.factory.EnermyTankFactory;
import com.product.game.tankbattle.actor.factory.UserTankFactory;
import com.product.game.tankbattle.actor.setting.UserTankSetting;
import com.product.game.tankbattle.controller.GameController;
import com.product.game.tankbattle.controller.GameController.FireCommand;

public class ActionScreen extends TBBaseScreen{

	GameController mGameController;
	TankActor userTank;
	ArrayList<EnermyTank> arrEnermyTanks;
	
	public ActionScreen() {
		this.setBackground(new Background(Color.BLACK));
		
		this.initUserTanks();
		this.initEnermyTanks();
		this.initGameController();
		this.addGameUpdateListener();
	}
	
	private void addGameUpdateListener() {
		this.setTouchAreaBindingOnActionDownEnabled(true);
		this.registerUpdateHandler(new IUpdateHandler() {
			
			@Override
			public void reset() {
			}
			
			@Override
			public void onUpdate(float pSecondsElapsed) {
				
				if (mGameController.currentFireCommand == FireCommand.fire) {
					userTank.fireBullet();
				}
				switch (mGameController.currentMoveCommand) {
				case down:
					userTank.stepDown();
					break;
				case up:
					userTank.stepUp();
					break;
				case left:
					userTank.stepLeft();
					break;
				case right:
					userTank.stepRight();
					break;
				default:
					break;
				}

			}
		});
	}
	
		
	private void initUserTanks() {
		userTank = UserTankFactory.getInstance().makeCompleteActor();
		userTank.addToScene(this);
		userTank.setPosition(100, 100);
	}
	
	
	private void initEnermyTanks() {
		arrEnermyTanks = new ArrayList<EnermyTank>();
		for (int i = 0; i < 10; i++) {
			EnermyTank tank = EnermyTankFactory.getInstance().makeCompleteActor();
			tank.addToScene(this);
			arrEnermyTanks.add(tank);
			
			tank.setPosition(i* tank.getWidth() + 2, 0);
		}
	}
	
	
	private void initGameController() {
		mGameController = new GameController();
		mGameController.addToScene(this);
	}

}
