package game.mespp.spaceinvaderslibgdx;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    // private Texture image;
    private BitmapFont fontBig, fontRegular;

    @Override
    public void create() {
        batch = new SpriteBatch();
        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/space_invaders.ttf"));
        FreeTypeFontParameter fontParameter = new FreeTypeFontParameter();
        fontParameter.color = Color.WHITE;
        fontParameter.size = 28;
        fontBig = fontGenerator.generateFont(fontParameter);
        fontParameter.size = 12;
        fontRegular = fontGenerator.generateFont(fontParameter);
        fontGenerator.dispose();
        //image = new Texture("libgdx.png");
    }

    @Override
    public void render() {
        ScreenUtils.clear(0f, 0f, 0f, 1f);
        batch.begin();
        fontBig.draw(batch, "Space Invaders", 200, 50);
        fontRegular.draw(batch, "press space to start", 200, 400);
        //batch.draw(image, 140, 210);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        //image.dispose();
    }
}
