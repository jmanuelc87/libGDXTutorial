package org.oaksoft.tutorial;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

// extiende de Game para manejar varias pantallas de acuerdo a una lógica específica
public class MainApp extends Game {

    private SpriteBatch batch;

    private PantallaExample example;

    @Override
    public void create() {
        batch = new SpriteBatch();
        example = new PantallaExample(this);

        setScreen(example);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    public SpriteBatch getBatch() {
        return batch;
    }
}
