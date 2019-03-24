package visual.entity.mob;

import visual.Game;
import visual.graphics.Screen;
import visual.graphics.Sprite;
import visual.input.Keyboard;
import visual.level.Level;
import visual.level.tile.Tile;

public class Cursor extends Mob {

    private Keyboard input;
    private Sprite sprite;
    private int anim = 0;
    private boolean walking = false;

    public Cursor(Keyboard input) {
        this.input = input;
        sprite = Sprite.player_forward;
    }

    public Cursor(int x, int y, Keyboard input) {
        this.x = x;
        this.y = y;
        this.input = input;
        sprite = Sprite.player_forward;
    }

    public void move(int xa, int ya) {
        if (xa != 0 && ya != 0) { // plugs in directions individually to allow movement while colliding
            move(xa, 0);
            move(0, ya);
            return;
        }

        if (xa > 0) dir = 1;
        if (xa < 0) dir = 3;
        if (ya > 0) dir = 2;
        if (ya < 0) dir = 0;

        if(!collision(xa, ya)) {
//            for (int c = 0; c < 4; c++) {
//                int xt = ((x + xa) + c % 2 * 10 - 8) / 16;
//                int yt = ((y + ya) + c % 2 * 10 + 3) / 16;

            x += xa;
            y += ya;
        }
    }

    public void update() {
        int xa = 0, ya = 0;

        if(input.up) {
            ya--;
        }

        if(input.down) {
            ya++;
        }
        if(input.left) {
            xa--;
        }
        if(input.right) {
            xa++;
        }

        if(xa != 0 || ya != 0) {
            move(2 * xa, 2 * ya);
            walking = true;
        } else {
            walking = false;
        }

        if (level.getTile((x + xa - 12)/16, (y + ya - 10)/16).menu()) {
            Tile.menu_master1 = Tile.menu1_bright;
            Tile.menu_master2 = Tile.menu2_bright;
            Tile.menu_master3 = Tile.menu3_bright;
            if(input.enter) {
                Game.currentLevel = Level.spawn;
            }
        } else {
            Tile.menu_master1 = Tile.menu1;
            Tile.menu_master2 = Tile.menu2;
            Tile.menu_master3 = Tile.menu3;
        }
    }

    public void render(Screen screen) {
        sprite = Sprite.cursor;
        if (level.menu()) {
            screen.renderCursor(x - 16, y - 16, sprite);
        }
    }

    public boolean collision(int xa, int ya) {
        boolean solid = false;
        if (x + xa < 12 || y + ya < 12 || x + xa > Game.width + 4 || y + ya > Game.height + 4) { solid = true; }
        // don't want to escape static world
        return solid;
    }
}
