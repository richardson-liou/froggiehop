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
    Player player1 = new Player(200, 750, 70, 70);
    
    GamePanel(){
    	titleFont = new Font("ComicSansMS-BOLD", Font.PLAIN, 30);
    	subTitle = new Font("ComicSansMS", Font.PLAIN, 20);
    	timer = new Timer(1000/60, this);
    	
    	timer.start();
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
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, FoodleHop.WIDTH, FoodleHop.HEIGHT);
		
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("This is the game", 120, 600);
		
		player1.draw(g);
		System.out.println("Drew Game");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenu();
		}else if(currentState == GAME){
		    updateGame();
		}
		System.out.println("Action");
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(currentState == MENU) {
				currentState = GAME;
			}
			System.out.println("ENTER");
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
