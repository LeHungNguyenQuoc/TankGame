package com.product.game.tankbattle.actor.map;

import org.andengine.entity.scene.Scene;

import com.product.game.tankbattle.config.GameConfiguration;
import com.product.game.tankbattle.resolution.Resolution;

import android.graphics.Rect;

public class BattleMap {
	public Rect rectMap;
	public Scene mScene;
	public BattleMap(Scene scene) {
		mScene = scene;
		rectMap = new Rect(0, 0, Resolution.SCREEN_WIDTH, Resolution.SCREEN_HEIGHT);
	}
}
