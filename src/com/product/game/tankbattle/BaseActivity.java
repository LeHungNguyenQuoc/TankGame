package com.product.game.tankbattle;

import org.andengine.engine.options.EngineOptions;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import com.product.game.tankbattle.config.GameConfiguration;
import com.product.game.tankbattle.resource.GameResource;
import com.product.game.tankbattle.scene.ActionScreen;

public class BaseActivity  extends SimpleBaseGameActivity{
	
	public static BaseActivity instance;
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		instance = this;
		
		EngineOptions options =  new EngineOptions(true, 
				GameConfiguration.getInstance().screenOrientation, 
				GameConfiguration.getInstance().screenRatio, 
				GameConfiguration.getInstance().camera);
		options.getTouchOptions().setNeedsMultiTouch(true);
		
		return options;
	}

	@Override
	protected void onCreateResources() {
		GameResource.getInstance().loadGameResource(this);
	}

	@Override
	protected Scene onCreateScene() {
		return new ActionScreen();
	}

}
