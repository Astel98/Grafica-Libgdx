package com.mygdx.game.helpers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.actores.Proyectil;
import com.mygdx.game.actores.enums.TipoProyectil;

public class Observador implements InputProcessor {

    private MyGdxGame game;

    public Observador(MyGdxGame juego){
        this.game = juego;
    }

    @Override
    public boolean keyDown(int keycode)
    {
        switch (keycode)
        {
            case Input.Keys.LEFT:
                game.nave.moverIzquierda(true);
                break;
            case Input.Keys.RIGHT:
                game.nave.moverDerecha(true);
                break;
            case Input.Keys.SPACE:
                game.prolist.add(new Proyectil("invaders-64px.png", TipoProyectil.NORMAL,
                        game.nave.getX(),game.nave.getY()+game.nave.getHeight()));
                game.stage.addActor(game.prolist.get(game.prolist.size()-1));
                break;
        }
        return true;
    }
    @Override
    public boolean keyUp(int keycode)
    {
        switch (keycode)
        {
            case Input.Keys.LEFT:
                this.game.nave.moverIzquierda(false);
                break;
            case Input.Keys.RIGHT:
                this.game.nave.moverDerecha(false);
                break;
        }
        return true;
    }


    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
