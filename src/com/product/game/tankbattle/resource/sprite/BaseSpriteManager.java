package com.product.game.tankbattle.resource.sprite;

import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.ui.activity.BaseGameActivity;

import com.product.game.tankbattle.resource.GameResource;

public abstract class BaseSpriteManager {
	protected BuildableBitmapTextureAtlas mBitmapTextureAtlas;
	protected TiledTextureRegion mTiledTextureRegion;
	
	public interface ITouchOnSprite {
		public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY);
	}
	
	public abstract int getFrameNumbers();
	public abstract String getGFXResourcePath();
	public abstract int getFrameWidth();
	public abstract int getFrameHeight();
	public abstract float getRotateLeftAngle();
	public abstract float getRotateRightAngle();
	public abstract float getRotateUpAngle();
	public abstract float getRotateDownAngle();
	
	
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
	
	public AnimatedSprite makeAnimateSprite(final ITouchOnSprite touchEvent) {
		if (mTiledTextureRegion == null) {
			this.loadBitmapTextureAtlas(GameResource.getInstance().activity);
		}
		return new AnimatedSprite(0, 0, mTiledTextureRegion, GameResource.getInstance().vertexBufferObjectManager) {
			@Override
			public boolean onAreaTouched(TouchEvent pSceneTouchEvent,
					float pTouchAreaLocalX, float pTouchAreaLocalY) {
				if (touchEvent != null) {
					return touchEvent.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
				}
				return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
			}
		};
	}
}
