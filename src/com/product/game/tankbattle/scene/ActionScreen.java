package com.product.game.tankbattle.scene;

import java.util.ArrayList;
import java.util.Random;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.background.Background;
import org.andengine.util.color.Color;

import com.product.game.tankbattle.actor.entity.bullet.BulletActor;
import com.product.game.tankbattle.actor.entity.tank.EnermyTank;
import com.product.game.tankbattle.actor.entity.tank.TankActor;
import com.product.game.tankbattle.actor.factory.BulletFactory;
import com.product.game.tankbattle.actor.factory.EnermyTankFactory;
import com.product.game.tankbattle.actor.factory.UserTankFactory;
import com.product.game.tankbattle.actor.map.BattleMap;
import com.product.game.tankbattle.actor.setting.UserTankSetting;
import com.product.game.tankbattle.controller.GameController;
import com.product.game.tankbattle.controller.GameController.FireCommand;

public class ActionScreen extends TBBaseScreen{

	GameController mGameController;
	TankActor userTank;
	ArrayList<EnermyTank> arrEnermyTanks;
	BattleMap mBattleMap;
	
	public ActionScreen() {
		this.setBackground(new Background(Color.PINK));
		this.initBattleMap();
		this.initUserTanks();
		this.initEnermyTanks();
		this.initGameController();
		this.addGameUpdateListener();
	}
	
	
	/**
	 **********************************************************************************************************
	 * Game update loop
	 **********************************************************************************************************
	 */
	
	private void addGameUpdateListener() {
		this.setTouchAreaBindingOnActionDownEnabled(true);
		this.registerUpdateHandler(new IUpdateHandler() {
			
			@Override
			public void reset() {
			}
			
			@Override
			public void onUpdate(float pSecondsElapsed) {
				handleUpdateController();
				handleUpdateEnermy();
			}
		});
	}
	
	/**
	 **********************************************************************************************************
	 * Enemy Update
	 **********************************************************************************************************
	 */
	private void handleUpdateEnermy() {
		Random random = new Random();
		
		for (EnermyTank tank : arrEnermyTanks) {
			if (random.nextInt(10) == 1) {
				switch (random.nextInt(4)) {
				case 0:
					tank.stepUp();
					break;
				case 1:
					tank.stepDown();
					break;
				case 2:
					tank.stepLeft();
					break;
				case 3:
					tank.stepRight();
					break;

				default:
					break;
				}
			}
		}

	}
	
	/**
	 **********************************************************************************************************
	 * Controller update
	 **********************************************************************************************************
	 */
	
	private void handleUpdateController() {
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
	
	/**
	 **********************************************************************************************************
	 * Initial objects
	 **********************************************************************************************************
	 */
	
	private void initBattleMap() {
		mBattleMap = new BattleMap(this);		
	}
	
	private void initUserTanks() {
		userTank = UserTankFactory.getInstance().makeCompleteActor();
		mBattleMap.addActor(userTank, mBattleMap.numTileX - 1, mBattleMap.numTileY -1);
	}
	
	
	private void initEnermyTanks() {
		arrEnermyTanks = new ArrayList<EnermyTank>();
		for (int i = 0; i < 10; i++) {
			EnermyTank tank = EnermyTankFactory.getInstance().makeCompleteActor();
			arrEnermyTanks.add(tank);
			mBattleMap.addActor(tank, i, 0);
		}
	}
	
	
	private void initGameController() {
		mGameController = new GameController();
		mGameController.addToScene(this);
	}

}
