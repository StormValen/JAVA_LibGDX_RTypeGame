package com.rtype.game;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Valen on 28/12/2017.
 */

public abstract class Enemy extends GameObject {

    protected float velocityX, velocityY;

    Enemy(Texture img){
        super(img);
        SpriteImg.setScale(0.3f);
    }
}
