package visual.level;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Menu extends Level {

    public Menu(String path) {
        super(path);
    }

    protected void loadLevel(String path) {
        try {
            BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
            int w = width = image.getWidth();
            int h = height = image.getHeight();
            tiles = new int[w * h];
            image.getRGB(0, 0, w, h, tiles, 0, w);
        } catch(IOException ex) {
            ex.printStackTrace();
            System.out.println("Exception! Could not load level file!");
        }
    }

    protected void generateLevel() {
    }

    public boolean noPlayer() {
        return true;
    }

    public boolean staticPosition() { return true; }

    public boolean menu() { return true; }

}
