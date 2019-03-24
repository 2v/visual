package visual.level.tile;

import visual.graphics.Screen;
import visual.graphics.Sprite;
import visual.level.tile.menu.MenuTile;
import visual.level.tile.spawn_level.*;

public class Tile {
	
	public int x, y;
	public Sprite sprite;

	public static Tile menu1 = new MenuTile(Sprite.menu1);
	public static Tile menu2 = new MenuTile(Sprite.menu2);
	public static Tile menu3 = new MenuTile(Sprite.menu3);
	public static Tile menu1_bright = new MenuTile(Sprite.menu1_bright);
	public static Tile menu2_bright = new MenuTile(Sprite.menu2_bright);
	public static Tile menu3_bright = new MenuTile(Sprite.menu3_bright);

	public static Tile menu_master1 = menu1;
	public static Tile menu_master2 = menu2;
	public static Tile menu_master3 = menu3;
	
	public static Tile grass = new GrassTile(Sprite.grass);
  	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	public static Tile blackTile = new VoidTile(Sprite.blackSprite);

	public static Tile doorTopLeft = new Door(Sprite.door_top_left);
	public static Tile doorTopRight = new Door(Sprite.door_top_right);
	public static Tile doorBottomLeft = new Door(Sprite.door_bottom_left);
	public static Tile doorBottomRight = new Door(Sprite.door_bottom_right);

	public static Tile spawn_grass = new SpawnGrassTile(Sprite.spawn_grass);
	public static Tile spawn_hedge = new SpawnHedgeTile(Sprite.spawn_hedge);
	public static Tile spawn_water = new SpawnWaterTile(Sprite.spawn_water);
	public static Tile spawn_wall1 = new SpawnWallTile(Sprite.spawn_wall1);
	public static Tile spawn_wall2 = new SpawnWallTile(Sprite.spawn_wall2);
	public static Tile spawn_floor = new SpawnFloorTile(Sprite.spawn_floor);

	public static final int black = 0xff000000;
	public static final int col_menu1 = 0xff3c5a89;
	public static final int col_menu2 = 0xff4173c1;
	public static final int col_menu3 = 0xff5281c9;

	public static final int col_spawn_grass = 0xff00ff00;
	public static final int col_flower = 0xff228b22;
	public static final int col_spawn_hedge = 0; // unused
	public static final int col_spawn_water = 0; // unused
	public static final int col_spawn_wall1 = 0xff7f7f7f;
	public static final int col_spawn_wall2 = 0xfffb00ff;
	public static final int col_spawn_floor = 0xff804000;
	public static final int col_doortopleft = 0xff1c2875;
    public static final int col_doortopright = 0xff111e72;
    public static final int col_doorbottomleft = 0xff353c68;
    public static final int col_doorbottomright = 0xff6771af;


	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {	
	}
	
	public boolean solid() {
		return false;
	}

	public boolean door() { return false; }

	public boolean menu() { return false; }

}
