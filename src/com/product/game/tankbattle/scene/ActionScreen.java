package com.product.game.tankbattle.scene;

import org.andengine.entity.scene.background.Background;
import org.andengine.ui.activity.BaseGameActivity;
import org.andengine.util.color.Color;

import com.product.game.tankbattle.actor.entity.tank.TankActor;
import com.product.game.tankbattle.actor.entity.tank.UserTank;
import com.product.game.tankbattle.actor.factory.UserTankFactory;
import com.product.game.tankbattle.actor.setting.UserTankSetting;
import com.product.game.tankbattle.controller.GameController;

public class ActionScreen extends TBBaseScreen{

	GameController mGameController;
	
	public ActionScreen() {
		this.setBackground(new Background(Color.BLACK));
		
		this.initUserTanks();
		this.initGameController();
	}
	
	private void initUserTanks() {
		TankActor userTank = UserTankFactory.getInstance().makeCompleteTank(new UserTankSetting());
		userTank.addToScene(this);
		userTank.setPosition(100, 100);
	}
	
	
	private void initGameController() {
		mGameController = new GameController();
		mGameController.addToScene(this);
	}

}
