package com.rtype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import static com.badlogic.gdx.Input.Keys.DOWN;
import static com.badlogic.gdx.Input.Keys.UP;
import static com.badlogic.gdx.Input.Keys.LEFT;
import static com.badlogic.gdx.Input.Keys.RIGHT;

/**
 * Created by Valen on 28/12/2017.
 */

public class Player extends GameObject {
    Texture bulletImg;
    int shootCounter;

    Player(Texture img,Texture shootImg){
        super(img);
        bulletImg = shootImg;
        shootCounter = 0;
        this.SpriteImg.setScale(0.4f);
        this.setX(-70);
    }

    @Override
    public void act(float delta){
        this.SpriteImg.setPosition(this.getX(),this.getY());
        shootCounter++;
    }

    public void GoUp(float delta){
        this.setY(getY()+200*delta);
    }

    public void GoDown(float delta){
        this.setY(getY()-200*delta);
    }

    public void GoLeft(float delta){
        this.setX(getX()-200*delta);
    }

    public void GoRight(float delta){
        this.setX(getX()+200*delta);
    }

    public void Kill(float delta){
        System.exit(0);
    }

    public Bullet Shoot(float delta){
        return new Bullet(bulletImg,500,this.SpriteImg.getX()+this.SpriteImg.getWidth()/2,this.SpriteImg.getY()+this.SpriteImg.getHeight()/2-20);
    }
}
