package com.product.game.tankbattle.actor.entity.tank;

import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.ui.activity.BaseGameActivity;


public class TankResourcesInfo {
	
	final static int TANK_FRAME_PX_WIDTH = 60;
	final static int TANK_FRAME_PX_HEIGHT = 60;
	final static int MAX_SPRITE_ID = 6;
	final static String GFX_PATH_STRING  = "gfx/tank_sprite.png";
	
	private BuildableBitmapTextureAtlas mBitmapTextureAtlas;
	public TiledTextureRegion mTiledTextureRegion;
	
	public void loadBitmapTextureAtlas(BaseGameActivity activity) {
		mBitmapTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 
				TANK_FRAME_PX_WIDTH + 10, TANK_FRAME_PX_HEIGHT* MAX_SPRITE_ID + 10 , TextureOptions.NEAREST);
		mTiledTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(mBitmapTextureAtlas, activity, GFX_PATH_STRING, 1 , MAX_SPRITE_ID);
		try {
			mBitmapTextureAtlas
			.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
					0, 0, 1));
			mBitmapTextureAtlas.load();
		} catch (Exception e) {
		}
		
	}
	
}
