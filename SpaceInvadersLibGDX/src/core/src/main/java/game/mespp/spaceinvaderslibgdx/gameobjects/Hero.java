package game.mespp.spaceinvaderslibgdx.gameobjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import game.mespp.spaceinvaderslibgdx.Main;

public class Hero extends BaseGameObject {
    public static final int TEXTUREREGION_WIDTH = 13;
    private TextureRegion textureRegion;
    public boolean moving_left, moving_right;   // flags, mientras están activos el héroe se moverá en la dirección indicada
    private float x, y;

    public Hero(Main main, float x, float y) {
        super(main);
        textureRegion = new TextureRegion(main.textureAtlas, 3, 49, TEXTUREREGION_WIDTH, 8);
        moving_left = false;
        moving_right = false;
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(float delta) {
        if (moving_left) {
            x -= 50 * delta;
            if (x < 0) {
                x = 0;
            }
        }
        if (moving_right) {
            x += 50 * delta;
            if (x > Main.WORLD_WIDTH - TEXTUREREGION_WIDTH) {
                x = Main.WORLD_WIDTH - TEXTUREREGION_WIDTH;
            }
        }
    }

    @Override
    public void draw() {
        main.batch.draw(textureRegion, x, y);
    }
}
