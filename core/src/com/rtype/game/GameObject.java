package com.rtype.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Valen on 28/12/2017.
 */

public class GameObject extends Actor {
    protected Sprite SpriteImg;
    GameObject(Texture img) {
        SpriteImg = new Sprite(img);
    }
    public void draw(Batch batch, float parentAlpha) {
        SpriteImg.draw(batch);
    }
}
