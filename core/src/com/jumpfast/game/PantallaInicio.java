package com.jumpfast.game;

import com.badlogic.gdx.Screen;

/**
 * Created by Carlos Prieto on 08/02/2017.
 */

public abstract class PantallaInicio implements Screen {

    protected MainGame juego;

    public PantallaInicio(MainGame juego){
     this.juego = juego;
    }

    /**
     * Pantalla que se muestra
     */
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

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

    /**
     * Pantalla que se deja de mostrar
     */
    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
