package visual.entity.mob;

import visual.graphics.Screen;
import visual.graphics.Sprite;
import visual.graphics.SpriteSheet;
import visual.input.Keyboard;

import javax.xml.soap.Text;

public class Player extends Mob {

	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	private boolean walking = false;

	public Player(Keyboard input) {
		this.input = input;
        sprite = Sprite.player_forward;
	}
	
	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player_forward;
	}
	
	public void update() {
		int xa = 0, ya = 0;

        if(anim < 14000) anim++;
		else anim = 0;
		
		if(input.up) ya--;
		if(input.down) ya++;
		if(input.left) xa--;
		if(input.right) xa++;
		
		if(xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;	
		}
	}
	
	public void render(Screen screen) {
		int flip = 1;
		
		if(dir == 0) {
			sprite = Sprite.player_forward;
			if(walking) {
				if(anim % 40 <= 8) { sprite = Sprite.player_forward; }
                if(anim % 40 > 8 && anim % 20 <= 16)	{ sprite = Sprite.player_forward_1; }
                if(anim % 40 > 16 && anim % 20 <= 24) { sprite = Sprite.player_forward_2; }
                if(anim % 40 > 24 && anim % 20 <= 32) { sprite = Sprite.player_forward_3; }
                if(anim % 40 > 32 && anim % 20 <= 40)	{ sprite = Sprite.player_forward_4; }
				}
			}
		
		if(dir == 1) {
			sprite = Sprite.player_side;
            if(walking) {
                if(anim % 40 <= 8) { sprite = Sprite.player_side; }
                if(anim % 40 > 8 && anim % 20 <= 16)	{ sprite = Sprite.player_side_1; }
                if(anim % 40 > 16 && anim % 20 <= 24) { sprite = Sprite.player_side_2; }
                if(anim % 40 > 24 && anim % 20 <= 32) { sprite = Sprite.player_side_3; }
                if(anim % 40 > 32 && anim % 20 <= 40)	{ sprite = Sprite.player_side_4; }
            }
		}
		
		if(dir == 2) {
			sprite = Sprite.player_back;
            if(walking) {
                if(anim % 40 <= 8) { sprite = Sprite.player_back; }
                if(anim % 40 > 8 && anim % 20 <= 16)	{ sprite = Sprite.player_back_1; }
                if(anim % 40 > 16 && anim % 20 <= 24) { sprite = Sprite.player_back_2; }
                if(anim % 40 > 24 && anim % 20 <= 32) { sprite = Sprite.player_back_3; }
                if(anim % 40 > 32 && anim % 20 <= 40)	{ sprite = Sprite.player_back_4; }
            }
		}
		
		if(dir == 3) {
			sprite = Sprite.player_side;
            if(walking) {
                if(anim % 40 <= 8) { sprite = Sprite.player_side; }
                if(anim % 40 > 8 && anim % 20 <= 16)	{ sprite = Sprite.player_side_1; }
                if(anim % 40 > 16 && anim % 20 <= 24) { sprite = Sprite.player_side_2; }
                if(anim % 40 > 24 && anim % 20 <= 32) { sprite = Sprite.player_side_3; }
                if(anim % 40 > 32 && anim % 20 <= 40)	{ sprite = Sprite.player_side_4; }
            }
			flip = 0;
		}

		if (!level.noPlayer()) {
			screen.renderPlayer(x - 16, y - 16, sprite, flip);
			screen.renderSheet(x + 16, y + 16, SpriteSheet.test);
		}
	}
}

