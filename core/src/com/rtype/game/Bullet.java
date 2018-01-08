package com.rtype.game;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Valen on 28/12/2017.
 */

public class Bullet extends GameObject {
    private float velocity;
    private boolean isAlive;
    Bullet(Texture img, float v, float xPosition, float yPosition){
        super(img);
        velocity = v;
        this.setX(xPosition);
        this.setY(yPosition);
        this.SpriteImg.setPosition(xPosition,yPosition);
        this.isAlive = true;
    }

    @Override
    public void act(float delta){
        if(isAlive){
            this.setX(getX()+velocity*delta);
            this.SpriteImg.setPosition(this.getX(),this.getY());
        }
    }

    public boolean CheckOutOfMap(){
        if(this.getX() < 500){return false;}
        else{return true;}
    }
}
