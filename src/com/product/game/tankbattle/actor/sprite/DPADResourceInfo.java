package com.product.game.tankbattle.actor.sprite;

import com.product.game.tankbattle.config.GameResource;
import com.product.game.tankbattle.controller.DPadSprite;

public class DPADResourceInfo extends BaseSpriteResourceInfo{

	@Override
	public int getFrameNumbers() {
		return 1;
	}

	@Override
	public String getGFXResourcePath() {
		return "gfx/dpad_test.png";
	}

	@Override
	public int getFrameWidth() {
		return 150;
	}

	@Override
	public int getFrameHeight() {
		return 150;
	}

	
	@Override
	public DPadSprite makeAnimateSprite() {
		return new DPadSprite(0, 0, mTiledTextureRegion, GameResource.getInstance().vertexBufferObjectManager);
	}

	@Override
	public float getRotateLeftAngle() {
		return 0;
	}

	@Override
	public float getRotateRightAngle() {
		return 0;
	}

	@Override
	public float getRotateUpAngle() {
		return 0;
	}

	@Override
	public float getRotateDownAngle() {
		return 0;
	}
}
