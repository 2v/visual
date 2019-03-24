package visual.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	private String path;
	public final int WIDTH;
    public final int HEIGHT;
	public int[] pixels;
	
	public static SpriteSheet tiles = new SpriteSheet("/textures/spritesheet.png", 256, 256);
	public static SpriteSheet spawn_level = new SpriteSheet("/textures/sheets/spawn_level.png", 48, 48);
	public static SpriteSheet menu = new SpriteSheet("/textures/sheets/menu.png", 48, 64);
	public static SpriteSheet test = new SpriteSheet("/textures/sheets/test.png", 64, 32);
	public static SpriteSheet font = new SpriteSheet("/textures/sheets/font.png", 24, 24);
	
	public SpriteSheet(String path, int width, int height) {
		this.path = path;
		WIDTH = width;
		HEIGHT = height;
		pixels = new int[WIDTH * HEIGHT];
		load();
	}
	
	private void load() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

