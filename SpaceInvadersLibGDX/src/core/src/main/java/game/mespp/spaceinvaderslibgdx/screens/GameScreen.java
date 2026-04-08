package game.mespp.spaceinvaderslibgdx.screens;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import game.mespp.spaceinvaderslibgdx.Main;
import game.mespp.spaceinvaderslibgdx.gameobjects.Hero;
import game.mespp.spaceinvaderslibgdx.gameobjects.Invader;

public class GameScreen extends BaseScreen {
    private Hero hero;
    private List<Invader> invaders;
    private float invadersXSpeed = 15;

    public GameScreen(Main main) {
        super(main);
        hero = new Hero(main,(float) (Main.WORLD_WIDTH - Hero.TEXTUREREGION_WIDTH) / 2, 20);
        invaders = new ArrayList<>();
        for (int y = 230; y > 140; y -= 15) {
            for (int x = 40; x < Main.WORLD_WIDTH - 40; x += 20) {
                Invader invader = new Invader(main, x, y);
                invaders.add(invader);
            }
        }
    }

    @Override
    public void render(float delta) {
        hero.update(delta);

        boolean borderReached = false;
        for (Invader invader : invaders) {
            invader.moveRight(invadersXSpeed * delta);
            if ((invader.getX() > Main.WORLD_WIDTH - 20 && invadersXSpeed > 0)
                || (invader.getX() < 20 && invadersXSpeed < 0) ) {
                    borderReached = true;
            }
        }

        if (borderReached) {
            for (Invader invader : invaders) {
                invader.changeY(-10);
            }
            invadersXSpeed *= -1;
        }


        // componemos el frame (dibujamos)
        ScreenUtils.clear(0f, 0f, 0f, 1f);
        main.shapeRenderer.setProjectionMatrix(main.viewport.getCamera().combined);  // Configura la proyección para que coincida con tu mundo

        // Dibuja dos líneas que atraviesan el mundo de juego en diagonal
        main.shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        main.shapeRenderer.setColor(0, 0, 1, 1); // azul
        main.shapeRenderer.line(0, 0, Main.WORLD_WIDTH - 1, Main.WORLD_HEIGHT - 1);
        main.shapeRenderer.line(0, Main.WORLD_HEIGHT - 1, Main.WORLD_WIDTH - 1, 0);
        main.shapeRenderer.end();

        main.batch.begin();
        hero.draw();
        for (Invader invader : invaders) {
            invader.draw();
        }
        main.batch.end();
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
