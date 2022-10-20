package sumo;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectManager implements ActionListener{
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
	
	public void platformSpawn() {
		Random rand = new Random();
		for(int i = 0; i<5; i++) {
		int randomx = rand.nextInt(400);
		int randomy = rand.nextInt(700);
		
		Platform plat = new Platform(randomx,randomy,100,20);
		platforms.add(plat);
		
		}
		
		for(int k = 0; k<platforms.size(); k++) {
			Platform p = platforms.get(k);
			//if(p.x >=rand1 +30 &&p.x<= rand1-30 && p.y >=rand2+60 && p.y <= rand2-60) {
				
			}
		//}
		}

	
	public void checkCollision() {
		boolean isOnGround = false;
		for(int i = 0; i<platforms.size(); i++) {
			Platform p = platforms.get(i);	
			if(player.collisionBox.intersects(p.collisionBox)){
				player.yVelocity = 0; 
				player.canJump = true;
				if(player.y < p.y && player.y>p.y-70) {
				isOnGround = true;
				System.out.println("Collided");
				}
			}
			else {
				           
			}
	}
		player.isOnGround = isOnGround;
		
		
		if(player.x > FoodleHop.WIDTH) {
			player.x = 0;
		}
		else if (player.x<0) {
			player.x = FoodleHop.WIDTH;
		}
	
}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//platformSpawn();
		
	}
}
