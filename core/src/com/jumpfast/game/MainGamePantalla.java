package com.jumpfast.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.jumpfast.game.actores.ActorJugador;
import com.jumpfast.game.actores.ActorPinchos;

/**
 * Created by Carlos Prieto on 08/02/2017.
 */

public class MainGamePantalla extends PantallaInicio {

    //Creamos un stage
    private Stage stage;

    //Creamos un actor
    private ActorJugador jugador;
    private ActorPinchos pinchos;

    private Texture texturaJugador, texturaPinchos;

    public MainGamePantalla(MainGame juego) {

        super(juego);
        texturaJugador = new Texture("cubo.png");
        texturaPinchos = new Texture("pincho.png");

    }

    @Override
    public void show() {

        stage = new Stage();
        //Cuando se dibuja nos marca los bordes de los objetos
        stage.setDebugAll(true);

        jugador = new ActorJugador(texturaJugador);
        stage.addActor(jugador);
        jugador.setPosition(20, 100);

        pinchos = new ActorPinchos(texturaPinchos);
        stage.addActor(pinchos);
        pinchos.setPosition(600, 100);

    }

    @Override
    public void hide() {

        stage.dispose();
        texturaJugador.dispose();

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0.4f, 0.5f, 0.8f, 1f);

        //Dibuja el escenario y los actores
        stage.act();

        comprobarColisiones();

        stage.draw();

    }

    private void comprobarColisiones(){

        if (jugador.isVivo() && jugador.getX() + jugador.getWidth() > pinchos.getX()){

            System.out.println("CHOCOOO");
            jugador.setVivo(false);

        }

    }

    @Override
    public void dispose() {

        texturaJugador.dispose();

    }
}
