package visual.entity.mob;

import visual.Game;
import visual.entity.Entity;
import visual.graphics.Screen;
import visual.graphics.Sprite;
import visual.level.Level;
import visual.level.tile.Tile;


public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;

	public void move(int xa, int ya) {
	    if (xa != 0 && ya != 0){ // plugs in directions individually to allow movement while colliding
	        move(xa, 0);
	        move(0, ya);
	        return;
        }

        if(xa > 0) dir = 1;
		if(xa < 0) dir = 3;
		if(ya > 0) dir = 2;
		if(ya < 0) dir = 0;

        if(!collision(xa, ya)) {
        	if (playerLocationCheck(xa, ya).door()) {
				if (Game.currentLevel != Level.next) {
				    Game.currentLevel = Level.next;
				    setLocation(10 * 16, 20 * 16);
                }
			}
			x += xa;
			y += ya;
        }
	}

	
	public void update() {
	}
	
	public void render() {
	}
	
	public boolean collision(int xa, int ya) {
        boolean solid = false;
        for (int c = 0; c < 4; c++) {
            int xt = ((x + xa) + c % 2 * 14 - 8) / 16;
            int yt = ((y + ya) + c % 2 * 12 + 3) / 16;
            if  (level.getTile(xt, yt).solid()) { solid = true; }
        }
        return solid;
	}

	public Tile playerLocationCheck(int xa, int ya) {
		Tile current = new Tile(sprite);
		for (int c = 0; c < 4; c++) {
			int xt = ((x + xa) + c % 2 * 14 - 8) / 16;
			int yt = ((y + ya) + c % 2 * 12 + 3) / 16;
			current = level.getTile(xt, yt);
		}
		return current;
	}

	public void setLocation(int x, int y) {
		this. x = x;
		this.y = y;
	}
}
