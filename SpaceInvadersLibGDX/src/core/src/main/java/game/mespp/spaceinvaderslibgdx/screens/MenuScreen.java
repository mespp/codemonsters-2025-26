package game.mespp.spaceinvaderslibgdx.screens;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.ScreenUtils;
import game.mespp.spaceinvaderslibgdx.Main;

public class MenuScreen extends BaseScreen {
    public MenuScreen(Main main) {
        super(main);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0f, 0f, 0f, 1f);
        main.fontBig.draw(main.batch, "Space Invaders", 35, 158);
        main.fontRegular.draw(main.batch, "press space to start", 60, 80);
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.SPACE) {
            main.setScreen(new GameScreen(main));
            dispose();
            return true;
        }
        return false;
    }
}
