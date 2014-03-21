package com.product.game.tankbattle.config;

import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.ui.activity.BaseGameActivity;

import android.graphics.Typeface;

public class GameConfiguration {
	private static GameConfiguration instance;
	
	public static GameConfiguration getInstance() {
		if (instance == null) {
			instance = new GameConfiguration();
		}
		return instance;
	}
	
	public float CAMERA_WIDTH;
	public float CAMERA_HEIGHT;
	public ScreenOrientation screenOrientation;
	public RatioResolutionPolicy screenRatio;
	
	
	public GameConfiguration() {
		this.configCamera();
	}
	
	private void configCamera() {
		CAMERA_WIDTH = 800f;
		CAMERA_HEIGHT = 480f;
		screenOrientation = ScreenOrientation.LANDSCAPE_FIXED;
		screenRatio = new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT);
	}
	
}
