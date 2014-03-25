package com.product.game.tankbattle.config;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;

import com.product.game.tankbattle.resolution.Resolution;

public class GameConfiguration {
	private static GameConfiguration instance;
	
	public static GameConfiguration getInstance() {
		if (instance == null) {
			instance = new GameConfiguration();
		}
		return instance;
	}

	public ScreenOrientation screenOrientation;
	public RatioResolutionPolicy screenRatio;
	public Camera camera;	
	
	public GameConfiguration() {
		this.configCamera();
	}
	
	private void configCamera() {
		camera = new Camera(0, 0, Resolution.SCREEN_WIDTH, Resolution.SCREEN_HEIGHT);
		screenOrientation = ScreenOrientation.LANDSCAPE_FIXED;
		screenRatio = new RatioResolutionPolicy(Resolution.SCREEN_WIDTH, Resolution.SCREEN_HEIGHT);
	}
	
}
