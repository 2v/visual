package visual;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import visual.entity.mob.Cursor;
import visual.entity.mob.Player;
import visual.graphics.Screen;
import visual.graphics.Sprite;
import visual.graphics.Text;
import visual.input.Keyboard;
import visual.level.Level;

public class Game extends Canvas implements Runnable { 
	private static final long serialVersionUID = 1L;

	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	
	public static String title = "VISUAL";
	
	private Thread thread;
	private JFrame frame;
	private Keyboard key;
	private Level level;
	public static Level currentLevel;
	private Player player;
	private Cursor cursor;
	private boolean running = false;
    private Dimension size;
    private Text text = new Text();
    public static Graphics g;

	private long timer = System.currentTimeMillis();
	
	private Screen screen;
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	public Game(Level level) {
	    this.size = new Dimension(width * scale, height * scale);
	    setPreferredSize(size);
	
	    screen = new Screen(width, height);
	    frame = new JFrame();
	    key = new Keyboard();
	    this.level = level;
	    currentLevel = level;
	    player = new Player(140, 128, key);
        player.init(level);

		cursor = new Cursor(40, 40, key);
		cursor.init(level);
	    
	    addKeyListener(key);
	}
	
	public synchronized void start() {
	    running = true;
	    thread = new Thread(this, "Display");
	    thread.start();
	}
	
	public synchronized void stop() {
	    running = false;
	    try {
	        thread.join();
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
	
	public void run() {
		double ns = 1000000000.0 / 60.0;
		double delta = 0;
		
		int frames = 0;
		int updates = 0;
		
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		
		requestFocus();
		
	    while (running) {
	    	long now = System.nanoTime();
	    	
	    	delta += (now - lastTime) / ns;
	    	lastTime = now;
	    	
	    	while(delta >= 1) {
	    		update();
	    		updates++;
	    		delta--;
	    	}
	    	
	        render();
	        frames++;
	        
	        if(System.currentTimeMillis() - timer >= 1000) {
	        	timer += 1000;
	        	frame.setTitle(title + "  |  " + updates + " ups, " + frames + " fps");
	        	frames = 0;
	        	updates = 0;
	        }
	    }
	    
	    stop();
	}
	
	public void update() {
		key.update();
		player.update();
        player.init(currentLevel);
		cursor.update();
		cursor.init(currentLevel);
	}
	
	public void render() {
	    BufferStrategy bs = getBufferStrategy();
	    if (bs == null) {
	        createBufferStrategy(3);
	        return;
	    }
	    
	    screen.clear();
      
	    int xScroll = player.x - screen.width / 2;
	    int yScroll = player.y - screen.height / 2;
//		xScroll gets the coordinates of the top left of the visible portion
	    
	    currentLevel.render(xScroll, yScroll, screen);
//	    player.render(player.x, player.y, screen);
		player.render(screen);
		cursor.render(screen);

	    for(int i = 0; i < pixels.length; i++) {
	    	pixels[i] = screen.pixels[i];
	    }

	    g = bs.getDrawGraphics();
	    g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
//        text.renderText(screen);
	    g.dispose();
	    bs.show();
	}
	
	public static void main(String[] args) {
	    Game game = new Game(Level.mainmenu);
	    game.frame.setResizable(false);
	    game.frame.setTitle(Game.title);
	    game.frame.add(game);
	    game.frame.pack();
	    game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    game.frame.setLocationRelativeTo(null);
	    game.frame.setVisible(true);



	    game.start();
	}

}

