package sumo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Platform {
	private int x;
	private int y;
	private int width;
	private int height;
	
	private Rectangle platform = new Rectangle();
	
	public Platform(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		
		platform.setBounds(x, y, width, height);
	}
	
	public void update(){
		platform.setBounds(x, y, width, height);
	}
	
	public void draw(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
	}
	
	public Rectangle getBox(){
		return platform;
	}
	
}

