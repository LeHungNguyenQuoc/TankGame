package com.product.game.tankbattle.resolution;


public interface Resolution {
	public final static int SCREEN_WIDTH = 800;
	public final static int SCREEN_HEIGHT = 480;
	
	
	//GAME TILESET
	public static final int TILESET_SIZE = SCREEN_HEIGHT / 15;
	
	//TANK
	public final static int TANK_W = TILESET_SIZE;
	public final static int TANK_H = TILESET_SIZE;
	public final static int TANK_USER_STEP_DISTANCE = TILESET_SIZE/2;
	public final static int TANK_USER_SPEED = TILESET_SIZE*6;
	
	public final static int TANK_ENEMY_STEP_DISTANCE = TILESET_SIZE/2;
	public final static int TANK_ENEMY_SPEED = TILESET_SIZE*4;
	
	
	//BRICK 
	public final static int BRICK_W = TILESET_SIZE;
	public final static int BRICK_H = TILESET_SIZE;
	
	
	//BULLET
	public final static int BULLET_W = TILESET_SIZE/2;
	public final static int BULLET_H = TILESET_SIZE/2;
	public final static int BULLET_STEP = TILESET_SIZE;
	public final static int BULLET_MAX_WAY = SCREEN_WIDTH;
	
	
	//Explosion
	public final static int EXPLOSION_W = TILESET_SIZE* 2;
	public final static int EXPLOSION_H = TILESET_SIZE * 2;
	
	
	//MAP
	public final static int BATTLE_H = SCREEN_HEIGHT;
	public final static int BATTLE_W = BATTLE_H * 4/3;
	
	
	//DPAD
	public final static int DPAD_W = SCREEN_HEIGHT* 7/10;
	public final static int DPAD_H = SCREEN_HEIGHT* 7/10;
	public final static int DPAD_OFF = - DPAD_W/7;
	
	public final static int FIRE_BUTTON_W = SCREEN_HEIGHT/5;
	public final static int FIRE_BUTTON_H = SCREEN_HEIGHT/5;
	public final static int FIRE_BUTTON_OFF = FIRE_BUTTON_H/3;

}
