package com.product.game.tankbattle.resource;

import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.BaseGameActivity;

import android.graphics.Color;
import android.graphics.Typeface;

import com.product.game.tankbattle.resource.sprite.ControllerSpriteManager;
import com.product.game.tankbattle.resource.sprite.TankSpriteManager;

public class GameResource {
	
	private static GameResource instance;
	public Font fontBig;
	public Font fontSmall;
	public ControllerSpriteManager controller;
	public BaseGameActivity activity;
	public VertexBufferObjectManager vertexBufferObjectManager;
	
	public TankSpriteManager tankResources;
	
	
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
		tankResources = new TankSpriteManager();
		tankResources.loadBitmapTextureAtlas(activity);
		
		controller = new ControllerSpriteManager();
		controller.dPad.loadBitmapTextureAtlas(activity);
	}
	
	
	public void loadGameResource(BaseGameActivity activity) {
		this.activity = activity;
		this.vertexBufferObjectManager = activity.getVertexBufferObjectManager();
		this.configFontGame(activity);
		this.configBitmapAlias(activity);
	}
}
