package snake;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Snake {

	private ArrayList<Rectangle> body;
	private int w = Game.width;
	private int h = Game.height;
	private int d = Game.dimension;
	
	private Move move;
	
	public Snake () {
		body = new ArrayList<>();
		
		Rectangle temp = new Rectangle (d, d);
		temp.setLocation(w /2 * d, h / 2 * d);
		body.add(temp);
		
		temp = new Rectangle(d, d);
		temp.setLocation(((w /2) - 1) * d, (h /2 ) * d);
		body.add(temp);
		
		temp = new Rectangle(d, d);
		temp.setLocation(((w /2) - 2) * d, (h /2 ) * d);
		body.add(temp);
		
		move = Move.NOTHING;
	}

	public void move() {
		if(move != Move.NOTHING) {
			Rectangle first = body.get(0);
			
			Rectangle temp = new Rectangle(Game.dimension, Game.dimension);
			
			if(move == Move.UP) {
				temp.setLocation(first.x, first.y - Game.dimension);
				
			}
			else if(move == Move.DOWN) {
				temp.setLocation(first.x, first.y + Game.dimension);
			}
			else if(move == Move.LEFT) {
				temp.setLocation(first.x - Game.dimension, first.y);
			} 
			else {
				temp.setLocation(first.x + Game.dimension, first.y);
			}
			
			body.add(0, temp);
			body.remove(body.size() - 1);
		}
	}
	
	public void grow() {
		Rectangle first = body.get(0);
		
		Rectangle temp = new Rectangle(Game.dimension, Game.dimension);
		
		if(move == Move.UP) {
			
			temp.setLocation(first.x, first.y - Game.dimension);
			
		}
		else if(move == Move.DOWN) {
			temp.setLocation(first.x, first.y + Game.dimension);
		}
		else if(move == Move.LEFT) {
			temp.setLocation(first.x - Game.dimension, first.y);
		} 
		else {
			temp.setLocation(first.x + Game.dimension, first.y);
		}
		
		body.add(0, temp);
	}
	
	public ArrayList<Rectangle> getBody() {
		return body;
	}

	public void setBody(ArrayList<Rectangle> body) {
		this.body = body;
	}
	
	public Move getMove() {
		return move;
	}
	
	public void up() {
		if(move != Move.DOWN) {
			move = Move.UP;			
		}
	}
	
	public void down() {
		if(move != Move.UP) {
			
			move = Move.DOWN;
		}
	}
	
	public void left() {
		if(move != Move.RIGHT) {
			
			move = Move.LEFT;
		}
	}
	
	public void right() {
		if(move != Move.LEFT) {
	
			move = Move.RIGHT;
		}
	}
	
	public int xPosition() {
		return body.get(0).x;
	}
	
	public int yPosition() {
		return body.get(0).y; 
	}
}

