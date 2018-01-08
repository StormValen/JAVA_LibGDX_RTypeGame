package com.rtype.game;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Valen on 28/12/2017.
 */

public class EnemyStraight extends Enemy {

    EnemyStraight(Texture img, float velocity,float xPosition, float yPosition){
        super(img);
        this.velocityX = velocity;
        this.velocityY = 0;
        this.SpriteImg.setScale(-0.4f,0.4f);
        this.setX(xPosition);
        this.setY(yPosition);
        this.SpriteImg.setPosition(xPosition,yPosition);
    }

    @Override
    public void act(float delta){
        this.setX(getX()-this.velocityX*delta);
        this.SpriteImg.setPosition(this.getX(),this.getY());
    }
}
