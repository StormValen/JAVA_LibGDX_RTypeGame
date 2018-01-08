package com.rtype.game;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Valen on 29/12/2017.
 */

public class EnemyZigZag extends Enemy {
    private int direction, directionCounter;
    EnemyZigZag(Texture img, float _velocityX, float _velocityY, float xPosition, float yPosition){
        super(img);
        this.velocityX = _velocityX;
        this.velocityY = _velocityY;
        this.SpriteImg.setScale(-0.4f,0.4f);
        this.setX(xPosition);
        this.setY(yPosition);
        direction = 1;
        directionCounter = 0;
        this.SpriteImg.setPosition(xPosition,yPosition);
    }

    @Override
    public void act(float delta){
        switch (direction){
            case -1:
                this.setY(getY()-this.velocityY*delta);
                break;
            case 1:
                this.setY(getY()+this.velocityY*delta);
                break;
            default:
                break;
        }
        this.setX(getX()-this.velocityX*delta);
        this.SpriteImg.setPosition(this.getX(),this.getY());
        ChangeDirection();
        directionCounter++;
    }

    public void ChangeDirection(){
        if(directionCounter >100){
            if(direction==1){
                direction=-1;
                directionCounter = 0;
            }else if(direction==-1){
                direction=1;
                directionCounter = 0;
            }
        }
    }
}
