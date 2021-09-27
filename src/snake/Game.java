package snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Game implements KeyListener {

	private Snake player;
	private Food food;
	private Graphics graphics;
	private JFrame window;
	
	public static final int width = 20;
	public static final int height = 20;
	public static final int dimension = 30;
	
	public Game () {
		window = new JFrame();
		
		player = new Snake();
		food = new Food(player);
		
		graphics = new Graphics(this);
		
		window.add(graphics);
		window.setTitle("Snake");
		window.setSize(width * dimension + 4, height * dimension + 4);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void start() {
		graphics.state = State.RUNNING;
	}
	
	public void update() {
		if(graphics.state == State.RUNNING) {
			if(checkFoodCollision()) {
				player.grow();
				food.randomSpawn(player);
			}
			else if(checkWallCollision() || selfCollision()) {
				graphics.state = State.END;
			}
			else {
				player.move();
			}
		}
	}
	
	private boolean checkWallCollision() {
		if(player.xPosition() < 0 || player.xPosition() >= width * dimension 
				|| player.yPosition() < 0 || player.xPosition() >=  height * dimension) {
			return true;
		}
		return false;
	}
	
	private boolean checkFoodCollision() {
		if(player.xPosition() == food.getX() * dimension 
				&& player.yPosition() == food.getY() * dimension) {
			return true;
		}
		return false;
	}
	
	private boolean selfCollision() {
		for(int i = 1; i < player.getBody().size(); i++) {
			if(player.xPosition() == player.getBody().get(i).x 
					&& player.yPosition() == player.getBody().get(i).y ) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		int keyCode = arg0.getKeyCode();
		
		if(graphics.state == State.RUNNING) {
			
			if(keyCode == KeyEvent.VK_W && player.getMove() != Move.DOWN) {
				player.up();
			}
			else if(keyCode == KeyEvent.VK_S && player.getMove() != Move.UP) {
				player.down();
			}
			else if(keyCode == KeyEvent.VK_A && player.getMove() != Move.RIGHT) {
				player.left();
			}
			else if (keyCode == KeyEvent.VK_D && player.getMove() != Move.LEFT){
				player.right();
			}
		}
		else {
			this.start();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public Snake getPlayer() {
		return player;
	}

	public void setPlayer(Snake player) {
		this.player = player;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public JFrame getWindow() {
		return window;
	}

	public void setWindow(JFrame window) {
		this.window = window;
	}
}
