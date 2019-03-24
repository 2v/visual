package visual.level.tile;

import visual.graphics.Screen;
import visual.graphics.Sprite;

public class Door extends Tile {

    public Door(Sprite sprite) {
        super(sprite);
    }

    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this);
    }

    public boolean door() { return true; }
}
