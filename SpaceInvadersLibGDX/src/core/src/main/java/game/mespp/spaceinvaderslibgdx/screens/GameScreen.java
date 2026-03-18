package game.mespp.spaceinvaderslibgdx.screens;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import game.mespp.spaceinvaderslibgdx.Main;

public class GameScreen extends BaseScreen {
    public GameScreen(Main main) {
        super(main);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0f, 0f, 0f, 1f);
        main.shapeRenderer.setProjectionMatrix(main.viewport.getCamera().combined);  // Configura la proyección para que coincida con tu mundo

        // Dibuja dos líneas que atraviesan el mundo de juego en diagonal
        main.shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        main.shapeRenderer.setColor(0, 0, 1, 1); // azul
        main.shapeRenderer.line(0, 0, Main.WORLD_WIDTH - 1, Main.WORLD_HEIGHT - 1);
        main.shapeRenderer.line(0, Main.WORLD_HEIGHT - 1, Main.WORLD_WIDTH - 1, 0);
        main.shapeRenderer.end();
    }
}
