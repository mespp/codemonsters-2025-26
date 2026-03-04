package game.mespp.spaceinvaderslibgdx.screens;

public abstract class Screen {
    public game.mespp.spaceinvaderslibgdx.Main mainClass;

    public Screen(game.mespp.spaceinvaderslibgdx.Main mainClass) {
        this.mainClass = mainClass;
    }
    public abstract void render();
}
