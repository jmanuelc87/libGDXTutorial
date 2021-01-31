package org.oaksoft.tutorial;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class PantallaExample extends Pantalla {

    // clase para imprimir un texto en pantalla
    private BitmapFont font;

    // la altura de la ventana
    private int height;

    private float count;


    private float inc = 9.85f;

    public PantallaExample(MainApp app) {
        super(app);
    }

    @Override
    public void show() {
        font = new BitmapFont();
        height = Gdx.graphics.getHeight();
    }

    @Override
    public void render(float delta) {
        // Limpia la ventana en la pantallo
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        // inicia el batch para mostrar en pantalla texturas
        app.getBatch().begin();
        // dibuja una cadena en pantalla
        font.draw(app.getBatch(), "Hola, Mundo!", 10, height - 20);
        // procesa eventos desde el ratón
        processKeyboard();
        // procesa eventos desde el mouse
        processMouse();
        // instrucción para terminar el batch
        app.getBatch().begin();
    }

    private void processKeyboard() {
        // obtiene las teclas requeridas para verificar si fueron presionadas o no
        boolean pressedW = Gdx.input.isKeyPressed(Input.Keys.W);

        // obtiene el tiempo delta entre frames
        float delta = Gdx.graphics.getDeltaTime();

        // si es true entonces la tecla W fue presionada
        if (pressedW) {
            Gdx.app.log(MainApp.class.getSimpleName(), String.format("Delta %f, Count %f", delta, count));
            float velocity = inc * delta;
            // incrementa la variable count
            count += velocity * delta + 0.5 * inc * (delta * delta);
        }

        // dibuja en pantalla una cadena en una posicion especifca
        font.draw(app.getBatch(), String.format("The key W was pressed %f", count), 10, height - 40);
    }

    float x1 = 0.0f, y1 = 0.0f;

    private void processMouse() {
        // obtiene la posición del puntero dividido en dos coordenadas
        float x = Gdx.input.getX();
        float y = height - Gdx.input.getY();

        // dibuja en pantalla dos cadenas de texto, mostrar la posición actual y donde fue presionado
        font.draw(app.getBatch(), String.format("Mouse (%f, %f)", x, y), 10, height - 60);
        font.draw(app.getBatch(), String.format("Mouse Pressed on (%f,%f)", x1, y1), 10, height - 80);

        // verdadero si el mouse hizo click
        if (Gdx.input.isTouched()) {
            // obtenemos los valores donde se hizo click el mouse
            x1 = Gdx.input.getX();
            y1 = Gdx.input.getY();
        }
    }

    // metodos del ciclo de vida de la aplicación
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
