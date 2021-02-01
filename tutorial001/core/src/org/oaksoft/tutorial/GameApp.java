package org.oaksoft.tutorial;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.oaksoft.tutorial.screens.WalkingScreen;

public class GameApp extends Game {

    public SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        var walkingScreen = new WalkingScreen(this);

        setScreen(walkingScreen);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
