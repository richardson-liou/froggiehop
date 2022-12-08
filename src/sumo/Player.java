package sumo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject{
	public boolean left = false;
	public boolean right = false;
	
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
		}
		
	}

	
	
	void draw(Graphics g) {
			g.setColor(Color.GREEN);
			g.fillRect((int)x, (int)y, width, height);
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
	
}
