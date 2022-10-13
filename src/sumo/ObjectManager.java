package sumo;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class ObjectManager {
	Player player;
	List<Platform> platforms = new ArrayList();
	
	ObjectManager(Player p){
		player = p;
	}
	
	public void addPlatform(Platform p) {
		platforms.add(p);
	}
	
	public void update() {
		for(Platform p : platforms){
			p.update();
		}
		player.update();
		checkCollision();
	}
	public void draw(Graphics g) {
		player.draw(g);
		for(int i = 0; i <platforms.size(); i++) {
			Platform p = platforms.get(i);
			p.draw(g);
		}
	}
	
	public void checkCollision() {
		for(int i = 0; i<platforms.size(); i++) {
			Platform p = platforms.get(i);	
			if(player.collisionBox.intersects(p.cbox)){
				player.yVelocity = 0; 
				player.gravity = 0;
				player.canJump = true;
				System.out.println("Collided");
			}
			else {
				player.gravity = 1;
			}
	}
		if(player.x > FoodleHop.WIDTH) {
			player.x = 0;
		}
		else if (player.x<0) {
			player.x = FoodleHop.WIDTH;
		}
	
}
}
