package game.mespp.spaceinvaderslibgdx.screens;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import game.mespp.spaceinvaderslibgdx.Main;
import game.mespp.spaceinvaderslibgdx.gameobjects.Hero;

public class GameScreen extends BaseScreen {
    private Hero hero;

    public GameScreen(Main main) {
        super(main);
        hero = new Hero(main);
    }

    @Override
    public void render(float delta) {
        hero.update();

        ScreenUtils.clear(0f, 0f, 0f, 1f);
        main.shapeRenderer.setProjectionMatrix(main.viewport.getCamera().combined);  // Configura la proyección para que coincida con tu mundo

        // Dibuja dos líneas que atraviesan el mundo de juego en diagonal
        main.shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        main.shapeRenderer.setColor(0, 0, 1, 1); // azul
        main.shapeRenderer.line(0, 0, Main.WORLD_WIDTH - 1, Main.WORLD_HEIGHT - 1);
        main.shapeRenderer.line(0, Main.WORLD_HEIGHT - 1, Main.WORLD_WIDTH - 1, 0);
        main.shapeRenderer.end();

        hero.draw();
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.LEFT) {
            hero.moving_left = true;
            return true;
        } else if (keycode == Input.Keys.RIGHT) {
            hero.moving_right = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.LEFT) {
            hero.moving_left = false;
            return true;
        } else if (keycode == Input.Keys.RIGHT) {
            hero.moving_right = false;
            return true;
        }
        return false;
    }

}
