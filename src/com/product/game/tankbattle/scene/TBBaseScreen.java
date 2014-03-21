package com.product.game.tankbattle.scene;

import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.BaseGameActivity;

public abstract class TBBaseScreen extends Scene{
	protected BaseGameActivity activity;
	
	public TBBaseScreen(BaseGameActivity activity) {
		this.activity = activity;
	}
	
}
