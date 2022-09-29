package sumo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject{
	
	
	public Player(int x, int y, int width, int height) {
		super(x, y, width, height);
		
		collisionBox.setBounds(x, y, width, height);
	}
	
	public void jump(){

	}
	
	
	void draw(Graphics g) {
			g.setColor(Color.GREEN);
			g.fillRect(x, y, width, height);
	}
}
