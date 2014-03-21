package com.product.game.tankbattle.scene;

import org.andengine.entity.scene.background.Background;
import org.andengine.ui.activity.BaseGameActivity;
import org.andengine.util.color.Color;

public class ActionScreen extends TBBaseScreen{

	public ActionScreen(BaseGameActivity activity) {
		super(activity);
		
		this.setBackground(new Background(Color.BLACK));
	}

}
