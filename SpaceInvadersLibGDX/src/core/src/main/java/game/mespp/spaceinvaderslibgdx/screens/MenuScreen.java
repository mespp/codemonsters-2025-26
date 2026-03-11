package game.mespp.spaceinvaderslibgdx.screens;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.ScreenUtils;

public class MenuScreen extends Screen {
    public MenuScreen(game.mespp.spaceinvaderslibgdx.Main main) {
        super(main);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0f, 0f, 0f, 1f);
        main.fontBig.draw(main.batch, "Space Invaders", 35, 158);
        main.fontRegular.draw(main.batch, "press space to start", 60, 80);
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.SPACE) {
            System.out.println("empezar partida!!!");
            main.currentScreen = new GameScreen(main);
            return true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }
}
