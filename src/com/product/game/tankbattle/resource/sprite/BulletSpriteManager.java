package com.product.game.tankbattle.resource.sprite;

public class BulletSpriteManager extends BaseSpriteManager{

	@Override
	public int getFrameNumbers() {
		return 1;
	}

	@Override
	public String getGFXResourcePath() {
		return "bullet_sprite.png";
	}

	@Override
	public int getFrameWidth() {
		return 20;
	}

	@Override
	public int getFrameHeight() {
		return 20;
	}

	@Override
	public float getRotateLeftAngle() {
		return 180f;
	}

	@Override
	public float getRotateRightAngle() {
		return 0f;
	}

	@Override
	public float getRotateUpAngle() {
		return -90f;
	}

	@Override
	public float getRotateDownAngle() {
		return 90f;
	}

}
