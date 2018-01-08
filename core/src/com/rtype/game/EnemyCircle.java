package com.rtype.game;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Valen on 29/12/2017.
 */

public class EnemyCircle extends Enemy {
    EnemyCircle(Texture img, float _velocityX, float _velocityY, float xPosition, float yPosition){
        super(img);
        this.velocityX = _velocityX;
        this.velocityY = _velocityY;
        this.SpriteImg.setScale(-0.4f,0.4f);
        this.setX(xPosition);
        this.setY(yPosition);
    }

    @Override
    public void act(float delta){
        this.setX(getX()-this.velocityX*delta);
        this.SpriteImg.setPosition(this.getX(),this.getY());
    }
}
