package game.mespp.spaceinvaderslibgdx.gameobjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import game.mespp.spaceinvaderslibgdx.Main;

public class Hero extends BaseGameObject {
    private TextureRegion textureRegion;
    public boolean moving_left, moving_right;   // flags, mientras están activos el héroe se moverá en la dirección indicada
    private float x, y;

    public Hero(Main main) {
        super(main);
        textureRegion = new TextureRegion(main.textureAtlas, 3, 49, 13, 8);
        moving_left = false;
        moving_right = false;
        x = Main.WORLD_WIDTH / 2;
        y = 100;
    }

    @Override
    public void update() {
        if (moving_left) {
            x -= 1;
        }
        if (moving_right) {
            x += 1;
        }
    }

    @Override
    public void draw() {
        main.batch.begin();
        main.batch.draw(textureRegion, x, y);
        main.batch.end();
    }
}
