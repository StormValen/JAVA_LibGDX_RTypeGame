package com.rtype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.SnapshotArray;

import java.util.Iterator;

/**
 * Created by Valen on 28/12/2017.
 */

public class EnemyManager extends Actor{
    private AssetsManager myAssetsManager;
    private int counter;
    Stage stage;
    public Group enemiesGroup;

    EnemyManager(AssetsManager assetsManager, Stage _stage){
        myAssetsManager = assetsManager;
        stage = _stage;
        counter = 0;
        enemiesGroup = new Group();
        stage.addActor(enemiesGroup);
    }

    public void act(float delta){
        if(counter >400){
            enemiesGroup.addActor(CreateEnemy(400,(float)Math.random()* Gdx.graphics.getHeight()));
            counter =0;
        }
        counter++;
    }

    public Enemy CreateEnemy(float x, float y){
        float randomIndex = (float)Math.random()*100;
        System.out.print(randomIndex);
        if(randomIndex<50){
            return new EnemyStraight(myAssetsManager.enemyStraight,100,x,y);
        }else if(randomIndex>=50){
            return new EnemyZigZag(myAssetsManager.enemyZigZag,100,50,x,y);
        }
        return null;
    }

    public void CheckColisions(Group bulletsGroup){
        SnapshotArray<Actor> bG = bulletsGroup.getChildren();
        SnapshotArray<Actor> eG = enemiesGroup.getChildren();

        for(Iterator<Actor> I = bG.iterator(); I.hasNext();) {
            Bullet b = (Bullet)I.next();
            if (b.CheckOutOfMap()) {
                bulletsGroup.removeActor(b);
            }
            for(Iterator<Actor> J = eG.iterator(); J.hasNext();) {
                Enemy e = (Enemy) J.next();
                if(e.getX()+e.SpriteImg.getWidth()/6 < b.getX()){
                    if(b.getY() < e.getY()+e.SpriteImg.getHeight() && b.getY() > e.getY()){
                        bulletsGroup.removeActor(b);
                        enemiesGroup.removeActor(e);
                    }
                }
            }

        }
    }
}
