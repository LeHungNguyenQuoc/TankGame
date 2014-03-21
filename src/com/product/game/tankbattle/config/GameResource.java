package com.product.game.tankbattle.config;

import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.ui.activity.BaseGameActivity;

import android.graphics.Typeface;

public class GameResource {
	
	private static GameResource instance;
	public Font fontBig;
	public Font fontSmall;
	
	
	public static GameResource getInstance() {
		if (instance == null) {
			instance = new GameResource();
		}
		return instance;
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
	
	
	private void configBitmapAlias(BaseGameActivity activity) {
		
	}
	
	public void loadGameResource(BaseGameActivity activity) {
		this.configFontGame(activity);
		this.configBitmapAlias(activity);
	}
}
