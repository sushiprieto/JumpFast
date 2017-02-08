package com.jumpfast.game.actores;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Carlos Prieto on 08/02/2017.
 */

public class ActorJugador extends Actor {

    private Texture jugador;

    private boolean vivo;

    public Texture getJugador() {
        return jugador;
    }

    public void setJugador(Texture jugador) {
        this.jugador = jugador;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public ActorJugador(Texture jugador){

        this.jugador = jugador;

        //Empiezas vivo
        this.vivo = true;

        //Vemos cuanto mide el cubo
        setSize(jugador.getWidth(), jugador.getHeight());

    }

    @Override
    public void act(float delta) {

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        //Dibujamos
        batch.draw(jugador, getX(), getY());

    }
}
