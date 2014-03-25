package com.product.game.tankbattle.scene;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.scene.background.Background;
import org.andengine.util.color.Color;

import com.product.game.tankbattle.actor.entity.bullet.BulletActor;
import com.product.game.tankbattle.actor.entity.tank.TankActor;
import com.product.game.tankbattle.actor.factory.BulletFactory;
import com.product.game.tankbattle.actor.factory.UserTankFactory;
import com.product.game.tankbattle.actor.setting.UserTankSetting;
import com.product.game.tankbattle.controller.GameController;
import com.product.game.tankbattle.controller.GameController.FireCommand;

public class ActionScreen extends TBBaseScreen{

	GameController mGameController;
	TankActor userTank;
	
	public ActionScreen() {
		this.setBackground(new Background(Color.BLACK));
		
		this.initUserTanks();
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
					BulletActor bulletActor = BulletFactory.getInstances().makeCompleteActor();
					bulletActor.addToScene(ActionScreen.this);
					bulletActor.setPosition(10, 10);
					bulletActor.stepDown();
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
		userTank = UserTankFactory.getInstance().makeCompleteTank(new UserTankSetting());
		userTank.addToScene(this);
		userTank.setPosition(100, 100);
	}
	
	
	private void initGameController() {
		mGameController = new GameController();
		mGameController.addToScene(this);
	}

}
