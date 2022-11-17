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
	int score = 0;
	
	ObjectManager(Player p){
		player = p;
	}
	
	public int getScore() {
		return score;
	}
	
	
	public void addPlatform(Platform p) {
		platforms.add(p);
	}
	
	public void update() {
		for(Platform p : platforms){
			p.update();
			if(p.isActive = true) {
				score+=1;
				p.isActive = false;
			}
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
		int randomx = rand.nextInt(400);
		int randomy = 0;
		int lastPlat = platforms.size()-1;

				if(lastPlat-1>=0) {
					Platform p = platforms.get(lastPlat);
					randomy =(int) (rand.nextInt(150)+p.y);
					//if(randomy <= p.y + 30 || randomy >=p.y -30) {
						//andomy -=50;
					//}
				}
				else {
					Platform p = platforms.get(lastPlat);
					randomy = rand.nextInt((int) p.y);
				}
				 
			Platform plat = new Platform(randomx,randomy,100,20);
			platforms.add(plat);
		
		
		}
		
		
		//}
		

	
	public void checkCollision() {
		boolean isOnGround = false;
		
		for(int i = 0; i<platforms.size(); i++) {
			Platform p = platforms.get(i);	
			if(player.collisionBox.intersects(p.collisionBox)){
				
				//player.canJump = true;
				//if(player.y < p.y -30) {
					//player.yVelocity = 0; 
				//isOnGround = true;
				
				handleCollision(p);
				
				}
			//}
			//else {
				           
			//}
	}
		player.isOnGround = isOnGround;
		
		
		if(player.x > FoodleHop.WIDTH) {
			player.x = 0;
		}
		else if (player.x<0) {
			player.x = FoodleHop.WIDTH;
		}
	
}
	private void handleCollision(Platform p){
		if(player.getYVelocity() >= 0 && player.getY() + player.getHeight() < p.getY() + 25){
			player.setYLimit(p.getY() - player.getHeight());
		}else{
			player.setYLimit(500);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//platformSpawn();
		
	}
}
