package com.jumpfast.game.actores;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Carlos Prieto on 08/02/2017.
 */

public class ActorPinchos extends Actor {

    private Texture pinchos;

    public ActorPinchos(Texture pinchos){

        this.pinchos = pinchos;
        //Vemos cuanto miden los pinchos
        setSize(pinchos.getWidth(), pinchos.getHeight());

    }

    @Override
    public void act(float delta) {

        //Definimos la velocidad
        setX(getX() - 250 * delta);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        //Dibujamos
        batch.draw(pinchos, getX(), getY());

    }
}
