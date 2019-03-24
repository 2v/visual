package visual.entity;

import java.util.Random;

import visual.graphics.Screen;
import visual.input.Keyboard;
import visual.level.Level;

public abstract class Entity {

	public int x, y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	
	public void update() {
		
	}
	
	public void render(Screen screen) {
		
	}

	public void move(int xa, int ya) {

    }
	
	public void remove() {
		// Remove from level
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}

	public void init(Level level) { // the parameter put here will be set to the Entity's level, which will allow us to use it in the player class
		this.level = level;
	}

	public void setLocation(int x, int y) {
		this. x = x;
		this.y = y;
	}

	public boolean collision(int xa, int ya) {
		return false;
	}

}
