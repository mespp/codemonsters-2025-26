package game.mespp.spaceinvaderslibgdx;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
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
public class Main extends ApplicationAdapter {
    public static final int WORLD_WIDTH = 224;
    public static final int WORLD_HEIGHT = 256;
    public Screen currentScreen;
    public SpriteBatch batch;
    // private Texture image;
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
    }

    @Override
    public void render() {
        ScreenUtils.clear(0f, 0f, 0f, 1f);
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
}
