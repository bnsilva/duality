package entities;

import gameStates.MyBasicGameState;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class Wall extends Entity{
	
	public Wall(float posX, float posY, float tamX, float tamY){
		this.posX = posX;
		this.posY = posY;
		collisionBox = new Rectangle(posX, posY, tamX, tamY);
	}

	@Override
	public void onUpdate(GameContainer gc, MyBasicGameState sbg, int delta) {
		collisionBox.setLocation(posX, posY);
	}

	@Override
	public void onRender(GameContainer gc, MyBasicGameState sbg, Graphics g) {
		
	}

	@Override
	public String toString() {
		return "Wall";
	}
	
}
