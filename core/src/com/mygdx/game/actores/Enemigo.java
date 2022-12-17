package com.mygdx.game.actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.actores.enums.TipoCheck;
import com.mygdx.game.actores.enums.TipoEnemigo;
import com.mygdx.game.helpers.Colisionador;

public class Enemigo extends Actor {
    private int vida;
    private TipoEnemigo tipo;
    private Sprite sprite;
    private Texture texture;
    private TextureRegion textureRegion;
    private String img;
    public Rectangle cuerpo;
    private Colisionador colisionador;
    private float dir = 1;

    public Enemigo(String img, TipoEnemigo tipo, float x, float y, Colisionador col){
        this.colisionador = col;
        this.tipo = tipo;
        this.img = img;
        crear();
        setPosition(x,y);
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
    private void crear(){
        texture = new Texture(img);
        switch (tipo){
            case NORMAL:
                vida=1;
                textureRegion = new TextureRegion(texture, 64*3,0,64,64);
                break;
            case DIFICIL:
                textureRegion = new TextureRegion(texture, 64*4,0,64,64);
                vida=3;
                break;
            case JEFE:
                textureRegion = new TextureRegion(texture, 64*5,0,64,64);
                vida=30;
                break;
        }
        sprite = new Sprite(textureRegion);
        cuerpo = new Rectangle(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
        setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());

    }
    @Override
    public void act(float delta) {
        super.act(delta);
        setPosition(getX() + 10 * dir * Gdx.graphics.getDeltaTime(),getY());
        if(getX()<0){
            dir = 1;
        } else if (getX()+sprite.getWidth()>Gdx.graphics.getWidth()) {
            dir = -1;
        }
        if(colisionador.checkEnemigos(this)){
            vida--;
        }

    }

    public Colisionador getColisionador(){
        return this.colisionador;
    }
    public void setColisionador(Colisionador colisionador){
        this.colisionador=colisionador;
    }

    public int getVida(){
        return vida;
    }
    public void setVida(int vida){
        this.vida=vida;
    }

}
