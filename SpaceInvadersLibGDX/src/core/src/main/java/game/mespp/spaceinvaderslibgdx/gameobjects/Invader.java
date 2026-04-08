package game.mespp.spaceinvaderslibgdx.gameobjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import game.mespp.spaceinvaderslibgdx.Main;

public class Invader extends BaseGameObject {
    private static final int TEXTUREREGION_WIDTH = 8;
    private TextureRegion textureRegion;
    public boolean moving_left, moving_right;   // flags, mientras están activos el héroe se moverá en la dirección indicada
    private float x, y;

    public float getX() {
        return x;
    }

    public void changeY(float value) {
        y += value;
    }

    public Invader(Main main, float x, float y) {
        super(main);
        textureRegion = new TextureRegion(main.textureAtlas, 5, 1, TEXTUREREGION_WIDTH, 8);
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(float delta) {
    }

    public void moveRight(float x) {
        this.x += x;
    }

    @Override
    public void draw() {
        main.batch.draw(textureRegion, x, y);
    }
}
