package com.product.game.tankbattle.actor;

public class TBActorHelper {
	public static float getDurationSecond(float pFrom, float pTo, float speed) {
		return Math.abs(pFrom - pTo) / speed;
	}
	
}
