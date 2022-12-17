package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.actores.Enemigo;
import com.mygdx.game.actores.Nave;
import com.mygdx.game.actores.Proyectil;
import com.mygdx.game.actores.enums.TipoEnemigo;
import com.mygdx.game.helpers.Colisionador;
import com.mygdx.game.helpers.Observador;
import com.mygdx.game.screens.Juego;
import com.mygdx.game.screens.JuegoDos;
import com.mygdx.game.screens.Titulo;

import java.util.HashMap;
import java.util.LinkedList;

public class MyGdxGame extends Game {
	public Stage stage;
	public Nave nave;
	public float x, y;
	public Observador observador;
	public LinkedList<Proyectil> prolist;
	public LinkedList<Enemigo> enelist;
	public Colisionador colisionador;
	public Juego pantalla1;
	public JuegoDos pantalla2;

	@Override
	public void create () {


		this.setScreen(new Titulo(this));

	}

	@Override
	public void render () {
		super.render();

	}
	
	@Override
	public void dispose () {
		super.dispose();

	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);

	}

	private void crearEnemigos(){
		for (int i = 0; i < 10; i++){
			if(i%2==1){
				enelist.add(new Enemigo("invaders-64px.png", TipoEnemigo.NORMAL, 10+i*64, 200, colisionador));
			}else{
				enelist.add(new Enemigo("invaders-64px.png", TipoEnemigo.DIFICIL, 10+i*64, 280, colisionador));
			}
		}

		for (Enemigo e: enelist) {
			//e.setColisionador(colisionador);
			stage.addActor(e);
		}
	}

	public void nextStage(){
		this.setScreen(new JuegoDos(this));
	}
}
