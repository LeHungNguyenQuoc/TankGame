package com.product.game.tankbattle;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import com.product.game.tankbattle.config.GameConfiguration;
import com.product.game.tankbattle.config.GameResource;
import com.product.game.tankbattle.scene.ActionScreen;

public class BaseActivity  extends SimpleBaseGameActivity{
	
	public Camera mCamera;
	
	public Scene mCurrentScene; 
	public static BaseActivity instance;
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		instance = this;
		mCamera = new Camera(0, 0, 
				GameConfiguration.getInstance().CAMERA_WIDTH, 
				GameConfiguration.getInstance().CAMERA_HEIGHT);
		
		return new EngineOptions(true, 
				GameConfiguration.getInstance().screenOrientation, 
				GameConfiguration.getInstance().screenRatio, 
				mCamera);
	}

	@Override
	protected void onCreateResources() {
		GameResource.getInstance().loadGameResource(this);
	}

	@Override
	protected Scene onCreateScene() {
		return new ActionScreen(this);
	}

}
