package game.mespp.spaceinvaderslibgdx.screens;

public class MenuScreen extends Screen {
    public MenuScreen(game.mespp.spaceinvaderslibgdx.Main mainClass) {
        super(mainClass);
    }

    @Override
    public void render() {
        mainClass.fontBig.draw(mainClass.batch, "Space Invaders", 35, 158);
        mainClass.fontRegular.draw(mainClass.batch, "press space to start", 60, 80);
    }
}
