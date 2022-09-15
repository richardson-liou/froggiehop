package sumo;

import javax.swing.JFrame;

public class FoodleHop {
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
	}
	
	public static void main(String[] args) {
		FoodleHop doodle = new FoodleHop();
		doodle.setup();
	}
}


