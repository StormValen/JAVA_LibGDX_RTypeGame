package com.rtype.game;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Valen on 29/12/2017.
 */

public class EnemyExamen extends Enemy {
    private int direction;
    EnemyExamen(Texture img, float _velocityX, float _velocityY, float xPosition, float yPosition){
        super(img);
        this.velocityX = _velocityX;
        this.velocityY = _velocityY;
        this.SpriteImg.setScale(-0.4f,0.4f);
        this.setX(xPosition);
        this.setY(yPosition);
        this.direction = 1;
        this.SpriteImg.setPosition(this.getX(),this.getY());
    }

    @Override
    public void act(float delta){
        this.SpriteImg.setPosition(this.getX(),this.getY());
        if(getX() > 100){
            this.setX(getX()-this.velocityX*delta);
        }else if(this.getX() < 100){
            if(this.getY() > 350 && direction == 1){
                direction = -1;
            } else if(this.getY() < -50 && direction == -1){
                direction = 1;
            }

            switch (direction){
                case 1:
                    this.setY(getY()+this.velocityY*delta);
                    break;
                case -1:
                    this.setY(getY()-this.velocityY*delta);
                    break;
                default:
                    break;
            }
        }


    }
}
