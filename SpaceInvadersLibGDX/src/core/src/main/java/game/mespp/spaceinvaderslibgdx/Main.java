package game.mespp.spaceinvaderslibgdx;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import game.mespp.spaceinvaderslibgdx.screens.MenuScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    public static final int WORLD_WIDTH = 224;
    public static final int WORLD_HEIGHT = 256;
    public SpriteBatch batch;
    public BitmapFont fontBig, fontRegular;
    public Viewport viewport;
    public ShapeRenderer shapeRenderer;

    @Override
    public void create() {
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT);
        viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);   // refresca el viewport al comenzar

        batch = new SpriteBatch();

        shapeRenderer = new ShapeRenderer();
        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/space_invaders.ttf"));
        FreeTypeFontParameter fontParameter = new FreeTypeFontParameter();
        fontParameter.color = Color.WHITE;
        fontParameter.size = 16;
        fontBig = fontGenerator.generateFont(fontParameter);
        fontBig.setUseIntegerPositions(false);

        fontParameter.size = 8;
        fontRegular = fontGenerator.generateFont(fontParameter);
        fontRegular.setUseIntegerPositions(false);
        fontGenerator.dispose();

        this.setScreen(new MenuScreen(this));
    }

    @Override
    public void render() {
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        super.render();
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        fontBig.dispose();
        fontRegular.dispose();
        getScreen().dispose();
        shapeRenderer.dispose();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }
}
