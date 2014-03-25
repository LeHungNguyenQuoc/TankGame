package com.product.game.tankbattle.resolution;


public interface Resolution {
	public final static int SCREEN_WIDTH = 800;
	public final static int SCREEN_HEIGHT = 480;
	
	
	//GAME TILESET
	public static final int TILESET_SIZE = SCREEN_HEIGHT / 20;
	
	//TANK
	public final static int TANK_W = TILESET_SIZE;
	public final static int TANK_H = TILESET_SIZE;
	public final static int TANK_STEP_DISTANCE = TILESET_SIZE/10;
	
	//BRICK 
	public final static int BRICK_W = TILESET_SIZE;
	public final static int BRICK_H = TILESET_SIZE;
	
	
	//BULLET
	public final static int BULLET_W = TILESET_SIZE/3;
	public final static int BULLET_H = TILESET_SIZE/3;
	
	
	//MAP
	public final static int BATTLE_H = SCREEN_HEIGHT;
	public final static int BATTLE_W = BATTLE_H;
	
	
	//DPAD
	public final static int DPAD_W = 150;
	public final static int DPAD_H = 150;
	public final static int DPAD_OFF = 10;
	
	public final static int FIRE_BUTTON_W = 100;
	public final static int FIRE_BUTTON_H = 100;

}
