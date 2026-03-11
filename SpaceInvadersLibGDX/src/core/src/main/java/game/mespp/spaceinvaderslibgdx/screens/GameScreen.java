package game.mespp.spaceinvaderslibgdx.screens;

import com.badlogic.gdx.utils.ScreenUtils;
import game.mespp.spaceinvaderslibgdx.Main;

public class GameScreen extends Screen {
    public GameScreen(Main main) {
        super(main);
    }

    @Override
    public void render() {
        ScreenUtils.clear(1f, 0f, 0f, 1f);
    }

    @Override
    public boolean keyDown(int keycode) {
        System.out.println("Se ha pulsado una tecla estando en la partida!!!");
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }
}
