package org.oaksoft.tutorial.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.oaksoft.tutorial.GameApp;
import org.oaksoft.tutorial.api.AbstractScreen;
import org.oaksoft.tutorial.controller.WalkingVirtualController;
import org.oaksoft.tutorial.input.WalkingHandler;


public class WalkingScreen extends AbstractScreen {

    private WalkingVirtualController controller;

    private Animation[] animations;

    private float[] durations;

    private int x = Gdx.graphics.getHeight() / 2, y = Gdx.graphics.getWidth() / 2, z = 0;

    public WalkingScreen(GameApp game) {
        super(game);
    }

    @Override
    public void show() {
        var texture = new Texture("character1.png");
        var textureRegion = new TextureRegion(texture, 128, 128);
        var temp = textureRegion.split(128 / 4, 128 / 4);

        durations = new float[4];
        animations = new Animation[4];

        for (int i = 0; i < animations.length; i++) {
            animations[i] = new Animation(0.15f, (Object[]) temp[i]);
        }

        controller = new WalkingVirtualController();
        var keyboardHandler = new WalkingHandler(controller);

        var multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(keyboardHandler);

        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0.1f, 0.5f, 0.3f, 1);

        durations[0] += delta;
        var frame = (TextureRegion) animations[z].getKeyFrame(durations[0], true);

        switch (controller.currentDirection) {
            case NORTH:
                if (controller.isWalking) {
                    y++;
                    z = 1;
                }
                break;

            case SOUTH:
                if (controller.isWalking) {
                    y--;
                    z = 0;
                }
                break;

            case EAST:
                if (controller.isWalking) {
                    x++;
                    z = 3;
                }
                break;

            case WEST:
                if (controller.isWalking) {
                    x--;
                    z = 2;
                }
                break;
        }

        game.batch.begin();
        game.batch.draw(frame, x, y);
        game.batch.end();
    }
}
