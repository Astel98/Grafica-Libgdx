package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MyGdxGame;

public class Titulo implements Screen {

    final MyGdxGame juego;
    private Batch batch;
    private BitmapFont fuente;
    OrthographicCamera camara;

    public Titulo(final MyGdxGame juego){
        this.juego = juego;
        batch = new SpriteBatch();
        camara = new OrthographicCamera();
        fuente = new BitmapFont();
        camara.setToOrtho(false, 800, 400);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0.2f, 0.2f, 1);

        camara.update();
        batch.setProjectionMatrix(camara.combined);
        batch.begin();
        fuente.draw(batch, "WELCOME A ", 100, 150);
        fuente.draw(batch, "SPACE INVADERS!", 100, 100);
        batch.end();

        if (Gdx.input.isTouched()) {
            juego.setScreen(new Juego(juego));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

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
        fuente.dispose();
    }
}
