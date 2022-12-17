package sumo;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JApplet;

public class Player extends GameObject{
	public boolean left = false;
	public boolean right = false;
	public static BufferedImage image;
	boolean needImage = true;
	boolean gotImage = false;
	
	int xVelocity = 0;
	
	float gravity = 1f;
	float yVelocity = 0;
	int jumpPower = 22;
	
	boolean canJump = false;
	boolean isOnGround = true;
	
	public Player(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 7;
		collisionBox.setBounds(x, y, width, height);
		if (needImage) {
		    loadImage ("frog-.png");
		}
	}
	
	public void update() {
		if(left){
			x -=speed;
			
		}
		if(right){
			x += speed;
			
		}
		if (isOnGround != true) {
			yVelocity += gravity;
		}

		y += yVelocity;
		x += xVelocity;
		xVelocity *= 0.999;
		
		
		super.update();
	}
	
	public void jump(){
		if(canJump){
			yVelocity -= jumpPower;
			canJump = false;
			gravity = 1;
			playSound("jump.wav");
		}
		
	}

	
	
	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, (int)x, (int)y, 50, 50, null);
		} else {
			g.setColor(Color.GREEN);
			g.fillRect((int)x, (int)y, width, height);
		}
			
	}
	
	public void right() {
		x += speed;
	}

	public void left() {
		x -= speed;
	}


	
	
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	
	public float getYVelocity(){
		return yVelocity;
	}
	
	public float getHeight() {
		return height;
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
	
	private void playSound(String fileName) {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}
	
}
