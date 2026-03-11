package game.mespp.spaceinvaderslibgdx;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import game.mespp.spaceinvaderslibgdx.screens.MenuScreen;
import game.mespp.spaceinvaderslibgdx.screens.Screen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter implements InputProcessor {
    public static final int WORLD_WIDTH = 224;
    public static final int WORLD_HEIGHT = 256;
    public Screen currentScreen;
    public SpriteBatch batch;
    //private Texture image;
    public BitmapFont fontBig;
    public BitmapFont fontRegular;
    private Viewport viewport;
    private Camera camera;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);

        batch = new SpriteBatch();

        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/space_invaders.ttf"));
        FreeTypeFontParameter fontParameter = new FreeTypeFontParameter();
        fontParameter.color = Color.WHITE;
        fontParameter.size = 16;
        fontBig = fontGenerator.generateFont(fontParameter);
        fontParameter.size = 8;
        fontRegular = fontGenerator.generateFont(fontParameter);
        fontGenerator.dispose();

        currentScreen = new MenuScreen(this);
        //image = new Texture("libgdx.png");

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render() {
        //ScreenUtils.clear(0f, 0f, 0f, 1f);
        batch.begin();
        //batch.draw(image, 140, 210);
        currentScreen.render();
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        fontBig.dispose();
        fontRegular.dispose();
        //image.dispose();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public boolean keyDown(int keycode) {
        return currentScreen.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        return currentScreen.keyUp(keycode);
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
