package sumo;

import java.awt.Rectangle;

public class GameObject {
	float x;
	 float y;
	 int width;
	 int height;
	 int speed = 0;
	 Rectangle collisionBox;
	 
	 GameObject(float x, float y, int width, int height){
		 this.x = x;
		 this.y = y;
		 this.width = width;
		 this.height = height;
		 collisionBox = new Rectangle();
	 }
	 
	 public void update() {
		 collisionBox.setBounds((int)x,(int)y,width,height);
	 }
}
