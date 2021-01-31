package org.oaksoft.tutorial;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class PantallaAnimation extends Pantalla {

    private TextureAtlas atlas;

    private Texture texture;

    private TextureRegion textureRegion;

    private TextureRegion[] frames;

    private Animation animation;

    private float duration = 0.0f;

    private static final int WIDTH = 252;

    private static final int HEIGHT = 49;

    public PantallaAnimation(MainApp app) {
        super(app);
    }

    @Override
    public void show() {

/*
        atlas = new TextureAtlas("atlas.atlas");
        // TODO: probar con una texture real
        TextureRegion textureRegion1 = atlas.findRegion("...");
        textureRegion = new TextureRegion(textureRegion1, WIDTH, HEIGHT);
*/

        // TODO: falta probar con una textura real
        // carga una textura con varios sprites
        texture = new Texture("...");
        // la textura se acota a una region definida
        textureRegion = new TextureRegion(texture, WIDTH, HEIGHT);
        // obtenemos todos los sprites desde la textura en un arreglo
        TextureRegion[][] temp = textureRegion.split(WIDTH / 9, HEIGHT);
        // textura por cada sprite
        frames = new TextureRegion[temp.length * temp[0].length];
        // Transformamos desde una matriz a un arreglo
        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                frames[index++] = temp[i][j];
            }
        }

        // creamos una clase de animación con los frames que obtuvimos
        animation = new Animation(0.1f, frames);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);

        // sumamos los tiempos delta para obtener una textura especifica de la animación
        duration += delta;
        TextureRegion frame = (TextureRegion) animation.getKeyFrame(duration, true);

        // pintamos la textura en pantalla
        app.getBatch().begin();
        app.getBatch().draw(frame, 100, 100);
        app.getBatch().end();
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

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
