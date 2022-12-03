package sumo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Platform extends GameObject {

	
	public Platform(int x, int y, int w, int h){
		super(x,y,w,h);
		
		
	}
	
	public void update(){
		super.update();
	}
	
	public void draw(Graphics g){
		g.setColor(Color.BLACK);
		System.out.println("https://hanime.tv");
		g.fillRect((int)x, (int)y, width, height);
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	
}

