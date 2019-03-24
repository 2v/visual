package visual.level;

import visual.Game;
import visual.graphics.Screen;
import visual.level.tile.Tile;

public class Level {

    protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;

	public static Level spawn = new SpawnLevel("/textures/levels/spawn.png");
	public static Level next = new SpawnLevel("/textures/levels/level1.png");
	public static Level mainmenu = new Menu("/textures/levels/mainmenu.png");
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();
	}
	
	public Level(String path) {
		loadLevel(path);
	}

	protected void generateLevel() {
	}
	
	protected void loadLevel(String path) {
	}
	
	private void time() {
	}
	
	public void update() {
	}

	public boolean noPlayer() {
		return false;
	}

	public boolean staticPosition() { return false; }
	
	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0, x1, y0, y1;

		if (Game.currentLevel.staticPosition()) {
			x0 = 0; // divides by sixteen
			x1 = (screen.width + 16) >> 4;
			y0 = 0;
			y1 = (screen.height + 16) >> 4;
		} else {
			x0 = xScroll >> 4; // divides by sixteen
			x1 = (xScroll + screen.width + 16) >> 4;
			y0 = yScroll >> 4;
			y1 = (yScroll + screen.height + 16) >> 4;
		}

		for(int y = y0; y < y1; y++) {
			for(int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
	}
	
	public Tile getTile(int x, int y) {
    if(x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		if(tiles[x + y * width] == Tile.col_spawn_floor) return Tile.spawn_floor;
		if(tiles[x + y * width] == Tile.col_flower) return Tile.flower;
		if(tiles[x + y * width] == Tile.col_spawn_grass) return Tile.spawn_grass;
		if(tiles[x + y * width] == Tile.col_spawn_hedge) return Tile.spawn_hedge;
		if(tiles[x + y * width] == Tile.col_spawn_wall1) return Tile.spawn_wall1;
		if(tiles[x + y * width] == Tile.col_spawn_wall2) return Tile.spawn_wall2;
		if(tiles[x + y * width] == Tile.col_spawn_water) return Tile.spawn_water;
		if(tiles[x + y * width] == Tile.col_doortopleft) return Tile.doorTopLeft;
		if(tiles[x + y * width] == Tile.col_doortopright) return Tile.doorTopRight;
		if(tiles[x + y * width] == Tile.col_doorbottomleft) return Tile.doorBottomLeft;
		if(tiles[x + y * width] == Tile.col_doorbottomright) return Tile.doorBottomRight;
		if(tiles[x + y * width] == Tile.col_menu1) return Tile.menu_master1;
		if(tiles[x + y * width] == Tile.col_menu2) return Tile.menu_master2;
		if(tiles[x + y * width] == Tile.col_menu3) return Tile.menu_master3;
		if(tiles[x + y * width] == Tile.black) return Tile.blackTile;

		return Tile.voidTile;
	}

	public boolean menu() {
		return false;
	}

}
