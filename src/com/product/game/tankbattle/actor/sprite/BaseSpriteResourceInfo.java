package com.product.game.tankbattle.actor.sprite;

import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.ui.activity.BaseGameActivity;

import com.product.game.tankbattle.config.GameResource;

public abstract class BaseSpriteResourceInfo {
	protected BuildableBitmapTextureAtlas mBitmapTextureAtlas;
	protected TiledTextureRegion mTiledTextureRegion;
	
	
	public abstract int getFrameNumbers();
	public abstract String getGFXResourcePath();
	public abstract int getFrameWidth();
	public abstract int getFrameHeight();
	
	public void loadBitmapTextureAtlas(BaseGameActivity activity) {
		mBitmapTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 
				getFrameWidth() + 10, getFrameHeight()* getFrameNumbers() + 10 , TextureOptions.NEAREST);
		mTiledTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(mBitmapTextureAtlas, activity, getGFXResourcePath(), 1 , getFrameNumbers());
		try {
			mBitmapTextureAtlas
			.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
					0, 0, 1));
			mBitmapTextureAtlas.load();
		} catch (Exception e) {
		}
	}
	
	public AnimatedSprite makeAnimateSprite() {
		if (mTiledTextureRegion == null) {
			this.loadBitmapTextureAtlas(GameResource.getInstance().activity);
		}
		return new AnimatedSprite(0, 0, mTiledTextureRegion, GameResource.getInstance().vertexBufferObjectManager);
	}
}
