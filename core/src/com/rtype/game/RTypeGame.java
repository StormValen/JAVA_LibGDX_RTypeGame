package com.rtype.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.SnapshotArray;

import java.util.Iterator;

import static com.badlogic.gdx.Input.Keys.CONTROL_LEFT;
import static com.badlogic.gdx.Input.Keys.UP;

public class RTypeGame extends Game {

	private Stage stage;
	private EnemyManager myEnemyManager;
	private InputProcessor myInputProcessor;
	private AssetsManager myAssetsManager;
	private Player myPlayer;
	private GameObject Background;


	private Group bulletsGroup;

	@Override
	public void create () {
		stage = new Stage();
		bulletsGroup = new Group();
		stage.addActor(bulletsGroup);

		myAssetsManager = new AssetsManager();

		Background = new GameObject(myAssetsManager.background);
		stage.addActor(Background);

		myPlayer = new Player(myAssetsManager.player,myAssetsManager.bullet);
		stage.addActor(myPlayer);


		myEnemyManager = new EnemyManager(myAssetsManager, stage);
		myInputProcessor = new InputProcessor(myPlayer,stage);

		stage.addActor(myEnemyManager);
		stage.addActor(myInputProcessor);
	}

	@Override
	public void render () {
		myEnemyManager.CheckColisions(myInputProcessor.getBulletsGroup());
		super.render();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
	}
	
	@Override
	public void dispose () {
		super.dispose();
		stage.dispose();
	}
}
