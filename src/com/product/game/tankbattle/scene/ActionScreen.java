package com.product.game.tankbattle.scene;

import org.andengine.entity.scene.background.Background;
import org.andengine.ui.activity.BaseGameActivity;
import org.andengine.util.color.Color;

import com.product.game.tankbattle.actor.entity.tank.TankActor;
import com.product.game.tankbattle.actor.entity.tank.UserTank;
import com.product.game.tankbattle.actor.factory.UserTankFactory;
import com.product.game.tankbattle.actor.setting.UserTankSetting;

public class ActionScreen extends TBBaseScreen{

	public ActionScreen() {
		this.setBackground(new Background(Color.BLACK));
		
		this.initUserTanks();
	}
	
	
	private void initUserTanks() {
		TankActor userTank = UserTankFactory.getInstance().makeCompleteTank(new UserTankSetting());
		userTank.addToScene(this);
		userTank.setPosition(100, 100);
	}

}
