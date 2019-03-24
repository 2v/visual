package visual.level.tile.menu;

import visual.graphics.Screen;
import visual.graphics.Sprite;
import visual.level.tile.Tile;

public class MenuTile extends Tile {

    public MenuTile(Sprite sprite) {
        super(sprite);
    }

    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this);
    }

    public boolean menu() { return true; }


}
