package com.mygdx.game.helpers;

import com.mygdx.game.MyGdxGame;
import com.mygdx.game.actores.Enemigo;
import com.mygdx.game.actores.Nave;
import com.mygdx.game.actores.Proyectil;
import com.mygdx.game.actores.enums.TipoCheck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

public class Colisionador {
    private Nave nave;
    private LinkedList<Proyectil> proyectiles;
    private LinkedList<Enemigo> enemigos;
    private MyGdxGame juego;
    public Colisionador(Nave nave, LinkedList<Proyectil> proyectiles, LinkedList<Enemigo> enemigos){
        this.nave = nave;
        this.proyectiles=proyectiles;
        this.enemigos=enemigos;
    }
    public Colisionador(MyGdxGame juego){
        this.juego = juego;
    }
    public boolean checkChoque(TipoCheck tipoCheck){
        if (tipoCheck == TipoCheck.NAVE){
            for (Proyectil p: juego.prolist) {
                if(juego.nave.cuerpo.overlaps(p.cuerpo)){
                    return true;
                }
            }
        }
        if (tipoCheck == TipoCheck.PROYECTIL){

        }
        if(tipoCheck == TipoCheck.ENEMIGO){
            for (Proyectil p: juego.prolist) {
                for (Enemigo e : juego.enelist){
                    if(e.cuerpo.overlaps(p.cuerpo)){
                        juego.prolist.remove(p);
                        p.remove();
                        if(e.getVida() < 1){
                            juego.enelist.remove(e);
                            e.setX(0);
                            e.remove();
                        }
                        return true;
                    }
                }
            }
        }
        return false ;
    }
    public boolean checkEnemigos(Enemigo e){
        for (Proyectil p: juego.prolist) {
            if(e.cuerpo.overlaps(p.cuerpo)){
                juego.prolist.remove(p);
                p.remove();
                System.out.println(e.getVida());
                if(e.getVida() <= 1){
                    juego.enelist.remove(e);
                    e.remove();
                }
                if(juego.enelist.isEmpty()){
                    juego.nextStage();
                }
                return true;
            }
        }

        return false;
    }
}
