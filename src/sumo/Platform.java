package sumo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Platform extends GameObject {
	public static BufferedImage image;
	boolean needImage = true;
	boolean gotImage = false;
	
	public Platform(int x, int y, int w, int h){
		super(x,y,w,h);
		if (needImage) {
		    loadImage ("cloud-platform.png");
		}
		
	}
	
	public void update(){
		super.update();
	}
	
	public void draw(Graphics g){
		if (gotImage) {
			g.drawImage(image, (int)x, (int)y, width, height*2, null);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect((int)x, (int)y, width, height);
		}
		
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	
}

