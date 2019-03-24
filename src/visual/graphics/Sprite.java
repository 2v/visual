package visual.graphics;

public class Sprite {

	private int x, y;
	private SpriteSheet sheet;
	
	public final int SIZE;
	public int[] pixels;

	public static Sprite menu1 = new Sprite(16, 0, 0, SpriteSheet.menu);
	public static Sprite menu2 = new Sprite(16, 1, 0, SpriteSheet.menu);
	public static Sprite menu3 = new Sprite(16, 2, 0, SpriteSheet.menu);
	public static Sprite menu1_bright = new Sprite(16, 0, 2, SpriteSheet.menu);
	public static Sprite menu2_bright = new Sprite(16, 1, 2, SpriteSheet.menu);
	public static Sprite menu3_bright = new Sprite(16, 2, 2, SpriteSheet.menu);

	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite flower = new Sprite(16, 0, 4, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite cursor = new Sprite(16, 8, 0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0x000000);
  
  // Spawn Level Sprites
	public static Sprite spawn_grass = new Sprite(16, 0, 0, SpriteSheet.spawn_level);
	public static Sprite spawn_hedge = new Sprite(16, 0, 1, SpriteSheet.spawn_level);
	public static Sprite spawn_water = new Sprite(16, 0, 2, SpriteSheet.spawn_level);
	public static Sprite spawn_wall1 = new Sprite(16, 0, 1, SpriteSheet.spawn_level);
	public static Sprite spawn_wall2 = new Sprite(16, 0, 2, SpriteSheet.spawn_level);
	public static Sprite spawn_floor = new Sprite(16, 1, 1, SpriteSheet.spawn_level);

	// Door sprites
	public static Sprite door_top_left = new Sprite(16, 6, 0, SpriteSheet.tiles);
	public static Sprite door_top_right = new Sprite(16, 7, 0, SpriteSheet.tiles);
	public static Sprite door_bottom_left = new Sprite(16, 6, 1, SpriteSheet.tiles);
	public static Sprite door_bottom_right = new Sprite(16, 7, 1, SpriteSheet.tiles);
	
	// Player Sprites
    public static Sprite player_forward = new Sprite(32, 0, 6, SpriteSheet.tiles);
	public static Sprite player_forward_1 = new Sprite(32, 1, 6, SpriteSheet.tiles);
	public static Sprite player_forward_2 = new Sprite(32, 2, 6, SpriteSheet.tiles);
    public static Sprite player_forward_3 = new Sprite(32, 3, 6, SpriteSheet.tiles);
    public static Sprite player_forward_4 = new Sprite(32, 4, 6, SpriteSheet.tiles);

    public static Sprite player_side = new Sprite(32, 0, 5, SpriteSheet.tiles);
	public static Sprite player_side_1 = new Sprite(32, 1, 5, SpriteSheet.tiles);
	public static Sprite player_side_2 = new Sprite(32, 2, 5, SpriteSheet.tiles);
    public static Sprite player_side_3 = new Sprite(32, 3, 5, SpriteSheet.tiles);
    public static Sprite player_side_4 = new Sprite(32, 4, 5, SpriteSheet.tiles);

    public static Sprite player_back = new Sprite(32, 0, 4, SpriteSheet.tiles);
	public static Sprite player_back_1 = new Sprite(32, 1, 4, SpriteSheet.tiles);
    public static Sprite player_back_2 = new Sprite(32, 2, 4, SpriteSheet.tiles);
    public static Sprite player_back_3 = new Sprite(32, 3, 4, SpriteSheet.tiles);
    public static Sprite player_back_4 = new Sprite(32, 4, 4, SpriteSheet.tiles);

    public static Sprite blackSprite = new Sprite(16, 0xff000000);

    public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int size, int color) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}
	
	private void setColor(int color) {
		for(int i = 0; i < SIZE * SIZE; i++) {
			pixels[i] = color;
		}
	}
	
	private void load() {
		for(int y = 0; y < SIZE; y++) {
			for(int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.WIDTH];
			}
		}
	}
}
