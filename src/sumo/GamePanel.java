package sumo;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	final int MENU = 0;
	final int GAME = 1;
	int currentState = MENU;
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenu(g);
		}else if(currentState == GAME){
		    drawGame(g);
		}
		}
	
	
	void updateMenu(){
		
	}
	
	public void updateGame() {
		
	}
	
	public void drawMenu(Graphics g) {
		
	}
	
	public void drawGame(Graphics g) {
	
	}
	
	
}
