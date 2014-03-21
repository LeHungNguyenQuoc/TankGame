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
	
	public Font fontBig;
	public Font fontSmall;
	
	
	public GameConfiguration() {
		this.configCamera();
	}
	
	private void configCamera() {
		CAMERA_WIDTH = 800f;
		CAMERA_HEIGHT = 480f;
		screenOrientation = ScreenOrientation.LANDSCAPE_FIXED;
		screenRatio = new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT);
	}
	
	
	private void configFontGame(BaseGameActivity activity) {
		fontBig =  FontFactory.create(activity.getFontManager(),
				activity.getTextureManager(), 256, 256,
				Typeface.create(Typeface.DEFAULT, Typeface.BOLD), 32);
		
		fontSmall =  FontFactory.create(activity.getFontManager(),
				activity.getTextureManager(), 256, 256,
				Typeface.create(Typeface.DEFAULT, Typeface.BOLD), 20);
		
		fontSmall.load();
		fontBig.load();
	}
	
	public void loadGameResource(BaseGameActivity activity) {
		this.configFontGame(activity);
	}
	
}
