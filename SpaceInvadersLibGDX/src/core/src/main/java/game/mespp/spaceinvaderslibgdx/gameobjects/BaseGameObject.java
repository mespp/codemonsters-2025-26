package game.mespp.spaceinvaderslibgdx.gameobjects;

import game.mespp.spaceinvaderslibgdx.Main;

public abstract class BaseGameObject {
    protected Main main;

    public BaseGameObject(Main main) {
        this.main = main;
    }

    public abstract void update(float delta);

    public abstract void draw();

}
