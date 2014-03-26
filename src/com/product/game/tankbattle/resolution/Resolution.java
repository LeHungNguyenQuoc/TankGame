package com.product.game.tankbattle.resolution;


public interface Resolution {
	public final static int SCREEN_WIDTH = 800;
	public final static int SCREEN_HEIGHT = 480;
	
	
	//GAME TILESET
	public static final int TILESET_SIZE = SCREEN_HEIGHT / 15;
	
	//TANK
	public final static int TANK_W = TILESET_SIZE;
	public final static int TANK_H = TILESET_SIZE;
	public final static int TANK_USER_STEP_DISTANCE = TILESET_SIZE/10;
	public final static int TANK_ENEMY_STEP_DISTANCE = TILESET_SIZE;
	
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
	public final static int DPAD_W = SCREEN_HEIGHT/4;
	public final static int DPAD_H = SCREEN_HEIGHT/4;
	public final static int DPAD_OFF = DPAD_W/10;
	
	public final static int FIRE_BUTTON_W = SCREEN_HEIGHT/5;
	public final static int FIRE_BUTTON_H = SCREEN_HEIGHT/5;

}
