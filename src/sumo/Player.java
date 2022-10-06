package sumo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject{
	public boolean left = false;
	public boolean right = false;
	
	private float xVelocity = 0;
	
	private float gravity = 0.001f;
	private float yVelocity = 0;
	private int jumpPower = 20;
	

	boolean canJump = false;
	
	public Player(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		collisionBox.setBounds(x, y, width, height);
	}
	
	public void update() {
		if(left){
			xVelocity = -speed;
			System.out.println("LEFTING");
		}
		if(right){
			xVelocity = speed;
			
		}
		
		yVelocity += gravity;
		y += yVelocity;
		x += xVelocity;
		xVelocity *= 0.999;
		
	}
	
	public void jump(){
		if(canJump){
			yVelocity -= jumpPower;
			canJump = false;
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
	
}
