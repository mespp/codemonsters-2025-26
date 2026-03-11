package game.mespp.spaceinvaderslibgdx.screens;

public abstract class Screen {
    public game.mespp.spaceinvaderslibgdx.Main main;

    public Screen(game.mespp.spaceinvaderslibgdx.Main mainClass) {
        this.main = mainClass;
    }
    public abstract void render();

    public abstract boolean keyDown(int keycode);
    public abstract boolean keyUp(int keycode);
}
