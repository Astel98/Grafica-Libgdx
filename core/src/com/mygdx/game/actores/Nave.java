package com.mygdx.game.actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.actores.enums.TipoCheck;
import com.mygdx.game.helpers.Colisionador;

public class Nave extends Actor {
    private Sprite sprite;
    private Texture texture;
    private TextureRegion textureRegion;
    private int vida, dmg;
    private float dps, spd;
    public Rectangle cuerpo;
    private boolean derecha, izquieda = false;
    private Colisionador colisionador;

    public Nave(String img, Action action){
        crear(img);
        sprite.setPosition(Gdx.graphics.getWidth()/2-sprite.getWidth()/2,Gdx.graphics.getHeight()/2-sprite.getHeight()/2);
    }

    public Nave(String img, float x, float y){
        crear(img);
        setX(x);
        setY(y);
        sprite.setPosition(x,y);
    }

    public Nave(String img, float x, float y, Colisionador col){
        this.colisionador = col;
        crear(img);
        setX(x);
        setY(y);
        sprite.setPosition(x,y);
    }

    @Override
    protected void positionChanged() {
        super.positionChanged();
        cuerpo.setPosition(getX(),getY());
        sprite.setPosition(getX(),getY());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        sprite.draw(batch);
    }

    private void crear(String img){
        texture = new Texture(img);
        textureRegion = new TextureRegion(texture, 64,64);
        sprite = new Sprite(textureRegion);
        cuerpo = new Rectangle(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
        setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());

    }


    public void moverIzquierda(boolean b) {
        if(derecha && b) derecha = false;
        izquieda = b;
    }

    public void moverDerecha(boolean b) {
        if(izquieda && b) izquieda = false;
        derecha = b;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (izquieda)
        {
            moveBy(-1f,0f);
            //setPosition(getX() - 10 * Gdx.graphics.getDeltaTime(),getY());
        }
        if (derecha)
        {
            moveBy(1f,0f);
            //setPosition(getX() + 10 * Gdx.graphics.getDeltaTime(),getY());
        }
        if(colisionador.checkChoque(TipoCheck.NAVE)){
            vida--;
        }

    }

    @Override
    public Actor hit(float x, float y, boolean touchable) {
        return super.hit(x, y, touchable);
    }

    public Colisionador getColisionador(){
        return this.colisionador;
    }
    public void setColisionador(Colisionador colisionador){
        this.colisionador=colisionador;
    }
}
