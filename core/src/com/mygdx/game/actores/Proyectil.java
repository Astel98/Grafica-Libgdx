package com.mygdx.game.actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.actores.enums.TipoProyectil;

public class Proyectil extends Actor {
    private int vida;
    public Rectangle cuerpo;
    private TipoProyectil tipo;
    private Sprite sprite;
    private Texture texture;
    private TextureRegion textureRegion;
    public Proyectil(String img, TipoProyectil tipo, float x, float y){
        this.tipo = tipo;
        crear(img);
        setPosition(x,y);
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
    @Override
    public void act(float delta) {
        super.act(delta);
        switch (tipo){
            case NORMAL:
                setPosition(getX(),getY()  + 20 *  Gdx.graphics.getDeltaTime());
                break;
            case ENEMIGO:
                setPosition(getX(),getY()  - 20 *  Gdx.graphics.getDeltaTime());
                break;
        }
    }
    private void crear(String img){
        texture = new Texture(img);
        textureRegion = new TextureRegion(texture, 0,64,64,64);
        sprite = new Sprite(textureRegion);
        cuerpo = new Rectangle(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
        setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());

    }

}
