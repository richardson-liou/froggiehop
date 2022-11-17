package sumo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener,KeyListener{
	final int MENU = 0;
	final int GAME = 1;
	
	
	int currentState = MENU;
	Font titleFont;
    Font subTitle;
    Timer timer;
    Timer platSpawn;
    Player player1 = new Player(200, 600, 50, 50);
    Platform main = new Platform(0,740,300,20);
    ObjectManager objman = new ObjectManager(player1);
    
    GamePanel(){
    	titleFont = new Font("ComicSansMS-BOLD", Font.PLAIN, 30);
    	subTitle = new Font("ComicSansMS", Font.PLAIN, 20);
    	timer = new Timer(1000/60, this);
    	platSpawn = new Timer(10000,objman);
    	
    	timer.start();
    	//platSpawn.start();
    	//Font [] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
    	
    	//for(int i = 0; i<fonts.length; i++) {
    		//System.out.println(fonts[i].getFontName());
    	//}

    }
    
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
		objman.update();
		if (player1.y>800) {
			currentState = MENU;
		}
		
		
	}
	
	public void drawMenu(Graphics g) {
		
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Doodle hop", 120, 600);
		
		g.setFont(subTitle);
		g.setColor(Color.BLACK);
		g.drawString("Press Enter to start", 110, 700);
	}
	
	public void drawGame(Graphics g) {
		int score = objman.getScore();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, FoodleHop.WIDTH, FoodleHop.HEIGHT);
		
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("This is the game", 70, 600);
		g.drawString("Score: "+ score, 120,100);
		
		
		objman.draw(g);
		
		//System.out.println("Drew Game");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenu();
		}else if(currentState == GAME){
		    updateGame();
		}
		//System.out.println("Action");
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(currentState == MENU) {
				currentState = GAME;
				objman.platforms.add(main);
				for(int i = 0; i<5; i++) {
				objman.platformSpawn();
				}
			}
			System.out.println("ENTER");
		}
			if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
				if(player1.x<FoodleHop.WIDTH-50) {
					player1.right = true;
				}
			}
			
			if (e.getKeyCode()==KeyEvent.VK_LEFT) {
				if(player1.x>0) { 
			    player1.left = true;
				}
			}
			
			if (e.getKeyCode()== KeyEvent.VK_SPACE) {
				if(player1.canJump == true) {
					player1.jump();   
					System.out.println(player1.y);
				}
				System.out.println("Player y " +player1.y);
			}
		}
		

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			player1.left = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			player1.right = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
