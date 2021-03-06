package mx.itesm.sheep;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Define las características de una pantalla genérica
 */

public abstract class MainScreen implements com.badlogic.gdx.Screen
{
    // Atributos disponibles en todas las clases del proyecto
    public static final float ANCHO = 1080;
    public static final float ALTO = 1920;

    // Atributos disponibles en las subclases
    // Todas las pantallas tienen una cámara y la vista
    protected OrthographicCamera camara;
    protected Viewport vista;
    protected Preferences pref;
    // Todas las pantallas dibujan
    protected SpriteBatch batch;

    public MainScreen() {
        pref = Gdx.app.getPreferences("My Preferences");
        camara = new OrthographicCamera(ANCHO, ALTO);
        camara.position.set(ANCHO / 2, ALTO / 2, 0);
        camara.update();
        vista = new StretchViewport(ANCHO, ALTO, camara);
        batch = new SpriteBatch();
    }

    // Borra la pantalla con fondo negro
    protected void borrarPantalla() {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    // Borra la pantalla con el color RGB (r,g,b)
    protected void borrarPantalla(float r, float g, float b) {
        Gdx.gl.glClearColor(r,g,b,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    public Preferences getPref(){
        return pref;
    }

    @Override
    public void resize(int width, int height) {
        vista.update(width, height);
    }

    @Override
    public void hide() {
        dispose();  /// Libera los recursos asignados por cada pantalla
    }
}
