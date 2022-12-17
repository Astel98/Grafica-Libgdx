package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.actores.Enemigo;
import com.mygdx.game.actores.Nave;
import com.mygdx.game.actores.enums.TipoEnemigo;
import com.mygdx.game.helpers.Colisionador;
import com.mygdx.game.helpers.Observador;

import java.util.LinkedList;

public class JuegoDos implements Screen {

    final MyGdxGame juego;
    private Batch batch;
    OrthographicCamera camara;

    public JuegoDos(final MyGdxGame juego){
        this.juego = juego;
        batch = new SpriteBatch();
        camara = new OrthographicCamera();
        camara.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        juego.stage = new Stage(new ScreenViewport());
        juego.colisionador = new Colisionador(juego);
        juego.observador = new Observador(juego);

        juego.nave = new Nave("invaders-64px.png", 20f,30f, juego.colisionador);
        juego.prolist = new LinkedList<>();
        juego.enelist = new LinkedList<>();
        juego.stage.addActor(juego.nave);
        crearEnemigos();

        Gdx.input.setInputProcessor(juego.observador);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1,1,1, 1);
        camara.update();
        batch.setProjectionMatrix(camara.combined);
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        juego.stage.act(Gdx.graphics.getDeltaTime());
        juego.stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        juego.stage.getViewport().update(width,height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        juego.stage.dispose();
    }

    private void crearEnemigos(){
        for (int i = 0; i < 10; i++){
            if(i%3==0){
                juego.enelist.add(new Enemigo("invaders-64px.png", TipoEnemigo.NORMAL, 10+i*64, 200, juego.colisionador));
            }else{
                juego.enelist.add(new Enemigo("invaders-64px.png", TipoEnemigo.DIFICIL, 10+i*64, 280, juego.colisionador));
            }
        }

        for (Enemigo e: juego.enelist) {
            juego.stage.addActor(e);
        }
    }
}
