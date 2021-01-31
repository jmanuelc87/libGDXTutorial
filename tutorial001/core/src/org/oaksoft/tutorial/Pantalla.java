package org.oaksoft.tutorial;

import com.badlogic.gdx.Screen;

// clase abstracta que implementa la interfaz screen
public abstract class Pantalla implements Screen {

    protected MainApp app;

    public Pantalla(MainApp app) {
        this.app = app;
    }
}
