package com.mygdx.game.actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.actores.enums.TipoMejora;

public class Mejora extends Actor {
    private int vida;
    private TipoMejora tipo;
    private Sprite sprite;

    public Mejora(String img, Action action, TipoMejora tipo){
        this.tipo = tipo;
        crear(img, action);
        sprite.setPosition(Gdx.graphics.getWidth()/2-sprite.getWidth()/2,Gdx.graphics.getHeight()/2-sprite.getHeight()/2);
    }

    public Mejora(String img, Action action, TipoMejora tipo, float x, float y){
        this.tipo = tipo;
        crear(img, action);
        sprite.setPosition(x,y);
    }

    @Override
    protected void positionChanged() {
        super.positionChanged();
        sprite.setPosition(getX(),getY());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        sprite.draw(batch);
    }

    private void mover(float x, float y){
        setPosition(x,y);
        return;
    }

    private void crear(String img, Action action){
        sprite = new Sprite(new Texture(img));
        setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
        addAction(action);

    }

}
