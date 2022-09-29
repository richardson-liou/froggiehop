package sumo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class FoodleHop implements ActionListener{
	JFrame frame;
	
	GamePanel panel = new GamePanel();
	
	public static final int WIDTH = 400;
	public static final int HEIGHT = 800;
	
	FoodleHop(){
		frame = new JFrame();
	}
	public void setup() {
		frame.add(panel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(panel);
	}
	
	public static void main(String[] args) {
		FoodleHop doodle = new FoodleHop();
		doodle.setup();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}


