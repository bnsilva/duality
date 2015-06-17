package entities;

import java.util.Arrays;

import gameStates.MyBasicGameState;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Pickup extends Entity{
	private static int id;
	
	private Shape circle;
	private int radius = 10;
	
	public Pickup(float posX, float posY) {
		this.posX = posX;
		this.posY = posY;
		
		circle = new Circle(posX, posY, radius);
		collisionBox = new Rectangle(posX - radius, posY - radius, posX + radius, posY + radius);
		collisionBox.setSize(radius * 2, radius * 2);
	}

	@Override
	public void onUpdate(GameContainer gc, MyBasicGameState sbg, int delta) {
		
	}

	@Override
	public void onRender(GameContainer gc, MyBasicGameState sbg, Graphics g) {
			g.fill(circle);
			g.setColor(new Color(Color.yellow));
			g.draw(circle);
	}
	
	public String toString() {
		return "Pickup";
	}
	
	public static int getId(){
		return id;
	}
}
