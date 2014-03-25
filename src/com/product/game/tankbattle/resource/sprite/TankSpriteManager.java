package com.product.game.tankbattle.resource.sprite;


public class TankSpriteManager extends BaseSpriteManager{
	
	final static int TANK_FRAME_PX_WIDTH = 60;
	final static int TANK_FRAME_PX_HEIGHT = 60;
	final static int MAX_FRAME = 6;
	final static String GFX_PATH_STRING  = "tank_sprite.png";
	
	@Override
	public int getFrameNumbers() {
		return MAX_FRAME;
	}
	@Override
	public String getGFXResourcePath() {
		return GFX_PATH_STRING;
	}
	@Override
	public int getFrameWidth() {
		return TANK_FRAME_PX_WIDTH;
	}
	@Override
	public int getFrameHeight() {
		return TANK_FRAME_PX_HEIGHT;
	}
	@Override
	public float getRotateLeftAngle() {
		return -90f;
	}
	@Override
	public float getRotateRightAngle() {
		return 90f;
	}
	@Override
	public float getRotateUpAngle() {
		return 0f;
	}
	@Override
	public float getRotateDownAngle() {
		return 180f;
	}
}
