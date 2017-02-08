package com.jumpfast.game;

import com.badlogic.gdx.Game;

public class MainGame extends Game {

	@Override
	public void create() {

		//Dibuja en pantalla otra pantalla
		setScreen(new PantallaBox2D(this));

	}
}
