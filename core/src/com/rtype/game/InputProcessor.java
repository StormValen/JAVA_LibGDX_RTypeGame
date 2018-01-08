package com.rtype.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.SnapshotArray;

import java.util.Iterator;

import static com.badlogic.gdx.Input.Keys.DOWN;
import static com.badlogic.gdx.Input.Keys.ESCAPE;
import static com.badlogic.gdx.Input.Keys.K;
import static com.badlogic.gdx.Input.Keys.LEFT;
import static com.badlogic.gdx.Input.Keys.RIGHT;
import static com.badlogic.gdx.Input.Keys.UP;
import static com.badlogic.gdx.Input.Keys.Z;

/**
 * Created by Valen on 28/12/2017.
 */

public class InputProcessor extends Actor {
    Player myPlayer;
    Stage stage;
    private Group bulletsGroup;

    InputProcessor(Player player, Stage _stage){
        myPlayer = player;
        stage = _stage;
        bulletsGroup = new Group();
        stage.addActor(bulletsGroup);
    }

    public void act(float delta){
        if(Gdx.input.isKeyPressed(DOWN)){
            myPlayer.GoDown(delta);
        }

        if(Gdx.input.isKeyPressed(UP)){
            myPlayer.GoUp(delta);
        }

        if(Gdx.input.isKeyPressed(LEFT)){
            myPlayer.GoLeft(delta);
        }

        if(Gdx.input.isKeyPressed(RIGHT)){
            myPlayer.GoRight(delta);
        }

        if(Gdx.input.isKeyPressed(Z)){
            if(myPlayer.shootCounter>10) {
                bulletsGroup.addActor(myPlayer.Shoot(delta));
                myPlayer.shootCounter = 0;
            }
        }

        if(Gdx.input.isKeyPressed(ESCAPE)){
            stage.dispose();
        }


    }

    public Group getBulletsGroup(){
        return bulletsGroup;
    }
}
